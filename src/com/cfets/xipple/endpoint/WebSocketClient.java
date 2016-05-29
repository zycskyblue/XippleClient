package com.cfets.xipple.endpoint;

import com.cfets.xipple.core.Request;
import com.cfets.xipple.core.Response;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ZYC on 2016/5/27.
 */
public abstract class WebSocketClient {

    private Session session;

    private ConcurrentMap<String, Request> requests;

    protected WebSocketClient(){
        requests = new ConcurrentHashMap<String, Request>();
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
    public void onOpen(Session session) {
        System.out.println("opened websocket");
        this.session = session;
    }

    @OnMessage
    public void onMessage(Response response){
        String id = response.getId();
        if(requests.containsKey(id)){
            Request request = requests.remove(id);
            onResponse(response, request);
        }
        else {
            onResponse(response, null);
        }
    }

    @OnClose
    public void onClose(CloseReason reason) {
        System.out.println(reason.toString());
        session = null;
        requests.clear();
    }

    protected abstract void onResponse(Response response, Request request);

    public void send(Request request) {
        if (session == null || request.getId() == null || requests.containsKey(request.getId()))
            return;
        try {
            session.getBasicRemote().sendObject(request);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncodeException e) {
            e.printStackTrace();
        }
        requests.put(request.getId(), request);
    }

    public void Close() throws IOException {
        if(session != null){
            session.close();
        }
    }
}
