package com.ttb.dao;

import java.util.List;

import com.ttb.entity.Good;

public interface GoodDao {
	public List<Good> selectGoodsByGoodName(String goodName);

	public void updateGood(Good good);

	public Good selectGoodByGoodName(String goodName);
	
	public Good selectGoodByGid(Integer gid);

	public void insertGood(Good good);

	public void deleteGood(Integer gid);
	
	
}
