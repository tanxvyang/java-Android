package com.ttb.service;

import com.ttb.entity.User;
import com.ttb.exception.LoginFailException;

public interface UserService {
    public User login(String username, String password) throws LoginFailException;
}
