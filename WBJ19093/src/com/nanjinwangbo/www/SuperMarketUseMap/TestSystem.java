package com.nanjinwangbo.www.SuperMarketUseMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSystem {
    public static void main(String[] args) {
        Shop shop = new Shop();
        List<Shop> shops = new ArrayList<>();
        //Good good = new Good("矿泉水",2.0);
        List<Good> goods = new ArrayList<>();
        Good good = new Good("矿泉水", 2.0);
        goods.add(good);
        Map<Good, Integer> store = new HashMap<>();
        store.put(goods.get(0), 10);
        shop.setStore(store);
        shop.setLogo("天猫");
        shops.add(shop);
        ShopSystem shopSystem = new ShopSystem();
        shopSystem.shops = shops;
        shopSystem.start();

    }
}
