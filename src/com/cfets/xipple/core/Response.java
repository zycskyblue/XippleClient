package com.cfets.xipple.core;

import java.util.Map;

/**
 * Created by ZYC on 2016/5/29.
 */
public class Response {

    private String id;

    private String status;

    private String type;

    private String error;

    private Map result;

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public Map getResult() {
        return result;
    }

    public String getError() {
        return error;
    }
}
