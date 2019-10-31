package com.nanjinwangbo.www.jdbc.SwingDO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestForJDBC {
    public static void main(String[] args) {
      String dirverClassName = "com.mysql.jdbc.Driver";
      String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        Connection con = null;
        Statement stmt= null;
        ResultSet rs = null;
        try {
            Class.forName(dirverClassName);
            stmt = con.createStatement();
            System.out.println(stmt);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
