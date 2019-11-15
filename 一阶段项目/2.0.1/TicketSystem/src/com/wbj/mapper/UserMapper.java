package com.wbj.mapper;

import java.sql.ResultSet;

import com.wbj.entity.User;



/*
 * 
 *  user_id int primary key auto_increment,  #用户 id
	username varchar(10),		#用户名
	password varchar(20),		#密码	
	name varchar(10) ,			#用户姓名
	phone_number varchar(11),			#电话号码
	id_number varchar(11),		#身份证号
	balance double,						#余额
	user_state varchar(3) 		
 * */
public class UserMapper implements RowMapper<User>{

	@Override
	public User mapperObject(ResultSet rs) throws Exception {
		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getNString("password"));
		user.setName(rs.getString("name"));
		user.setPhone_number(rs.getString("phone_number"));
		user.setId_number(rs.getString("id_number"));
		user.setBalance(rs.getDouble("balance"));
		user.setUser_state(rs.getString("user_state"));
		return user;
	}

}
