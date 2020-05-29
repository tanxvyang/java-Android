package com.ttb.mapper;

import java.sql.ResultSet;

import com.ttb.entity.Good;

public class GoodMapper implements RowMapper<Good> {

    @Override
    public Good mapperObject(ResultSet rs) throws Exception {
        Good good = new Good();
        good.setGid(rs.getInt("gid"));
        good.setGoodName(rs.getString("goodname"));
        good.setGoodPrice(rs.getDouble("goodprice"));
        good.setGoodIntro(rs.getString("goodIntro"));
        good.setNums(rs.getInt("nums"));
        return good;
    }

}
