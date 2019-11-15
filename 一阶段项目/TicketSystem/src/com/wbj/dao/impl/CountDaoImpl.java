package com.wbj.dao.impl;

import com.wbj.dao.CountDao;
import com.wbj.mapper.CountMapper;
import com.wbj.util.JDBCTemplate;

public class CountDaoImpl implements CountDao{
	JDBCTemplate<Integer> temp = new JDBCTemplate<Integer>();

	@Override
	public Integer countStudent() {
		String sql = new StringBuffer()
			.append(" select ")
			.append(" 	count(id) num ")
			.append(" from ")
			.append(" 	student ")
			.toString();
		return temp.selectOne(new CountMapper(), sql);
	}
	
}
