package com.ttb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {//工具类，主要提供数据库连接，关闭连接
	//静态代码块   加载驱动
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//根据url用户名密码，获取连接
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//关闭连接、状态集、结果集
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
