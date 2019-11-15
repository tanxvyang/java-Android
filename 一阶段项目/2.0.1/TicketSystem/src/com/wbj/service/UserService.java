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
	 * 更新用户数据
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
	 * 添加用户购票记录
	 * @param record
	 */
	public void addRecord(Record record);
	
	
	/**
	 * 修改用户购票记录
	 * @param record
	 */
	public void updateRecord(Record record);
	
	public void deleteRrecord(Integer recordId);
	
	public Pager showUserRecord();
	/**
	 * 分页显示用户购票记录
	 * @param pagenums
	 * @return
	 */
	public Pager<Record> selectUserPageRecords(Integer userId,String pagenums);
	public Record selectRecordById(Integer recordId);
	
	
	/**
	 * 添加申请记录
	 * @param recharge
	 */
	public void addRecharge(Recharge recharge);
	
	/**
	 * 分页查找申请记录
	 * @param rechargeId
	 * @param pagenums
	 * @return
	 */
	public Pager<Recharge> selectUserPageRecharge(Integer rechargeId,String pagenums);
	public Pager<Recharge> selectUserPageRecharge(String pagenums);

	/**
	 * 根据rechargeId 查找申请记录
	 */
	public Recharge  selectRechargeById(Integer rechargeId);
	public Recharge selectRechargeForUserId(Integer userId)throws RechargeNotFindExceptipn;
	public void  updateRechargeByUserId(Recharge Recharge);
	public void  updateRecharge(Recharge Recharge);

	public void deleteRecharge(Integer rechargeId);

}
