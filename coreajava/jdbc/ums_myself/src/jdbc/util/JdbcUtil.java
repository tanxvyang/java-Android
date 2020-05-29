package jdbc.util;

import jdbc.exception.DataAccessException;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    private static Properties config;

    static {
        config = new Properties();
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


    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(config.getProperty("jdbc.url"),
                    config.getProperty("jdbc.driverClassname"),
                    config.getProperty("jdbc.username"),
                    config.getProperty("jdbc.password");)

        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
        return con;
    }

    public static void close(ResultSet rs, Properties ps, Connection con) {


    }
}
