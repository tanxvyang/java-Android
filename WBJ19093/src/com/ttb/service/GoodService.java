package com.ttb.service;

import java.util.List;

import com.ttb.entity.Good;
import com.ttb.entity.User;
import com.ttb.exception.GoodAlreadyExistException;
import com.ttb.exception.GoodNotFoundException;
import com.ttb.exception.MoneyNotEnoughException;
import com.ttb.exception.StoreNotEnoughException;

public interface GoodService {
	public List<Good> queryGoodsByGoodName(String goodName);

	public void buy(User user, Good good, Integer buyNums) throws StoreNotEnoughException, MoneyNotEnoughException;

	//	1、上架商品（上架的时候要考虑到从店铺中扣取货款）
	public void addGood(Good good) throws GoodAlreadyExistException, MoneyNotEnoughException;
	
//	2、下架商品（退回货款）
	public void removeGood(Integer gid) throws GoodNotFoundException;
}
