package com.wbj.mapper;

import java.sql.ResultSet;

import com.wbj.entity.User;



/*
 * 
 *  user_id int primary key auto_increment,  #�û� id
	username varchar(10),		#�û���
	password varchar(20),		#����	
	name varchar(10) ,			#�û�����
	phone_number varchar(11),			#�绰����
	id_number varchar(11),		#���֤��
	balance double,						#���
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
