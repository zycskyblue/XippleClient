package com.cfets.xipple.core;

/**
 * Created by ZYC on 2016/5/28.
 */
public class Request {

    private String id;

    private String command;

    public Request() {
    }

    public Request(String command) {
        this.id = "123";
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
