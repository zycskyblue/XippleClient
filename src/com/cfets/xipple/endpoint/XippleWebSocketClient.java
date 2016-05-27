package com.cfets.xipple.endpoint;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

/**
 * Created by ZYC on 2016/5/23.
 */

@ClientEndpoint
public class XippleWebSocketClient {

    private Session userSession = null;

    public XippleWebSocketClient(){

    }

    public void connect(String endpointURI){
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
        System.out.println("opened websocket");
        this.userSession = userSession;
        this.sendMessage("{\"id\": 1, \"command\": \"server_info\"}");

        this.sendMessage("{ \"id\": 2, \"command\": \"submit\", \"tx_json\" : { \"TransactionType\" : \"Payment\", \"Account\" : \"rLtNovmk4CWD2LnAnQ6wA2wMREE49VL268\", \"Destination\" : \"rDp9sAts5XvhHFstbXw7shXSKW7kkMBJLi\", \"Amount\" : \"10000000\" , \"Fee\" : \"10000\" }, \"memos\" : [ { \"type\": \"test\", \"format\": \"plain/text\", \"data\": \"texted data\" } ] , \"secret\" : \"spjBEL6dVQip5hGUNj7HcBmCV6B4s\" }");
        //this.sendMessage("{ \"id\": 3, \"command\": \"tx\", \"transaction\": \"2312C403D6078A66658C146F98D219A08705372BB65527E1521FBC4A0E56000D\", \"binary\": false }");

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
        try {
            userSession.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Close() throws IOException {
        this.userSession.close();
    }

}
