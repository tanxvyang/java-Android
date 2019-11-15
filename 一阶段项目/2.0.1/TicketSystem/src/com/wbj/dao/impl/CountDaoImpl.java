package com.wbj.dao.impl;

import com.wbj.dao.CountDao;
import com.wbj.mapper.CountMapper;
import com.wbj.util.JDBCTemplate;

public class CountDaoImpl implements CountDao{
	JDBCTemplate<Integer> temp = new JDBCTemplate<Integer>();

	@Override
	public Integer countTicket() {
		String sql = new StringBuffer()
			.append(" select ")
			.append(" 	count(ticket_id) as num ")
			.append(" from ")
			.append(" 	t_ticket ")
			.append(" where ticket_state = '1'   ")
			.append(" 	or ticket_state = '2'   ")
			.append(" 	or  ticket_state = '3'   ")
			.toString();
		
		return temp.selectOne(new CountMapper(), sql);
	}

	@Override
	public Integer countRecord() {
		String sql = new StringBuffer()
		.append(" select ")
		.append(" 	count(record_id) as num ")
		.append(" from ")
		.append(" 	t_record ")
//		.append(" 	group by user_id ")
		.toString();
	
	return temp.selectOne(new CountMapper(), sql);
	}

	@Override
	public Integer countUser() {
		String sql = new StringBuffer()
		.append(" select ")
		.append(" 	count(user_id) as num ")
		.append(" from ")
		.append(" 	t_user ")
		.toString();
	
	return temp.selectOne(new CountMapper(), sql);
	}
	
}
