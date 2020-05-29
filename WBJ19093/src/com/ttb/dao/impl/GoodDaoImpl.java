package com.ttb.dao.impl;

import java.util.List;

import com.ttb.dao.GoodDao;
import com.ttb.entity.Good;
import com.ttb.mapper.GoodMapper;
import com.ttb.util.JDBCTemplate;

public class GoodDaoImpl implements GoodDao {
    JDBCTemplate<Good> temp = new JDBCTemplate<Good>();

    public List<Good> selectGoodsByGoodName(String goodName) {
        String sql = new StringBuffer()
                .append(" select ")
                .append(" 	gid,goodname,goodprice,goodintro,nums ")
                .append(" from ")
                .append(" 	t_good ")
                .append(" where ")
                .append(" 	goodName like ? ")
                .toString();

        List<Good> list = temp.selectAll(new GoodMapper(),
                sql, "%" + goodName + "%");
        return list;
    }

    public void updateGood(Good good) {
        String sql = new StringBuffer()
                .append(" update ")
                .append(" 	t_good ")
                .append(" set ")
                .append(" 	goodname = ?,goodprice = ?,goodintro = ?,nums = ? ")
                .append(" where ")
                .append(" 	gid = ? ")
                .toString();
        temp.update(sql, good.getGoodName(), good.getGoodPrice(), good.getGoodIntro(), good.getNums(),
                good.getGid());
    }

    public Good selectGoodByGoodName(String goodName) {
        String sql = new StringBuffer()
                .append(" select ")
                .append(" 	gid,goodname,goodprice,goodintro,nums ")
                .append(" from ")
                .append(" 	t_good ")
                .append(" where ")
                .append(" 	goodname = ? ")
                .toString();
        return temp.selectOne(new GoodMapper(), sql, goodName);
    }

    public Good selectGoodByGid(Integer gid) {
        String sql = new StringBuffer()
                .append(" select ")
                .append(" 	gid,goodname,goodprice,goodintro,nums ")
                .append(" from ")
                .append(" 	t_good ")
                .append(" where ")
                .append(" 	gid = ? ")
                .toString();
        return temp.selectOne(new GoodMapper(), sql, gid);
    }

    public void insertGood(Good good) {
        String sql = new StringBuffer()
                .append(" insert into ")
                .append(" 	t_good(gid,goodname,goodprice,goodintro,nums) ")
                .append(" values ")
                .append(" 	(?,?,?,?,?) ")
                .toString();
        temp.insert(sql, good.getGid(), good.getGoodName(), good.getGoodPrice(),
                good.getGoodIntro(), good.getNums());
    }

    public void deleteGood(Integer gid) {
        String sql = new StringBuffer()
                .append(" delete from ")
                .append(" 	t_good ")
                .append(" where ")
                .append(" 	gid = ? ")
                .toString();
        temp.delete(sql, gid);
    }


}
