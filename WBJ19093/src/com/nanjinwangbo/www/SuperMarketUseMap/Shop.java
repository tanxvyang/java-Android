package com.nanjinwangbo.www.SuperMarketUseMap;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Shop {
    private Map<Good, Integer> store;//每个类型的商品有多少件
    private String logo;//商店的品牌
    private String address;//商店的地址

    //	private Double money;
    public Shop() {
        //无参构造
    }

    public Shop(Map<Good, Integer> store, String logo, String address) {
        this.store = store;
        this.logo = logo;
        this.address = address;
    }//全参构造

    /**
     * 展示所有商品的简介信息和库存
     */
    public void showGoods() {
        System.out.println("========热销商品=========");
        for (Good good : store.keySet()) {
            System.out.println(good.shortToString() +
                    "，库存：" + store.get(good));
        }
    }

    /**
     * 展示商品的详细信息
     */
    public void showGoodDetail(Good good) {
        System.out.println("========详细信息=========");
        System.out.println(good + "，库存：" + store.get(good));
    }

    /**
     * 出售指定商品
     *
     * @param goods 用户要购买的商品及数量
     */
    public void sell(Map<Good, Integer> goods) {
        //判断商品是否存在、数量是否超过库存
        List<Good> goodsToRemove = new ArrayList<Good>();
        for (Good good : goods.keySet()) {//遍历所有用户要买的商品
            //判断商品是否存在
//			if(!store.containsKey(good)){//必须重写equals和hashCode两个方法！
            if (store.get(good) == null) {//必须保证value中正常情况不会出现null
//				System.out.println("名为"+good.getTitle()+"的商品不存在，请检查结账队列后再次结账");
//				return;//出现不存在的商品就退出出售方法
                goodsToRemove.add(good);
//				goods.remove(good);
//				System.out.println("由于"+good.getTitle()+"在仓库中不存在，已从结账队列中移除");
//				出现不存在的商品，将商品移除出结账队列
            }
        }
        for (Good good : goodsToRemove) {
            goods.remove(good);
            System.out.println("由于" + good.getTitle() + "在仓库中不存在，已从结账队列中移除");
        }
        for (Good good : goods.keySet()) {
            //如果商品存在判断库存是否足够
            if (goods.get(good) > store.get(good)) {
//					System.out.println("名为"+good.getTitle()+"的商品购买数量超过库存，不能出售");
//					return;
                System.out.println("名为" + good.getTitle() + "的商品购买数量超过库存，将购买数量调至上限");
                goods.put(good, store.get(good));//修改用户要购买的数量，修改为库存的数量
            }
            //事务统一
        }
        //算价格
        calPrice(goods);


        //客户付款

        //商家收款


        //正式出售商品（削减库存）
        for (Good good : goods.keySet()) {
            //修改库存
//			获取库存数量
            int storeNum = store.get(good);
//			获取购买数量
            int sellNum = goods.get(good);
//			计算新库存数量
            int newStoreNum = storeNum - sellNum;
//			保存新库存数量
            store.put(good, newStoreNum);
//			store.put(good, store.get(good) - goods.get(good));//用库存量 - 买走的数量
        }
    }

    /**
     * 根据商品名称查找商品
     */
    public Good selectGoodByTitle(String title) {
        for (Good good : store.keySet()) {
            if (good.getTitle().equals(title)) {
                return good;
            }
        }
        return null;
    }


    /**
     * 计算消费金额
     *
     * @return 总消费金额
     */
    public Double calPrice(Map<Good, Integer> goods) {
        Double sumPrice = 0.0;
        for (Good good : goods.keySet()) {
            sumPrice = good.getPrice() * goods.get(good);
        }
        System.out.println("您一共消费了：" + sumPrice + "元");
        return sumPrice;
    }

    /**
     * 添加或修改商品库存
     * 如果已存在商品会修改库存数量
     * 如果不存在会添加商品信息
     *
     * @return
     */
    public void storedOrModify(Good good, Integer num) {
        if (store.containsKey(good)) {
            System.out.println("修改库存");
        } else {
            System.out.println("新增商品");
        }
        store.put(good, num);
    }

    /**
     * 删除指定商品
     *
     * @param good 需要删除的商品对象
     */
    public void remove(Good good) {
        store.remove(good);
    }

    //==================get/set方法===================
    public Map<Good, Integer> getStore() {
        return store;
    }

    public void setStore(Map<Good, Integer> store) {
        this.store = store;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
