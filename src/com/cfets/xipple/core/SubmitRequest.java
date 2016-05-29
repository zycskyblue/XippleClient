package com.cfets.xipple.core;

import java.util.List;

/**
 * Created by ZYC on 2016/5/29.
 */
public class SubmitRequest extends Request {

    public SubmitRequest() {
        super("submit");
    }

    private Transaction tx_json;

    private List<Memo> memos;

    private String secret;

    public void setTx_json(Transaction tx_json) {
        this.tx_json = tx_json;
    }

    public void setMemos(List<Memo> memos) {
        this.memos = memos;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
