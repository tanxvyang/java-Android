package jdbc.testJDBC_1109;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC 批处理
 *
 * */
public class TestBatch {
    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "610322";

        Connection con = null;

        PreparedStatement ps = null;
        long start = System.currentTimeMillis();
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);

            String sql = new StringBuilder()
                    .append("insert into t_user ")
                    .append("    (name) ")
                    .append("values ")
                    .append("    (?)")
                    .toString();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < 30001; i++) {
                ps.setString(1, "n" + 1);
                ps.executeUpdate();
                ps.addBatch();

                if (i % 10000 == 0) {
                    ps.executeBatch();
                }

            }
            ps.executeBatch();
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }


}
