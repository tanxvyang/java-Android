package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import exception.DataAccessException;

public class JdbcUtil {
    private static Properties config;
    private static ThreadLocal<Connection> threadLocal;

    static {
        config = new Properties();
        threadLocal = new ThreadLocal<Connection>();
        try {

            config.load(JdbcUtil.class
                    .getClassLoader()
                    .getResourceAsStream("datasource.properties"));


            Class.forName(config.getProperty("jdbc.driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("JdbcUtil初始化错误");
        }
    }

    //一个事务一个连接，一个线程一个连接
    public static Connection getConnection() {
        Connection con = threadLocal.get();
        try {
            if (con == null) {
                con = DriverManager.getConnection(config.getProperty("jdbc.url"),
                        config.getProperty("jdbc.username"),
                        config.getProperty("jdbc.password"));
                threadLocal.set(con);
            }
        } catch (Exception e) {
            throw new DataAccessException("数据访问失败", e);
        }
        return con;
    }

    public static void close() {
        Connection con = threadLocal.get();
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.remove();
        }
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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


}
