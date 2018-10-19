package service.impl;

import java.util.Date;

import constant.Constant;

import service.UserService;
import util.MD5Util;
import dao.UserDao;
import entity.User;
import exception.DuplicateUsernameException;
import exception.UserDisabledException;
import exception.UserNotFoundException;

public class UserServiceImpl implements UserService {

	public User login(String username, String password) throws UserNotFoundException, UserDisabledException {
		return null;
	}

	public void regist(User user) throws DuplicateUsernameException {
		UserDao userDao=null;
		//根据用户名查询用户
		User u=userDao.selectByUsername(user.getUsername());
		
		//判断用户名是否存在
		if(u!=null){
			//如果用户名存在，抛出DuplicateUsernameException
			throw new DuplicateUsernameException("用户名已存在");
		}
		
		//设置注册时间
		user.setCreateDate(new Date());
		
		//设置用户状态为可用状态
		user.setStatus(Constant.USER_STATUS_ENABLE);
		
		//密码加密
		user.setPassword(MD5Util.md5(user.getPassword()));
		
		//将用户信息保存
		userDao.insert(user);
	}

	
}
