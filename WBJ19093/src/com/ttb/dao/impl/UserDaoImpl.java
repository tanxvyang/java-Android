package com.ttb.dao.impl;

import com.ttb.dao.UserDao;
import com.ttb.entity.User;
import com.ttb.mapper.UserMapper;
import com.ttb.util.JDBCTemplate;

public class UserDaoImpl implements UserDao {
    JDBCTemplate<User> temp = new JDBCTemplate<User>();

    public User selectUserByNameAndPwd(String username, String password) {
        String sql = new StringBuffer()
                .append(" select ")
                .append(" 	uid,username,password,usermoney ")
                .append(" from ")
                .append(" 	t_user ")
                .append(" where ")
                .append(" 	username = ? and ")
                .append(" 	password = ? ")
                .toString();//��ֹճ�
        User user = temp.selectOne(new UserMapper(), sql, username, password);
        return user;
    }

    public void updateUser(User user) {//�޸ĵ���һ�����󣬲���һ���ֶΣ��ǽ��޸Ĺ��Ķ���־û�����������ֶε��޸ģ����棩
        String sql = new StringBuffer()
                .append(" update ")
                .append(" 	t_user ")
                .append(" set ")
                .append(" 	username = ?,password = ?,usermoney = ? ")
                .append(" where ")
                .append(" 	uid = ? ")
                .toString();
        temp.update(sql, user.getUsername(), user.getPassword(), user.getUsermoney(),
                user.getUid());
    }
}
















