package com.ttb.test;

import com.ttb.dao.UserDao;
import com.ttb.entity.User;
import com.ttb.factoy.ObjectFactory;

public class Test {
    public static void main(String[] args) {
//		UserDao ud = new UserDao();
//		User user = ud.selectUserByNameAndPwd("user1", "123");
//		System.out.println(user);
//		new LoginFrame().start();
//		new MainFrame(new User()).start();
//		new AdminFrame().start();
        UserDao ud = (UserDao) ObjectFactory.getObject("userDao");
        User user = ud.selectUserByNameAndPwd("user1", "123");
        System.out.println(user.getUid());
    }
}
