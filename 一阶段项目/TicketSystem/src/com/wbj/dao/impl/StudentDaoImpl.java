package com.wbj.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.wbj.dao.StudentDao;
import com.wbj.entity.Student;
import com.wbj.mapper.CountMapper;
import com.wbj.mapper.StudentMapper;
import com.wbj.util.JDBCTemplate;

public class StudentDaoImpl implements StudentDao{
	JDBCTemplate<Student> temp = new JDBCTemplate<Student>();
	@Override
	public Student selectStuByNameAndPwd(String username, String password) {
		String sql = new StringBuffer()
			.append(" select ")
			.append(" 	id,name,age,password,city ")
			.append(" from ")
			.append(" 	student ")
			.append(" where ")
			.append(" 	name = ? and ")
			.append(" 	password = ? ")
			.toString();
		return temp.selectOne(new StudentMapper(), sql, username,password);
	}
	@Override
	public List<Student> selectStuByPageAndCond(String name,
			Integer age,String city, Integer pageNum, Integer pageSize) {
		List params = new ArrayList();
		StringBuffer sql = new StringBuffer()
			.append(" select ")
			.append(" 	id,name,age,password,city ")
			.append(" from ")
			.append(" 	student ")
			.append(" where ")
			.append(" 	1 = 1 ");
		if(name!=null&&!name.equals("")){
			sql.append(" and name = ? ");
			params.add(name);
		}
		if(age!=null){
			sql.append(" and age = ? ");
			params.add(age);
		}
		if(city!=null&&!city.equals("")){
			sql.append(" and city = ? ");
			params.add(city);
		}
		sql.append(" limit ")
			.append(" 	?,? ")
			.toString();
		params.add((pageNum-1)*pageSize);
		params.add(pageSize);
		return temp.selectAll(new StudentMapper(), sql.toString(), params.toArray());
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
