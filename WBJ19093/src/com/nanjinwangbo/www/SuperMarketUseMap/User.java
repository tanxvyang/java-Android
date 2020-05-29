package com.nanjinwangbo.www.SuperMarketUseMap;

public class User {
    private String username;
    private String password;
    private Double money;

    public User() {

    }

    public User(String username, String password, Double money) {
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
