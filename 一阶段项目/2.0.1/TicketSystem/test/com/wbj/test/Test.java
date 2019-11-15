package com.wbj.test;


import java.util.List;

import com.wbj.dao.UserDao;
import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.UserService;
import com.wbj.ui.*;
import com.wbj.util.Pager;

public class Test {
	public static void main(String[] args) throws Exception {
	
		
		
		
	 new LoginFream().start();
//		String money  = "\\d{1,4}[.]?\\d{0,2}";
//		String balance = "^[0-9]+([.]{1}[0-9]{0,2}){0,1}$";
//		String str = "1996-10-21 12:12";
//		String dateChar = "^(?<year>\\d{2,4})-(?<month>\\d{1,2})-(?<day>\\d{1,2})$ ";
//	System.out.println( str.matches(dateChar));
//		System.out.println(Double.valueOf(str) >0);
		
		
		
//		Ticket ticket = new Ticket();
//		ticket.setDeparture_station("南京");
//		ticket.setTerminal_station("上海");
//		//ticket.setDeparture_time(new Date(new java.util.Date().getTime()));
//		ticket.setTicket_id(9);
//		ticket.setTicket_number(999);
//		ticket.setTicket_state("2");
//		ticket.setTrain_number("Z256");
//		ticket.setDeparture_time("2019-11-11 11:11");
//	//new registerFream().start();
////	new buyTicketFream().start();	
//		User user = new User();
//		user.setId(4);
//		user.setBalance(1000.0);
//		user.setId_number("918177277645678392");
//		user.setName("张张");
//		user.setPassword("333");
//		user.setUser_state("1");
//		user.setUsername("123123");
//		Record record = new Record();
	
	//	new registerFream().start();
//		new UserMainFream(user)	.start();
		//new buyTicketFream(user,ticket,record).start();
//		 new ManagerMainFream(user).start();
//		new ManagerUserFream(user).start();
// 		new ManagerAddTicketFream().start();
//		new UserCenterFream(user).start();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/**
	 * 车票测试
	 * 
	 * */	
	//	TicketService ticketService =(TicketService) ObjectFactory.getObject("tickerServiceProxy");
		
//		Ticket ticket = new Ticket();
//		ticket.setDeparture_station("南京");
//		ticket.setTerminal_station("上海");
//		ticket.setDeparture_time(new Date(new java.util.Date().getTime()));
//		ticket.setTicket_id(9);
//		ticket.setTicket_number(999);
//		ticket.setTicket_state("2");
//		ticket.setTrain_number("Z256");
//		ticketService.update(ticket);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	//TicketService ticketService =(TicketService) ObjectFactory.getObject("ticketService");
//	ticketService.selectTicketByDepartureAndTerminalStation("南京", "上海");
	//List test = ticketService.selectTicketByDepartureAndTerminalStation("南京","上海");
	//test.add(ticketService.selectTicketByDepartureAndTerminalStation("南京", "上海"));
//	for (Object object : test) {
//		System.out.println(object.toString());
//	}
//	for (int i = 0; i < test.size(); i++) {
//		System.out.println(test.get(i).toString());
//	}
	
	
	//	System.out.println(ticketService.selectTicketByDepartureAndTerminalStation("南京", "上海").toString());
//		Ticket ticket = new Ticket();
//		ticket.setDeparture_station("南京");
//		ticket.setTerminal_station("上海");
//		ticket.setDeparture_time(new Date(new java.util.Date().getTime()));
//		ticket.setTicket_id(10);
//		ticket.setTicket_number(999);
//		ticket.setTicket_state("2");
//		ticket.setTrain_number("Z256");
//		ticketService.insert(ticket);
		/**
		 * 用户测试
		 * 
		 * */
	//UserService userService = (UserService) ObjectFactory.getObject("userServiceProxy");
		
		
	//userService.updateUserBalance(user);
	
//	UserDao userDao =(UserDao) ObjectFactory.getObject("userDao");
//	List<User> chickUsername = userDao.selectUserForPage("user",null, null, 0, 1);
//	System.out.println(chickUsername.size());
	//System.out.println("11111");
//	Pager<Record> pager = userService.selectUserPageRecords(user.getId(), "1");
//	List<Record> reList =pager.getData();
//	System.out.println(reList.size());
//	System.out.println(reList.get(0));
	//List<Record> record2 =	userDao.selectRecordForPage(user.getId(), 0,2);
	//System.out.println(userDao.selectUserById_number("610322201910310952"));
	//		User user = new User();
//		user.setBalance(1000.0);
//		user.setId_number("61032211111111");
//		user.setName("张张");
//		user.setPassword("333");
//		user.setUser_state("1");
//		user.setUsername("123123");
//	//UserService userService =new UserServiceImpl();
//		userService.register(user);
////		
//		try {
//			User user = userService.login("user001", "user001");
//			System.out.println(user.getId_number()+user.getName());
//		} catch (LoginFailException e) {
//			e.printStackTrace();
//		} 
//		
//		
//		
////		StudentService studentService = 
//				(StudentService) ObjectFactory.getObject("studentServiceProxy");
//		try {
//			Student student = studentService.login("小周", "123");
//		} catch (LoginFailException e) {
//			e.printStackTrace();
//		}
//		String sql = new StringBuffer()
//		.append(" select ")
//		.append(" 	id,name,age,password,city ")
//		.append(" from ")
//		.append(" 	student ")
//		.append(" limit ")
//		.append(" 	?,? ")
//		.toString();
//		System.out.println(sql);
//		每页显示3条
//		 select id,name,age,password,city  from student  limit  3,3

	}
}
