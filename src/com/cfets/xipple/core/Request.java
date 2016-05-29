package com.cfets.xipple.core;

import java.util.Random;

/**
 * Created by ZYC on 2016/5/28.
 */
public class Request {

    private String id;

    private String command;

    protected Request() {
    }

    public Request(String command) {
        this.id = String.valueOf(new Random().nextLong());
        this.command = command;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
