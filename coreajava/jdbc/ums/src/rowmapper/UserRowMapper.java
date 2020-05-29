package rowmapper;

import java.sql.ResultSet;

import util.RowMapper;
import entity.User;

public class UserRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs) throws Exception {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setPhone(rs.getString("phone"));
        user.setRegistDate(rs.getDate("regist_date"));
        user.setStatus(rs.getInt("status"));
        return user;
    }

}
