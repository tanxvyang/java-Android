package jdbc.service.service.impl;

import jdbc.constant.Constant;
import jdbc.dao.UserDao;
import jdbc.entity.User;
import jdbc.exception.DuplicateUsernameException;
import jdbc.exception.UserDisableException;
import jdbc.exception.UserNotFoundException;
import jdbc.factory.ObjectFactory;
import jdbc.service.UserService;
import jdbc.util.MD5Util;

import java.util.Date;

public class UserServiceImol implements UserService {

    @Override
    public void regist(User user) throws DuplicateUsernameException {
        UserDao userDao=(UserDao) ObjectFactory.getObject("userDao");
        //根据用户名查询用户
        User u=userDao.selectByUsername(user.getUsername());


        //判断用户名是否存在

        if (u!=null){
            throw new DuplicateUsernameException("用户名已存在");
        }
        //如果存在,抛出DuplicateUsernameException

        //设置注册时间
        user.setCreateDate(new Date());
       // 设置用户状态为可用状态
        user.setStatus(Constant.USER_STATUS_ENABLE);

        //密码加密
        user.setPassword(MD5Util.md5(user.getPassword()));


        //将用户信息保存到数据库
        userDao.insert(user);

    }

    @Override
    public User login(String username, String password) throws UserNotFoundException, UserDisableException {
        return null;
    }
}
