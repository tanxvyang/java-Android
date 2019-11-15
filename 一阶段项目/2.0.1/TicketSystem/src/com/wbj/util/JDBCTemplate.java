package com.wbj.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wbj.entity.Ticket;
import com.wbj.mapper.RowMapper;
import com.wbj.mapper.UserMapper;

public class JDBCTemplate<T> {//ģ���࣬�ṩ��ɾ�Ĳ�ı�׼����
	/**
	 * ִ���޸�����׼����
	 * @param sql  ���ݿ����
	 * @param params  ����
	 * @return
	 */
	public Integer update(String sql ,Object... params){
		Integer countRow = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			countRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,null);
		}
		return countRow;
	}
	/**
	 * ִ���������׼����
	 * @param sql  ���ݿ����
	 * @param params  ����
	 * @return
	 */
	public Integer insert(String sql ,Object... params){
		return update(sql, params);
	}
	/**
	 * ִ��ɾ������׼����
	 * @param sql  ���ݿ����
	 * @param params  ����
	 * @return
	 */
	public Integer delete(String sql ,Object... params){
		return update(sql, params);
	}
	/**
	 * ִ�в�ѯ��������׼����
	 * @param sql  ���ݿ����
	 * @param params  ����
	 * @return
	 */
	public List<T> selectAll(RowMapper<T> rm,String sql,Object... params){
		List<T> result = new ArrayList<T>();//�������       ΪʲôҪ��ȡ�������������ʽ������Ϊ�˹رս������
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			rs = pstmt.executeQuery();//��ѯ�����α��  ��   ��
			while (rs.next()) {//���ж�ȡ��ѯ��������
//				rs --> object  ӳ��
				result.add(rm.mapperObject(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, rs);
		}
		return result;
	}
	/**
	 * ִ�в�ѯ��������׼����
	 * @param sql  ���ݿ����
	 * @param params  ����
	 * @return
	 */
	public T selectOne(RowMapper<T> rm,String sql,Object... params){
		List<T> list = selectAll(rm, sql, params);
		T obj = null;
		if(list.size() != 0){
			obj = list.get(0);
		}
		//System.out.println("sdfsfsfs");
		return obj;
	}

}
