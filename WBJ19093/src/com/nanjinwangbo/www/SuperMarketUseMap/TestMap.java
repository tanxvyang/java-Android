package com.nanjinwangbo.www.SuperMarketUseMap;

import sun.applet.Main;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Good good = new Good();

        Map<Good,Integer> store = new HashMap<>();
        store.put(new Good("矿泉水",2.0), 2);

        System.out.println(store.keySet());

        for (Good goods : store.keySet()) {
            System.out.println(goods.shortToString()+
                    "，库存："+store.get(goods));
        }
        System.out.println(store.keySet().equals(new Good("矿泉水",10.0)));

        //
        // store.put(new Good("矿泉水",10.0), 100);
        //
        // System.out.println(store.keySet());
        //
        // for (Good goods : store.keySet()) {
        //     System.out.println(goods.shortToString()+
        //             "，库存："+store.get(goods));
        // }
    }
}
