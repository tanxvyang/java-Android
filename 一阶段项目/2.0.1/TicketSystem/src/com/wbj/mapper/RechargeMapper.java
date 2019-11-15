package com.wbj.mapper;

import java.sql.ResultSet;

import com.wbj.entity.Recharge;


public class RechargeMapper implements RowMapper<Recharge>{

	@Override
	public Recharge mapperObject(ResultSet rs) throws Exception {
		Recharge recharge = new Recharge();
		recharge.setRechargeId(rs.getInt("recharge_id"));
		recharge.setUserId(rs.getInt("user_id"));
		recharge.setUsername(rs.getString("username"));
		recharge.setApplyMoney(rs.getDouble("apply_money"));
		recharge.setApplyTime(rs.getString("apply_time"));
		recharge.setApplyState(rs.getString("apply_state"));
		
	        return recharge;
	}

}
