package com.wbj.dao;

import java.util.List;

import com.wbj.entity.Student;

public interface StudentDao {
	public Student selectStuByNameAndPwd(String username,String password);
	
	public List<Student> selectStuByPageAndCond(String name, Integer age,String city, Integer pageNum, Integer pageSize);
}
