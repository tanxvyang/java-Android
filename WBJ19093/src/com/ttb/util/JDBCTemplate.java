package com.ttb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ttb.mapper.RowMapper;

public class JDBCTemplate<T> {//模板类，提供增删改查的标准方法
	
	public Integer update(String sql ,Object... params){
		Integer countRow = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				if(params[i] instanceof Integer){
					pstmt.setInt(i + 1, Integer.valueOf(String.valueOf(params[i])));
				}else if(params[i] instanceof String){
					pstmt.setString(i + 1, String.valueOf(params[i]));
				}else {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			countRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn,pstmt,null);
		}
		return countRow;
	}
	
	public Integer insert(String sql ,Object... params){
		return update(sql, params);
	}
	
	public Integer delete(String sql ,Object... params){
		return update(sql, params);
	}
	
	public List<T> selectAll(RowMapper<T> rm,String sql,Object... params){
		List<T> result = new ArrayList<T>();//结果集合       为什么要获取结果集的数组形式？就是为了关闭结果集吗？
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				if(params[i] instanceof String){
					pstmt.setString(i + 1, String.valueOf(params[i]));
				}else if(params[i] instanceof Integer){
					pstmt.setInt(i + 1, Integer.parseInt(String.valueOf(params[i])));
				}else{
					pstmt.setObject(i + 1, params[i]);
				}
			}
			rs = pstmt.executeQuery();//查询结果。伪表  行   列
			while (rs.next()) {//逐行读取查询到的数据
//				rs --> object  映射
				result.add(rm.mapperObject(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public T selectOne(RowMapper<T> rm,String sql,Object... params){
		List<T> list = selectAll(rm, sql, params);
		T obj = null;
		if(list.size() != 0){
			obj = list.get(0);
		}
		return obj;
	}
}
