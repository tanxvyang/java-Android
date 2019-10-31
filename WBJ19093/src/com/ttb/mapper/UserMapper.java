package com.ttb.mapper;

import java.sql.ResultSet;

import com.ttb.entity.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapperObject(ResultSet rs) throws Exception {
		User user = new User();
		user.setUid(rs.getInt("uid"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setUsermoney(rs.getDouble("usermoney"));
		return user;
	}

}
