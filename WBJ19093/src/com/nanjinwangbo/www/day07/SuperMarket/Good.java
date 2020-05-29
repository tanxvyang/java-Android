package com.nanjinwangbo.www.day07.SuperMarket;

public class Good {
    //静态
    //属性
    String goodName;
    double price;
    int nums;

    // 动态
    public Good(String goodName, double price, int nums) {
        this.goodName = goodName;
        this.price = price;
        this.nums = nums;
    }


    public Good() {

    }


    /**
     * 商品自我介绍
     */
    public String introduct() {
        return "商品名 ：" + goodName + "，价格：" + price + "元，库存" + nums;
    }


    public String getGoodName() {
        return goodName;
    }


    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public int getNums() {
        return nums;
    }


    public void setNums(int nums) {
        this.nums = nums;
    }


}
