package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.DataAccessException;

public class JdbcTemplate {


    public void update(String sql, Object[] params) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getConnection();
            ps = con.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    setParam(i + 1, params[i], ps);
                }
            }

            ps.executeUpdate();
        } catch (Exception e) {
            throw new DataAccessException("数据访问失败", e);
        } finally {
            JdbcUtil.close(null, ps, null);
        }
    }

    public Object query(String sql, Object[] params, ResultSetExtractor rse) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object obj = null;
        try {
            con = JdbcUtil.getConnection();
            ps = con.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    setParam(i + 1, params[i], ps);
                }
            }

            rs = ps.executeQuery();

            obj = rse.extractData(rs);

        } catch (Exception e) {
            throw new DataAccessException("数据访问失败", e);
        } finally {
            JdbcUtil.close(rs, ps, null);
        }
        return obj;
    }


    public List query(String sql, Object[] params, RowMapper rm) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            con = JdbcUtil.getConnection();
            ps = con.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    setParam(i + 1, params[i], ps);
                }
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                Object obj = rm.mapRow(rs);
                list.add(obj);
            }

        } catch (Exception e) {
            throw new DataAccessException("数据访问失败", e);
        } finally {
            JdbcUtil.close(rs, ps, null);
        }
        return list;
    }


    public void setParam(int index, Object param, PreparedStatement ps) throws SQLException {
        if (param == null) {
            ps.setNull(index, Types.VARCHAR);
        } else if (param instanceof String) {
            ps.setString(index, (String) param);
        } else if (param instanceof Integer || param.getClass().equals(int.class)) {
            ps.setInt(index, (Integer) param);
        } else if (param instanceof Double || param.getClass().equals(double.class)) {
            ps.setDouble(index, (Double) param);
        } else if (param instanceof Boolean || param.getClass().equals(boolean.class)) {
            ps.setBoolean(index, (Boolean) param);
        } else if (param instanceof java.sql.Date) {
            ps.setDate(index, (java.sql.Date) param);
        } else if (param instanceof java.sql.Time) {
            ps.setTime(index, (java.sql.Time) param);
        } else if (param instanceof java.sql.Timestamp) {
            ps.setTimestamp(index, (java.sql.Timestamp) param);
        } else if (param instanceof Date) {
            ps.setDate(index, new java.sql.Date(((Date) param).getTime()));
        } else {
            ps.setObject(index, param);
        }
    }
}
