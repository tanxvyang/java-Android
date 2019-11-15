package com.wbj.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCUtil {//�����࣬��Ҫ�ṩ���ݿ����ӣ��ر�����
//	ÿ���̶߳�Ӧ��ӵ�ж��������ӣ��Ա�֤�����sqlִ������ͬһ��connect������
	static ThreadLocal<Connection> myConn = new ThreadLocal<Connection>();
	static DataSource ds = null;
	/**
	 * ��̬����飬��ȡ�����ļ�������DataSource����
	 */
	static{
		Properties p = new Properties();
		try {
			p.load(JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			ds = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ʹ��DataSource��ȡ���ݿ�����
	 * @return conn ���ݿ����Ӷ���
	 */
	public static Connection getConnection(){
		Connection conn = null;
//		�жϵ�ǰ�߳��Ƿ�ӵ������
		conn = myConn.get();
//		���û�оͻ�ȡһ������
		if(conn == null){
			try {
				conn = ds.getConnection();
//				������ȡ�������ӷ����̵߳�˽�пռ��У���֤��ǰ�߳�ʼ�ղ���ͬһ�����ݿ�����
				myConn.set(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return conn;
	}
	/**
	 * �ر����ӡ�״̬���������
	 * @param conn  ���ݿ�����
	 * @param stmt	״̬��
	 * @param rs	�����
	 */
	public static void close(Statement stmt,ResultSet rs){
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
	}
	/**
	 * �رյ�ǰ�߳��е�����
	 */
	public static void close(){
		Connection conn = myConn.get();
		if (conn != null) {
			try {
				conn.close();
				myConn.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
