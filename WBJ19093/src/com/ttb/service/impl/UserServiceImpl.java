package com.ttb.service.impl;

import com.ttb.dao.UserDao;
import com.ttb.entity.User;
import com.ttb.exception.LoginFailException;
import com.ttb.factoy.ObjectFactory;
import com.ttb.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = (UserDao) ObjectFactory.getObject("userDao");

    //��¼����
    public User login(String username, String password) throws LoginFailException {
        User user = userDao.selectUserByNameAndPwd(username, password);
        if (user == null) {
            throw new LoginFailException("�û��������벻ƥ��");
        }
        return user;
    }
}
