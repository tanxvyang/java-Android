package com.ttb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ttb.mapper.RowMapper;

public class JDBCTemplate<T> {//ģ���࣬�ṩ��ɾ�Ĳ�ı�׼����

    public Integer update(String sql, Object... params) {
        Integer countRow = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof Integer) {
                    pstmt.setInt(i + 1, Integer.valueOf(String.valueOf(params[i])));
                } else if (params[i] instanceof String) {
                    pstmt.setString(i + 1, String.valueOf(params[i]));
                } else {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            countRow = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt, null);
        }
        return countRow;
    }

    public Integer insert(String sql, Object... params) {
        return update(sql, params);
    }

    public Integer delete(String sql, Object... params) {
        return update(sql, params);
    }

    public List<T> selectAll(RowMapper<T> rm, String sql, Object... params) {
        List<T> result = new ArrayList<T>();//�������       ΪʲôҪ��ȡ�������������ʽ������Ϊ�˹رս������
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof String) {
                    pstmt.setString(i + 1, String.valueOf(params[i]));
                } else if (params[i] instanceof Integer) {
                    pstmt.setInt(i + 1, Integer.parseInt(String.valueOf(params[i])));
                } else {
                    pstmt.setObject(i + 1, params[i]);
                }
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
            JDBCUtil.close(conn, pstmt, rs);
        }
        return result;
    }

    public T selectOne(RowMapper<T> rm, String sql, Object... params) {
        List<T> list = selectAll(rm, sql, params);
        T obj = null;
        if (list.size() != 0) {
            obj = list.get(0);
        }
        return obj;
    }
}
