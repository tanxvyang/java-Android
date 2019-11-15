package com.wbj.service.proxy;

import com.wbj.entity.Recharge;
import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.exception.*;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.UserService;
import com.wbj.trans.Transaction;
import com.wbj.util.Pager;

public class UserServiceProxy implements UserService{
	UserService userService = (UserService) ObjectFactory.getObject("userService");
	Transaction trans = (Transaction) ObjectFactory.getObject("trans");

	@Override
	public User login(String username, String password)
			throws LoginFailException ,Exception{
		User user = null;
		trans.begin();
		try {
			user = userService.login(username, password);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw e;
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
		trans.begin();
		try {
			userService.register(user);
			trans.commit();
		} catch (RegisterFailException e) {
			trans.rollback();
			throw e;
			}
		
		
	}

	@Override
	public Record buyTicket(User user, Ticket ticket) throws buyTicketException, TicketCheckoutException, NullChooseException {
			return userService.buyTicket(user,ticket);
	}


	@Override
	public Pager<Record> selectUserPageRecords(Integer userId,String pagenums) {
		
		Pager<Record> pager = null;
		
		trans.begin();
		try {
			pager = userService.selectUserPageRecords(userId, pagenums);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		return pager;
	}
	@Override
	public User selectUserByidNumber(String idNumber)
			throws UserNotFoundException {
		User user = null;
		trans.begin();
		try {
			user = userService.selectUserByidNumber(idNumber);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		return user;
	}
	@Override
	public Pager selectUserForPage(String username, String idNumber,
			String userState, String pagenums) {
		Pager<User> pager = null;
		trans.begin();
		try {
			pager = userService.selectUserForPage(username,idNumber,userState,pagenums);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
		return pager;
	}
	@Override
	public void updateUserState(User user) {
		trans.begin();
		try {
			userService.updateUserState(user);
		trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
	}
	@Override
	public void addRecord(Record record) {
		trans.begin();
		try {
			userService.addRecord(record);
		trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	@Override
	public Pager showUserRecord() {
		return null;
	}
	@Override
	public void updateRecord(Record record) {
		trans.begin();
		try {
			userService.updateRecord(record);
		trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	@Override
	public void updateUserBalance(User user) {
		trans.begin();
		try {
			userService.updateUserBalance(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	@Override
	public Record selectRecordById(Integer recordId) {

		Record  record =null;
		trans.begin();
		try {
			record = userService.selectRecordById(recordId);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		return record;
	}
	@Override
	public void addRecharge(Recharge recharge) {
		trans.begin();
		try {
			userService.addRecharge(recharge);
		trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	@Override
	public void deleteRecharge(Integer rechargeId) {
		trans.begin();
		try {
			userService.deleteRecharge(rechargeId);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	@Override
	public Recharge selectRechargeById(Integer rechargeId) {
		Recharge  recharge =null;
		trans.begin();
		try {
			recharge = userService.selectRechargeById(rechargeId);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		return recharge;
	}

	@Override
	public Recharge selectRechargeForUserId(Integer userId) throws RechargeNotFindExceptipn {
		Recharge  recharge =null;
		trans.begin();
		try {
			recharge = userService.selectRechargeForUserId(userId);
			trans.commit();
		} catch (Exception e) {

			trans.rollback();
		}
		return recharge;
	}

	@Override
	public void updateRechargeByUserId(Recharge Recharge) {
		trans.begin();
		try {
			userService.updateRechargeByUserId(Recharge);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}

	}

	@Override
	public void updateRecharge(Recharge Recharge) {
		trans.begin();
		try {
			userService.updateRecharge(Recharge);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
	}

	/**
	 * 11-06 00:44
	 * @param rechargeId
	 * @param pagenums
	 * @return
	 */
	@Override
	public Pager<Recharge> selectUserPageRecharge(Integer rechargeId,
			String pagenums) {
		Pager<Recharge> pager = null;

		trans.begin();
		try {
			System.out.println(userService);
			pager = userService.selectUserPageRecharge(rechargeId,pagenums);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		}
		return pager;
	}

	@Override
	public Pager<Recharge> selectUserPageRecharge(String pagenums) {
		Pager<Recharge> pager = null;

		trans.begin();
		try {
			pager = userService.selectUserPageRecharge(pagenums);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		}
		return pager;
	}

	@Override
	public void deleteRrecord(Integer recordId) {
		trans.begin();
		try {
			userService.deleteRrecord(recordId);
		trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	@Override
	public User refresh(User user) {
		trans.begin();
		try {
			user = userService.selectUserByidNumber(user.getId_number());
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		return user;
	}

}
