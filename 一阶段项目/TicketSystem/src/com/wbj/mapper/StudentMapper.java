package com.wbj.mapper;

import java.sql.ResultSet;

import com.wbj.entity.Student;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapperObject(ResultSet rs) throws Exception {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setCity(rs.getString("city"));
		student.setAge(rs.getInt("age"));
		student.setPassword(rs.getString("password"));
		return student;
	}
	
}
