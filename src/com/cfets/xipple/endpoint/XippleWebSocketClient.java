package com.cfets.xipple.endpoint;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

/**
 * Created by ZYC on 2016/5/23.
 */

@ClientEndpoint
public class XippleWebSocketClient {

    Session userSession = null;

    public XippleWebSocketClient(String endpointURI) {
        try {
            URI _endpointURI = URI.create(endpointURI);
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, _endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @OnOpen
    public void onOpen(Session userSession) {
        System.out.println("opening websocket");
        this.userSession = userSession;
        this.sendMessage("{\"id\": 1, \"command\": \"server_info\"}");
    }

    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        System.out.println("closing websocket");
        this.userSession = null;
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println(message);
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }


    public void sendMessage(String message) {
        this.userSession.getAsyncRemote().sendText(message);
    }

    public void Close() throws IOException {
        this.userSession.close();
    }

}
