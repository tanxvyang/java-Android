package com.ttb.service.impl;

import java.util.List;

import com.ttb.dao.GoodDao;
import com.ttb.dao.UserDao;
import com.ttb.dao.impl.GoodDaoImpl;
import com.ttb.dao.impl.UserDaoImpl;
import com.ttb.entity.Good;
import com.ttb.entity.User;
import com.ttb.exception.GoodAlreadyExistException;
import com.ttb.exception.GoodNotFoundException;
import com.ttb.exception.MoneyNotEnoughException;
import com.ttb.exception.StoreNotEnoughException;
import com.ttb.service.GoodService;
import com.ttb.view.MainFrame;

public class GoodServiceImpl implements GoodService{
	GoodDao gd = new GoodDaoImpl();
	UserDao ud = new UserDaoImpl();

	public List<Good> queryGoodsByGoodName(String goodName){
		return gd.selectGoodsByGoodName(goodName);
	}

	public void buy(User user, Good good, Integer buyNums) throws StoreNotEnoughException, MoneyNotEnoughException {
		//判断购买数量是否大于库存数量
		if(good.getNums()<buyNums){
			throw new StoreNotEnoughException("库存不足");
		}
		//计算总价格
		Double totalPrice = buyNums * good.getGoodPrice();
		//判断用户的余额是否足够进行购买操作
		if(user.getUsermoney() < totalPrice){
			throw new MoneyNotEnoughException("用户余额不足");
		}
		//从用户账户中扣除总价格，并在商店余额中添加总价格
		MainFrame.setShopMoney(MainFrame.getShopMoney()+totalPrice);
		user.setUsermoney(user.getUsermoney() - totalPrice);
		//将用户金额改动写入数据库
		ud.updateUser(user);
		//将商品数量改动写入数据库
		good.setNums(good.getNums() - buyNums);
		gd.updateGood(good);
	}
//	1、上架商品（上架的时候要考虑到从店铺中扣取货款）
	public void addGood(Good good) throws GoodAlreadyExistException, MoneyNotEnoughException{
//		1、验证商品名是否重复
		if(gd.selectGoodByGoodName(good.getGoodName()) != null){
			throw new GoodAlreadyExistException("商品名称重复");
		}
//		2、判断货款是否足够进货
		Double shopMoney = MainFrame.getShopMoney() - good.getGoodPrice() * good.getNums();
		if(shopMoney < 0){
			throw new MoneyNotEnoughException("货款不足");
		}
//		3、将商品放入库中
		gd.insertGood(good);
		MainFrame.setShopMoney(shopMoney);
	}
	
//	2、下架商品（退回货款）
	public void removeGood(Integer gid) throws GoodNotFoundException{
//		1、验证商品是否存在
		Good good = gd.selectGoodByGid(gid);
		if(good == null){
			throw new GoodNotFoundException("商品不存在");
		}
//		2、删除商品
		gd.deleteGood(gid);
//		3、退款
		Double shopMoney = MainFrame.getShopMoney() + good.getGoodPrice() * good.getNums();
		MainFrame.setShopMoney(shopMoney);
	}
}
















