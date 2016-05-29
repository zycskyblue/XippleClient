package com.cfets.xipple.endpoint;

import com.cfets.xipple.core.*;
import com.cfets.xipple.core.type.SubmitRequest;
import com.cfets.xipple.core.type.Transaction;

import javax.websocket.*;
import java.math.BigDecimal;

/**
 * Created by ZYC on 2016/5/23.
 */

@ClientEndpoint(encoders = {Codec.class}, decoders = {Codec.class})
public class XippleWebSocketClient extends WebSocketClient {

    public void createPayment() {

        SubmitRequest pay = new SubmitRequest();
        pay.setId("IRS0001");
        pay.setSecret("spjBEL6dVQip5hGUNj7HcBmCV6B4s");

        Transaction t = new Transaction();
        t.setAccount("rLtNovmk4CWD2LnAnQ6wA2wMREE49VL268");
        t.setDestination("rDp9sAts5XvhHFstbXw7shXSKW7kkMBJLi");
        t.setAmount(new BigDecimal(10000000));
        t.setFee(new BigDecimal(10000));

        pay.setTx_json(t);
        this.send(pay);

        //this.sendMessage("{ \"id\": 2, \"command\": \"submit\", \"tx_json\" : { \"TransactionType\" : \"Payment\", \"Account\" : \"rLtNovmk4CWD2LnAnQ6wA2wMREE49VL268\", \"Destination\" : \"rDp9sAts5XvhHFstbXw7shXSKW7kkMBJLi\", \"Amount\" : \"10000000\" , \"Fee\" : \"10000\" }, \"memos\" : [ { \"type\": \"test\", \"format\": \"plain/text\", \"data\": \"texted data\" } ] , \"secret\" : \"spjBEL6dVQip5hGUNj7HcBmCV6B4s\" }");
        //this.sendMessage("{ \"id\": 3, \"command\": \"tx\", \"transaction\": \"2312C403D6078A66658C146F98D219A08705372BB65527E1521FBC4A0E56000D\", \"binary\": false }");
    }

    @Override
    protected void onResponse(Response response, Request request) {
        System.out.print(response.getStatus());
    }
}
