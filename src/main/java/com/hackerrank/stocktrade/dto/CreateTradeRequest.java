package com.hackerrank.stocktrade.dto;

import com.hackerrank.stocktrade.model.User;

import java.sql.Timestamp;

public class CreateTradeRequest {

    Long id;
    User user;
    String type;
    String symbol;
    Integer shares;
    Float price;
    String timestamp;

    public CreateTradeRequest(Long id, User user, String type, String symbol, Integer shares, Float price, String timestamp) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
        this.timestamp = timestamp;
    }

    public CreateTradeRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
