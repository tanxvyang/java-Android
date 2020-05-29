package com.nanjinwangbo.www.day07.SuperMarket;


public class Shop {
    private String shopName;
    private String address;
    private Good[] goods;

    /**
     * 查看所有商品
     */
    public void showGood() {

        for (Good good : goods) {
            if (good != null) {

                System.out.println();
            } else {
                System.out.println("============此位商品暂缺===========");

            }
        }
    }

    /***
     * 购买
     */
    public void shopping(Good good, int num) {
        if (num < 1) {
            System.out.println("数量不正确");
            return;
        }

        if (good == null) {
            System.out.println("你购买的商品名为空，从新输入");
            return;
        } else {
            good.setNums(num);
            System.out.println("您购买了" + num + "个" + good.getGoodName());
        }

    }

    /***
     * 删除
     */

    public void removeGood(String goodName) {
        int index = -1;
        for (int i = 0; i < goods.length; i++) {
            if (goods[i].getGoodName().equals(goodName)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("未找到商品");
            return;
        }
        //从数组中移除指点下标
        for (int i = index; i < goods.length - 1; i++) {
            if (goods[i + 1] == null) {
                goods[i] = goods[i + 1];

            }
        }
        goods[goods.length - 1] = null;
    }

    /***
     *添加
     */
    public void addGood(Good good) {
        //判断是否有空位
        if (goods[goods.length - 1] != null) {
            System.out.println("");
            return;
        }
        //获取商品下标
        int index = -1;
        for (int i = 0; i < goods.length; i++) {
            if (goods[i] == null) {
                index = i;
                break;
            }
        }
        goods[index] = good;

    }


    /**
     * 根据商品名获取信息
     */
    public Good getGoodByGoodName(String goodName) {
        for (int i = 0; i < goods.length; i++) {
            if (goods[i] != null && goods[i].getGoodName().equals(goodName)) {
                return goods[i];
            }

        }
        return null;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setGoods(Good[] goods) {
        this.goods = goods;
    }

    public Good[] getGoods() {
        return goods;
    }

}
