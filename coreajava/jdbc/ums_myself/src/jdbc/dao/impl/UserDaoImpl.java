package jdbc.dao.impl;

import jdbc.dao.UserDao;
import jdbc.entity.User;
import jdbc.util.JdbcTemplate;
import jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements UserDao {


    @Override
    public User selectByUsername(String username) {
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = new StringBuffer()
                .append("insert into t_user ")
                .append("  (username,password,phone,regist_date,status) ")
                .append(" values ")
                .append(" (?,?,?,?,?) ")
                .toString();
        JdbcTemplate.update(sql, new Object[]{
                user.getCreateDate(),
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getPhone(),
                user.getStatus()
        });
    }

    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        return null;
    }
}
