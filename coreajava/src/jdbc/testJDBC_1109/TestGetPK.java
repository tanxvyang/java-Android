package jdbc.testJDBC_1109;

import java.sql.*;

public class TestGetPK {
    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "610322";


        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer orderId = null;


        long start = System.currentTimeMillis();
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);

            String sql = new StringBuilder()
                    .append("insert into t_order ")
                    .append("    (no,price) ")
                    .append("values ")
                    .append("    (?,?)")
                    .toString();
            // ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //ps=con.prepareStatement(sql,new int[]{1});
            ps = con.prepareStatement(sql, new String[]{"id"});


            ps.setString(1, "123456789");
            ps.setDouble(2, 139.0);
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            sql = new StringBuilder()
                    .append("insert into t_item ")
                    .append("    (product,num,price,order_id) ")
                    .append("values ")
                    .append("    (?,?,?,?)")
                    .toString();
            ps = con.prepareStatement(sql);
            ps.setString(1, "aaa");
            ps.setInt(2, 3);
            ps.setDouble(3, 99.0);
            ps.setInt(4, orderId);
            ps.executeUpdate();


            ps.setString(1, "bbb");
            ps.setInt(2, 2);
            ps.setDouble(3, 40.0);
            ps.setInt(4, orderId);
            ps.executeUpdate();


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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
