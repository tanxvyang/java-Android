package com.nanjinwangbo.www.day07.SuperMarket;

import java.util.Scanner;

public class ShopSystem {
	Shop shop;
	public void startSystem(){
		Scanner sc = new Scanner(System.in);
		while (true) {
		System.out.println("请输入命令");
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				shop.showGood();
				break;
			case 2:
				Good good = null;
				int num =0 ;
				while (true) {
					System.out.println("请输入购买名称");
					String goodName = sc.next();
					good = shop.getGoodByGoodName(goodName);
					if (good==null) {
						System.out.println("商品不存在");
						continue;
					}
					if (good.getNums() == 0) {
						System.out.println("库存不足");
						continue;
					}
					break;
				}
				while (true) {
					System.out.println("数量");
					 num = sc.nextInt();
					 if (num <=0) {
						System.out.println("不能为负数");
						continue;
					}
					 break;
				}
				shop.shopping(good, num);
			case 3:
				double goodPriceTypeIn;
				String goodNameTypeIn;
				int  goodNumTypeIn;
				while (true) {
					System.out.println("请输入新商品名");
				 goodNameTypeIn = sc.next();
				if (null == goodNameTypeIn||"".equals(goodNameTypeIn)) {
					System.out.println("商品名不能为空");
				}
				if(shop.getGoodByGoodName(goodNameTypeIn) != null){
					System.out.println("商品名重名");
					continue;
				}
				break;
				}
				
				while (true) {
					System.out.println("请输入新商品价格");
					goodPriceTypeIn = sc.nextDouble();
					if (goodPriceTypeIn < 0) {
						System.out.println("价格不可为负");
						continue;
					}
					break;
				}
				while (true) {
					System.out.println("请输入新商品库存");
					goodNumTypeIn = sc.nextInt();
					if (goodNumTypeIn < 0) {
						System.out.println("库存不可为负");
						continue;
					}
					break;
				}
				Good good1 = new Good(goodNameTypeIn,goodPriceTypeIn,goodNumTypeIn);
				shop.addGood(good1);
				break;
			case 4:
				String deleteName;
				while (true) {
					System.out.println("输入需要删除的商品名！");
					deleteName = sc.next();
					if (shop.getGoodByGoodName(deleteName) != null) {
						System.out.println("商品不存在，重新输入");
						continue;
					}
					break;
				}
				shop.removeGood(deleteName);
				break;
			case 5:
				System.out.println("谢谢使用，下次再见！");
				break;
			}
		}
	}
}
