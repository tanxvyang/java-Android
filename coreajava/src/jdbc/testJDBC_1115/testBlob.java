package jdbc.testJDBC_1115;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testBlob {
    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "610322";
        Connection con = null;
        PreparedStatement ps = null;


        //3--------------3-----------3----------------3-----------

        try {
            Class.forName(driverClassName);
            // con=DriverManager.getConnection(url,username,password,);
            con.setAutoCommit(false);
            // in=testBlob.class
            //      .getClassLoader()
            //     .getResourceAsStream("");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
