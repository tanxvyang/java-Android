package com.ttb.dao;

import com.ttb.entity.User;

public interface UserDao {
    public User selectUserByNameAndPwd(String username, String password);

    public void updateUser(User user);
}
