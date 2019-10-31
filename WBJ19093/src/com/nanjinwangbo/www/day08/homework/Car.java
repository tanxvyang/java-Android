package com.nanjinwangbo.www.day08.homework;

public class Car {
    private String merchant ; //商家
    private String owner;//所有者


    public Car(String merchant, String owner) {
        this.merchant = merchant;
        this.owner = owner;
    }

    public Car() {
    }

    public void introduction(){
        System.out.println("商家:"+getMerchant()+"所有者:"+getOwner());
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


}
