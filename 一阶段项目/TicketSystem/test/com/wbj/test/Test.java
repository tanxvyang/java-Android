package com.wbj.test;

import com.wbj.entity.Student;
import com.wbj.exception.LoginFailException;
import com.wbj.factory.ObjectFactory;
import com.wbj.mapper.StudentMapper;
import com.wbj.service.StudentService;

public class Test {
	public static void main(String[] args) {
//		StudentService studentService = 
//				(StudentService) ObjectFactory.getObject("studentServiceProxy");
//		try {
//			Student student = studentService.login("С��", "123");
//		} catch (LoginFailException e) {
//			e.printStackTrace();
//		}
		String sql = new StringBuffer()
		.append(" select ")
		.append(" 	id,name,age,password,city ")
		.append(" from ")
		.append(" 	student ")
		.append(" limit ")
		.append(" 	?,? ")
		.toString();
		System.out.println(sql);
//		ÿҳ��ʾ3��
//		 select id,name,age,password,city  from student  limit  3,3

	}
}
