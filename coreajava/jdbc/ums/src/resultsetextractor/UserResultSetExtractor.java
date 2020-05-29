package resultsetextractor;

import java.sql.ResultSet;

import util.ResultSetExtractor;
import entity.User;

public class UserResultSetExtractor implements ResultSetExtractor {

    public Object extractData(ResultSet rs) throws Exception {
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPhone(rs.getString("phone"));
            user.setRegistDate(rs.getDate("regist_date"));
            user.setStatus(rs.getInt("status"));
        }
        return user;
    }


}
