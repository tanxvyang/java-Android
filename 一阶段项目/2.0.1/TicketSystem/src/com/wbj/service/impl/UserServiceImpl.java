package com.wbj.service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import com.wbj.dao.CountDao;
import com.wbj.dao.TicketDao;
import com.wbj.dao.UserDao;
import com.wbj.entity.Recharge;
import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.exception.*;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.UserService;
import com.wbj.ui.buyTicketFream;
import com.wbj.util.Pager;

public class UserServiceImpl implements UserService {
	UserDao userDao = (UserDao) ObjectFactory.getObject("userDao");
	TicketDao ticketDao = (TicketDao) ObjectFactory.getObject("ticketDao");
	CountDao countDao =(CountDao) ObjectFactory.getObject("countDao");
	@Override
	public User login(String username, String password)throws LoginFailException {
		if ((username.equals("") || username == null)&&(username.equals("") || username == null)) {
			throw new LoginFailException("用户名和密码不可为空！");
			
		}
		if (username.equals("") || username == null) {
			throw new LoginFailException("用户名不可为空！");
		}
		if (password.equals("") || password == null) {
			throw new LoginFailException("密码不可为空！");
		}
		
		List<User> chickUsername = userDao.selectUserForPage(username,null, null, 0, 1);
		if ((chickUsername.size()>0) &&(userDao.selectUserByNameAndPwd(username, password))==null) {
			throw new LoginFailException("用户名与密码不匹配");
		}
		
		User user = userDao.selectUserByNameAndPwd(username, password);
		if (user == null) {
			throw new LoginFailException("用户不存在，请注册");
		}
		return user;
	}

	@Override
	public Pager<User> getUserByPageAndCond(String name, Integer age,
			String city, Integer pageNo) {
		return null;
	}

	@Override
	public void register(User user) throws RegisterFailException {
	
		if (userDao.selectUserById_number(user.getId_number()) != null) {
			throw new RegisterFailException("该身份证号用户已存在！请核对");
		};
		List<User> chickUsername = userDao.selectUserForPage(user.getUsername(),null, null, 0, 1);
			if (!(chickUsername.size()>0)) {
				userDao.insertUser(user);
			}else {
				throw new RegisterFailException("该用户名已被使用！");
			}
		
	}
	@Override
	public Record buyTicket(User user, Ticket ticket) throws buyTicketException, TicketCheckoutException,NullChooseException {
		Record record = new Record();
		List<Ticket> ticketList =	null;
		List<Record> buyStateList =null;
		
		//判断是否选择车票
		if (ticket.getTicket_id()==null){
			throw new NullChooseException("未选择车票");
		}
		buyStateList = userDao.selectStateFromTow(user.getId());
		if ((buyStateList.size()==0)|| ((buyStateList.get(0).getBuyState().equals("已退票")) ) ) {
		ticketList = ticketDao.selectTicketByDepartureAndTerminalStation(null, null, null, null, ticket.getTicket_id());
		//判断当车票存在，锁定一张车票，状态为为未付款(相当于下订单)
		if (ticketList.size()!=0){
			ticket = ticketList.get(0);
			if (ticket.getTicket_state().equals("待售")) {
				//待售状态
				throw new buyTicketException("车票待售,无法购买");
				//提示车票待售
			}
			if (ticket.getTicket_state().equals("售空")) {
				//售空状态
				throw new buyTicketException("车票售罄,无法购买");
				//提示车票售空
			}
			//开售,购买
			if (ticket.getTicket_state().equals("开售")) {
				String changeData = "subtract";
				
				if (ticket.getTicket_number() > 0) {
					//当最后一张车票被减去后，将状态改为售空
					if (ticket.getTicket_number() == 1) {
						ticket.setTicket_state("售空");
						ticketDao.updateTicket(ticket);
					}
					ticketDao.updateTicketForRTdata(changeData, ticket.getTicket_id());
				}

				
		//修改record，先修改已知的信息
				record.setTicketId(ticket.getTicket_id());
				record.setTrainNumber(ticket.getTrain_number());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
				java.util.Date date = new java.util.Date();
				record.setBuyTime(sdf.format(date));
				record.setBuyState("1");//未付款
//							进入付款页面
		//		new buyTicketFream(user, ticket, record).start();
//				int unlock =JOptionPane.showConfirmDialog(managerUserFream, "是否对该用户进行解封操作？");
//				if ( unlock !=0 ) {
//					return;
//				}
				return record;
				
			}

		}else {
			throw new TicketCheckoutException("未找到车票");
		}

		}else {
			throw new buyTicketException("您已经购买了该车票，无法重复购买");
		}

		return record;


	}


