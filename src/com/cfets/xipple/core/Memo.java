package com.cfets.xipple.core;

/**
 * Created by ZYC on 2016/5/29.
 */
public class Memo {

    private String type;

    private String format = "plain/text";

    private String data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
