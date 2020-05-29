package com.ttb.mapper;

import java.sql.ResultSet;

//��ӳ���ϵ��¼��
public interface RowMapper<T> {//ռλ��

    public T mapperObject(ResultSet rs) throws Exception;

}
