package com.cfets.xipple.core.type;

import java.math.BigDecimal;

/**
 * Created by ZYC on 2016/5/29.
 */
public class Transaction {

    private String TransactionType = "Payment";

    private String Account;

    private String Destination;

    private BigDecimal Amount;

    private BigDecimal Fee;

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public BigDecimal getFee() {
        return Fee;
    }

    public void setFee(BigDecimal fee) {
        Fee = fee;
    }
}
