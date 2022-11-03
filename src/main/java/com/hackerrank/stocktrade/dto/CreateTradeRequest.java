package com.hackerrank.stocktrade.dto;

import com.hackerrank.stocktrade.model.User;

public class CreateTradeRequest {

    Long id;
    User user;
    String type;
    String symbol;
    Integer shares;
    Float price;

    String userName;


    public CreateTradeRequest(Long id, User user, String type, String symbol, Integer shares, Float price, String userName) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
