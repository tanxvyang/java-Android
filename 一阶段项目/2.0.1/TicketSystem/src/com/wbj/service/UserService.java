package com.wbj.service;

import com.wbj.entity.Recharge;
import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.exception.*;
import com.wbj.util.Pager;

import java.util.List;

public interface UserService {
	public User login(String username,String password) throws LoginFailException ,Exception;
	public void register(User user) throws RegisterFailException;
	public Record buyTicket(User user , Ticket ticket)throws buyTicketException,TicketCheckoutException, NullChooseException;


	/**
	 * �����û�����
	 * @param user
	 * @return
	 */
	public User refresh(User user);
	
	public Pager selectUserForPage(String username,String idNumber,String userState,String pagenums);
	
	public Pager<User> getUserByPageAndCond(String name,
			Integer age,String city, Integer pageNo);
	
	public User selectUserByidNumber(String idNumber)throws UserNotFoundException;
	
	public void updateUserState(User user);
	
	public void updateUserBalance(User user);

	
	
	/**
	 * ����û���Ʊ��¼
	 * @param record
	 */
	public void addRecord(Record record);
	
	
	/**
	 * �޸��û���Ʊ��¼
	 * @param record
	 */
	public void updateRecord(Record record);
	
	public void deleteRrecord(Integer recordId);
	
	public Pager showUserRecord();
	/**
	 * ��ҳ��ʾ�û���Ʊ��¼
	 * @param pagenums
	 * @return
	 */
	public Pager<Record> selectUserPageRecords(Integer userId,String pagenums);
	public Record selectRecordById(Integer recordId);
	
	
	/**
	 * ��������¼
	 * @param recharge
	 */
	public void addRecharge(Recharge recharge);
	
	/**
	 * ��ҳ���������¼
	 * @param rechargeId
	 * @param pagenums
	 * @return
	 */
	public Pager<Recharge> selectUserPageRecharge(Integer rechargeId,String pagenums);
	public Pager<Recharge> selectUserPageRecharge(String pagenums);

	/**
	 * ����rechargeId ���������¼
	 */
	public Recharge  selectRechargeById(Integer rechargeId);
	public Recharge selectRechargeForUserId(Integer userId)throws RechargeNotFindExceptipn;
	public void  updateRechargeByUserId(Recharge Recharge);
	public void  updateRecharge(Recharge Recharge);

	public void deleteRecharge(Integer rechargeId);

}