	@Override
	public Pager<User> selectUserForPage(String username,String idNumber,String userState,String pagenums) {
		int currentPageNum = 1;
		if (pagenums != null) {
			currentPageNum = Integer.parseInt(pagenums);
		}
		int totalRrecords = countDao.countUser() ;

		Pager<User> pager = new Pager<User>(currentPageNum,totalRrecords);
		pager.setData(userDao.selectUserForPage(username,idNumber,userState,pager.getStartIndex(), pager.getPageSize()));
		return pager;
	}
/**
 * 查询用户购票记录
 */
	
	@Override
	public Pager<Record> selectUserPageRecords(Integer userId , String pagenums) {
		int currentPageNum = 1;
		if (pagenums != null) {
			currentPageNum = Integer.parseInt(pagenums);
		}
		int totalRrecords = countDao.countRecord();
		Pager<Record> pager = new Pager<Record>(currentPageNum,totalRrecords);
		pager.setData(userDao.selectRecordForPage(userId,pager.getStartIndex(), pager.getPageSize()));
		return pager;
	}

	@Override
	public User selectUserByidNumber(String idNumber) {
		User user = userDao.selectUserById_number(idNumber);
		if (user == null) {
			try {
				throw new UserNotFoundException("未找到相关用户");
			} catch (UserNotFoundException e) {
			}
		}
		return user;
	}

	@Override
	public void updateUserState(User user) {
		userDao.updateUserState(user);
		
	}

	@Override
	public void addRecord(Record record) {
		userDao.insertRecord(record);
	}

	@Override
	public Pager showUserRecord() {
		return null;
	}

	@Override
	public void updateRecord(Record record) {
		userDao.updateRecord(record);
	}

	@Override
	public void updateUserBalance(User user) {
		userDao.updateUserBalance(user);
	}

	@Override
	public Record selectRecordById(Integer recordId) {
		
		List<Record> records =userDao.selectRecordForId(recordId);
		Record record = records.get(0);
		return record;
	}

	@Override
	public void addRecharge(Recharge recharge) {
		userDao.insertRecharge(recharge);
		
	}

	@Override
	public void deleteRecharge(Integer rechargeId) {
		userDao.deleteRecharge(rechargeId);
		
	}

	@Override
	public Recharge selectRechargeById(Integer rechargeId) {
		Recharge recharge =null;
		List<Recharge> rechargeList=userDao.selectRechargeForId(rechargeId);
		if (rechargeList.size() != 0){
			 recharge = rechargeList.get(0);
		}
		return recharge;
	}

	@Override
	public Recharge selectRechargeForUserId(Integer userId) {
		List<Recharge> records =userDao.selectRechargeForUserId(userId);
		Recharge recharge = records.get(0);
		return recharge;
	}

	@Override
	public void updateRechargeByUserId(Recharge Recharge) {

	}

	@Override
	public void updateRecharge(Recharge Recharge) {
		userDao.updateRecharge(Recharge);
	}

	@Override
	public Pager<Recharge> selectUserPageRecharge(Integer rechargeId,
			String pagenums) {
		int currentPageNum = 1;
		if (pagenums != null) {
			currentPageNum = Integer.parseInt(pagenums);
		}
		int totalRrecords = countDao.countRecord();

		Pager<Recharge> pager = new Pager<Recharge>(currentPageNum,totalRrecords);
		pager.setData(userDao.selectRechargeForPage(rechargeId,pager.getStartIndex(), pager.getPageSize()));
		return pager;
	}

	@Override
	public Pager<Recharge> selectUserPageRecharge(String pagenums) {

		int currentPageNum = 1;
		if (pagenums != null) {
			currentPageNum = Integer.parseInt(pagenums);
		}
		int totalRrecords = countDao.countRecord();

		Pager<Recharge> pager = new Pager<Recharge>(currentPageNum,
				totalRrecords);
		pager.setData(userDao.selectRechargeForPage(pager.getStartIndex(),
				pager.getPageSize()));
		return pager;
	}

	@Override
	public void deleteRrecord(Integer recordId) {
		userDao.deleteRecord(recordId);
		
	}

	@Override
	public User refresh(User user) {
		
		user = userDao.selectUserById_number(user.getId_number());
		return user;
	}


}
