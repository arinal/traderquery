package com.traderquery;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    String traderId;
    long timestamp;
    BigDecimal value;

    Date getDate() {
        return new Date(timestamp * 1000);
    }

    @Override
    public String toString() {
        return "Date: " + getDate() + ", Value: " + value + ", Trader: " + traderId;
    }
}
