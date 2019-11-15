package com.wbj.service.impl;

import java.sql.Connection;
import java.util.List;

import com.wbj.constant.Constants;
import com.wbj.dao.CountDao;
import com.wbj.dao.StudentDao;
import com.wbj.entity.Student;
import com.wbj.exception.LoginFailException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.StudentService;
import com.wbj.util.Pager;

public class StudentServiceImpl implements StudentService{
	StudentDao studentDao = (StudentDao) ObjectFactory.getObject("studentDao");
	CountDao countDao = (CountDao) ObjectFactory.getObject("countDao");
	@Override
	public Student login(String username, String password)
			throws LoginFailException {
		Student student = studentDao.selectStuByNameAndPwd(username, password);
		if(student == null){
			throw new LoginFailException("用户名或密码不匹配");
		}
		return student;
	}
	@Override
	public Pager<Student> getStuByPageAndCond(String name,
			Integer age,String city, Integer pageNum) {
		Pager<Student> page = new Pager<Student>();
		page.setPageNum(pageNum);
		List<Student> list = studentDao.selectStuByPageAndCond(name,
				age,city,pageNum, Constants.PAGE_SIZE_3);
		page.setData(list);
		//总条数/每页显示的条数=页数？
		Integer totalCount = countDao.countStudent();
		page.setTotalPage(totalCount,Constants.PAGE_SIZE_3);
		return page;
	}

}
