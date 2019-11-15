package com.wbj.service.proxy;

import com.wbj.entity.Student;
import com.wbj.exception.LoginFailException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.StudentService;
import com.wbj.trans.Transaction;
import com.wbj.util.Pager;

public class StudentServiceProxy implements StudentService{
	StudentService studentService = (StudentService) ObjectFactory.getObject("studentServiceImpl");
	Transaction trans = (Transaction) ObjectFactory.getObject("trans");
	@Override
	public Student login(String username, String password)
			throws LoginFailException {
		Student student = null;
		trans.begin();
		try {
			student = studentService.login(username, password);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw e;
		}
		
		return student;
	}
	@Override
	public Pager<Student> getStuByPageAndCond(String name, Integer age,
			String city, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
