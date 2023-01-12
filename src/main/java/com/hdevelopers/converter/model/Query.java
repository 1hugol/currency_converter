package com.hdevelopers.converter.model;

import com.hdevelopers.converter.enums.Currency;

public class Query {
    private String amount;
    private Currency from;
    private Currency to;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Currency getFrom() {
        return from;
    }

    public void setFrom(Currency from) {
        this.from = from;
    }

    public Currency getTo() {
        return to;
    }

    public void setTo(Currency to) {
        this.to = to;
    }
}
