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
			throw new LoginFailException("�û��������벻��Ϊ�գ�");
			
		}
		if (username.equals("") || username == null) {
			throw new LoginFailException("�û�������Ϊ�գ�");
		}
		if (password.equals("") || password == null) {
			throw new LoginFailException("���벻��Ϊ�գ�");
		}
		
		List<User> chickUsername = userDao.selectUserForPage(username,null, null, 0, 1);
		if ((chickUsername.size()>0) &&(userDao.selectUserByNameAndPwd(username, password))==null) {
			throw new LoginFailException("�û��������벻ƥ��");
		}
		
		User user = userDao.selectUserByNameAndPwd(username, password);
		if (user == null) {
			throw new LoginFailException("�û������ڣ���ע��");
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
			throw new RegisterFailException("�����֤���û��Ѵ��ڣ���˶�");
		};
		List<User> chickUsername = userDao.selectUserForPage(user.getUsername(),null, null, 0, 1);
			if (!(chickUsername.size()>0)) {
				userDao.insertUser(user);
			}else {
				throw new RegisterFailException("���û����ѱ�ʹ�ã�");
			}
		
	}
	@Override
	public Record buyTicket(User user, Ticket ticket) throws buyTicketException, TicketCheckoutException,NullChooseException {
		Record record = new Record();
		List<Ticket> ticketList =	null;
		List<Record> buyStateList =null;
		
		//�ж��Ƿ�ѡ��Ʊ
		if (ticket.getTicket_id()==null){
			throw new NullChooseException("δѡ��Ʊ");
		}
		buyStateList = userDao.selectStateFromTow(user.getId());
		if ((buyStateList.size()==0)|| ((buyStateList.get(0).getBuyState().equals("����Ʊ")) ) ) {
		ticketList = ticketDao.selectTicketByDepartureAndTerminalStation(null, null, null, null, ticket.getTicket_id());
		//�жϵ���Ʊ���ڣ�����һ�ų�Ʊ��״̬ΪΪδ����(�൱���¶���)
		if (ticketList.size()!=0){
			ticket = ticketList.get(0);
			if (ticket.getTicket_state().equals("����")) {
				//����״̬
				throw new buyTicketException("��Ʊ����,�޷�����");
				//��ʾ��Ʊ����
			}
			if (ticket.getTicket_state().equals("�ۿ�")) {
				//�ۿ�״̬
				throw new buyTicketException("��Ʊ����,�޷�����");
				//��ʾ��Ʊ�ۿ�
			}
			//����,����
			if (ticket.getTicket_state().equals("����")) {
				String changeData = "subtract";
				
				if (ticket.getTicket_number() > 0) {
					//�����һ�ų�Ʊ����ȥ�󣬽�״̬��Ϊ�ۿ�
					if (ticket.getTicket_number() == 1) {
						ticket.setTicket_state("�ۿ�");
						ticketDao.updateTicket(ticket);
					}
					ticketDao.updateTicketForRTdata(changeData, ticket.getTicket_id());
				}

				
		//�޸�record�����޸���֪����Ϣ
				record.setTicketId(ticket.getTicket_id());
				record.setTrainNumber(ticket.getTrain_number());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
				java.util.Date date = new java.util.Date();
				record.setBuyTime(sdf.format(date));
				record.setBuyState("1");//δ����
//							���븶��ҳ��
		//		new buyTicketFream(user, ticket, record).start();
//				int unlock =JOptionPane.showConfirmDialog(managerUserFream, "�Ƿ�Ը��û����н�������");
//				if ( unlock !=0 ) {
//					return;
//				}
				return record;
				
			}

		}else {
			throw new TicketCheckoutException("δ�ҵ���Ʊ");
		}

		}else {
			throw new buyTicketException("���Ѿ������˸ó�Ʊ���޷��ظ�����");
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
 * ��ѯ�û���Ʊ��¼
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
				throw new UserNotFoundException("δ�ҵ�����û�");
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
