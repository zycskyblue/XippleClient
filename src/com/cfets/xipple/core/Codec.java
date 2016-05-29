package com.cfets.xipple.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.*;

/**
 * Created by ZYC on 2016/5/28.
 */
public class Codec implements Encoder.Text<Request>, Decoder.Text<Response> {

    private GsonBuilder _gb;

    @Override
    public String encode(Request abstractRequest) throws EncodeException {
        Gson gson = _gb.create();
        return gson.toJson(abstractRequest);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        _gb = new GsonBuilder();
    }

    @Override
    public void destroy() {

    }

    @Override
    public Response decode(String s) throws DecodeException {
        Gson gson = _gb.create();
        return gson.fromJson(s, Response.class);
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }
}
