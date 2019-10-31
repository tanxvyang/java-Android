package com.nanjinwangbo.www.SuperMarketUseMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShopSystem {
//	1、存储用户和店铺信息
	List<User> users;
	List<Shop> shops;

	public ShopSystem(){
		
	}

	public ShopSystem(List<User> users, List<Shop> shops) {
		this.users = users;
		this.shops = shops;
	}
	/**
	 * 用户登录
	 * @return
	 */
	public User Login(String username,String password){
		for (User user : users) {
			if(user.getUsername().equals(username)&&
			   user.getPassword().equals(password)){
				return user;//如果用户名和密码都匹配返回用户
			}
		}
		return null;//如果登录失败返回null
	}
	
	public void start(){
		Scanner sc = new Scanner(System.in);//接受用户命令
		while(true){
			System.out.println("欢迎使用本系统");
			System.out.println("请输入菜单编号");
			System.out.println("1、查看所有商品");
			System.out.println("2、根据名称查看单个商品");
			System.out.println("3、购买商品");
			System.out.println("4、上架商品");
			System.out.println("5、下架商品");
			System.out.println("6、退出");
			switch (sc.nextInt()) {
			case 1:
				//查看商品 --> 查看所有商店的所有商品
				//System.out.println("---------");
				for (int i = 0; i < shops.size(); i++) {
					System.out.println(shops.get(i).getLogo()+"提供了以下商品");
					shops.get(i).showGoods();
				}
				break;
			case 2:
				System.out.println("请输入您要选择的店铺名称：");
				Shop choosedShop = null;
				while (true) {
					String shopName = sc.next();
					for (int i = 0; i < shops.size(); i++) {
						if(shops.get(i).getLogo().equals(shopName)){
							choosedShop = shops.get(i);
							break;
						}
					}
					if(choosedShop == null){
						System.out.println("按照店名未找到店铺请重新输入");
					}else{
						break;
					}
				}

				choosedShop.showGoods();

				System.out.println("请输入您要详细查看的商品名称：");
				while (true) {
					String goodName = sc.next();
					Good good = choosedShop.selectGoodByTitle(goodName);
					if(good == null){
						System.out.println("按照商品名称未找到对应商品信息请重新输入");
					}else{
						System.out.println("该商品的详细信息：");
						System.out.println(good);
						break;
					}
				}
				break;
			case 3:
				System.out.println("请输入您要购买的商品");
				Shop choosedShop2 = null;
				while (true){
					String goodName = sc.next();
					for (int i = 0; i < shops.size(); i++) {
							choosedShop2 = shops.get(i);// 获得所有店铺

					}
					Good good =choosedShop2.selectGoodByTitle(goodName);

					if (good == null){		//确定是否有商品
						System.out.println("按照商品名称未找到对应商品信息请重新输入");
					}else {
						System.out.println("请输入要购买的商品数量");
						Map<Good,Integer> goods = new HashMap<>();
						goods.put(good,sc.nextInt());

						//判断是否买完(未完成)



						//判断顾客账户余额足后
						/*结账流程:  确定库存是否足够-->如果不够则修改订单数量-
											->计算订单价格顾客-->顾客付款-->修改顾客账户金额-
												->商家收款-->修改商家账户金额--> 完成出售,修改仓库
												*/
						choosedShop2.sell(goods);
						System.out.println("顾客支付");//修改客户账户金额
						System.out.println("商家收款");//收款   修改商家账户金额(分别修改,因为可能有多个店铺的商品)
						//
						break;
					}

				}
				break;
			case 4:
				//上架商品

				System.out.println("请输入您要选择的店铺名称：");
				Shop choosedShopStoredOrModify = null;
				while (true) {
					String shopName = sc.next();
					for (int i = 0; i < shops.size(); i++) {
						if(shops.get(i).getLogo().equals(shopName)){
							choosedShopStoredOrModify = shops.get(i);
							break;
						}
					}
					if(choosedShopStoredOrModify == null){
						System.out.println("按照店名未找到店铺请重新输入");
					}else{
						break;
					}
				}
				while (true){

					System.out.println("请输入商品名,价格,数量");
					Good good = new Good(sc.next(),sc.nextDouble());
					Integer num = sc.nextInt();
					if (choosedShopStoredOrModify.selectGoodByTitle(good.getTitle())!=null){
						System.out.println("商品存在,是否修改信息?\n 1.是 \n 2.否");
						if (sc.next().equals("1")){

							choosedShopStoredOrModify.storedOrModify(good,num);
							choosedShopStoredOrModify.selectGoodByTitle(good.getTitle()).setPrice(good.getPrice());

						}/*else {
							break;
						}*/
					}else{
						choosedShopStoredOrModify.storedOrModify(good,num);
					}
					System.out.println("是否继续添加\n" +
							"1.是\n2.否");
					if (sc.next().equals("1")){
						continue;
					}

					break;
				}
				break;
			case 5:
				//下架
				System.out.println("请输入您要选择的店铺名称：");
				Shop choosedShopRemove = null;
				while (true) {
					String shopName = sc.next();
					for (int i = 0; i < shops.size(); i++) {
						if(shops.get(i).getLogo().equals(shopName)){
							choosedShopRemove = shops.get(i);
							break;
						}
					}
					if(choosedShopRemove == null){
						System.out.println("按照店名未找到店铺请重新输入");
					}else{
						break;
					}
				}
				while (true){

					System.out.println("请输入要下架的商品名");
					Good good =new Good();
					good.setTitle(sc.next());

					if (choosedShopRemove.selectGoodByTitle(good.getTitle())==null){
						System.out.println("商品:"+good.getTitle()+"不存在\n"
								+"是否继续删除?\n"
								+"1.是  2.否");
						if (sc.next().equals("1")){
							continue;
						}else{
							break;
						}
					}else{
						choosedShopRemove.remove(good);
						System.out.println("商品:"+good.getTitle()+"已删除\n"
								+"是否继续删除?\n"
								+"1.是  2.否");
						if (sc.next().equals("1")){
							continue;
						}else{
							break;
						}
					}

				}
				break;
			case 6:
				System.out.println("感谢使用本系统，正在退出");
				return;
			default:
				System.out.println("输入的指令无效，请重新输入");
				break;
			}
		}
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
}
