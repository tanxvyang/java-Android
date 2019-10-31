package com.ttb.mapper;

import java.sql.ResultSet;

//行映射关系记录器
public interface RowMapper<T> {//占位符
	public T mapperObject(ResultSet rs) throws Exception;

}
