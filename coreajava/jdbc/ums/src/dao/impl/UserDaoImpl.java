package dao.impl;

import java.util.List;

import resultsetextractor.UserResultSetExtractor;
import rowmapper.UserRowMapper;
import util.JdbcTemplate;
import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public UserDaoImpl() {
		jdbcTemplate=new JdbcTemplate();
	}

	public void insert(User user) {
		String sql=new StringBuffer()
			.append("insert into t_user ")
			.append("    (username,password,phone,regist_date,status) ")
			.append("values ")
			.append("    (?,?,?,?,?) ")
			.toString();
		jdbcTemplate.update(sql, new Object[]{user.getUsername(),
											  user.getPassword(),
											  user.getPhone(),
											  user.getRegistDate(),
											  user.getStatus()});
	}

	public User selectByUsername(String username) {
		String sql=new StringBuffer()
			.append("select * ")
			.append("from t_user ")
			.append("where username=? ")
			.toString();
		return (User) jdbcTemplate.query(sql, new Object[]{username}, new UserResultSetExtractor());
	}

	public User selectByUsernameAndPassword(String username, String password) {
		String sql=new StringBuffer()
			.append("select * ")
			.append("from t_user ")
			.append("where username=? ")
			.append("and password=? ")
			.toString();
		List<User> users=jdbcTemplate.query(sql, new Object[]{username,password}, new UserRowMapper());
		return users.size()==0?null:users.get(0);
	}

}
