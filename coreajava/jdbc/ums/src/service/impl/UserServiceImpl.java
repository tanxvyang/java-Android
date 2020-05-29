package service.impl;

import java.sql.Connection;
import java.util.Date;

import service.UserService;
import transaction.TransactionManager;
import util.JdbcUtil;
import util.MD5Util;
import constant.Constant;
import dao.UserDao;
import entity.User;
import exception.DuplicateUsernameException;
import exception.UserDisabledException;
import exception.UserNotFoundException;
import factory.ObjectFactory;

public class UserServiceImpl implements UserService {

    public User login(String username, String password) throws UserNotFoundException, UserDisabledException {
        UserDao userDao = (UserDao) ObjectFactory.getObject("userDao");

        User user = userDao.selectByUsernameAndPassword(username, MD5Util.md5(password));

        if (user == null) {
            throw new UserNotFoundException("用户名或密码错误");
        }

        if (Constant.USER_STATUS_DISABLE.equals(user.getStatus())) {
            throw new UserDisabledException("用户被禁用");
        }

        return user;
    }


    public void regist(User user) throws DuplicateUsernameException {

        UserDao userDao = (UserDao) ObjectFactory.getObject("userDao");

        //根据用户名查询用户
        User u = userDao.selectByUsername(user.getUsername());

        //判断用户名是否存在
        if (u != null) {
            //如果用户名存在，抛出DuplicateUsernameException
            throw new DuplicateUsernameException("用户名已存在");
        }

        //设置注册时间
        user.setRegistDate(new Date());

        //设置用户状态为可用状态
        user.setStatus(Constant.USER_STATUS_ENABLE);

        //密码加密
        user.setPassword(MD5Util.md5(user.getPassword()));

        //将用户信息保存
        userDao.insert(user);

    }


}
