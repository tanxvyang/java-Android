package com.wbj.service;

import com.wbj.entity.Student;
import com.wbj.exception.LoginFailException;
import com.wbj.util.Pager;

public interface StudentService {
	public Student login(String username,String password) throws LoginFailException;
	
	public Pager<Student> getStuByPageAndCond(String name,
			Integer age,String city, Integer pageNo);
}
