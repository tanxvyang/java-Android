package com.wbj.dao;

import java.sql.Date;
import java.util.List;

import com.wbj.entity.Recharge;
import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;

/**
 * userDao �ӿ� �涨 UserDaoҪʵ�ֵķ���
 * @author soft01
 *
 */
public interface UserDao {
	public User selectUserByNameAndPwd(String username, String password);

	public User selectUserById_number(String id_number);

	public void insertUser(User user);

	public void deleteUser(Integer id);

	public void updateUserState(User user);

	public void updateUserBalance(User user);

	public List<User> selectUserForPage(String username, String idNumber,
			String userState, int startIndxe, int offset);

	/**
	 * ��ҳ��ѯ�û���Ʊ��¼
	 * @param userId
	 * @param startIndxe
	 * @param offset
	 * @return
	 */
	public List<Record> selectRecordForPage(Integer userId, int startIndxe,
			int offset);

	public List<Record> selectRecordForId(Integer recordId);

	public List<Record> selectStateFromTow(Integer userId);

	public void insertRecord(Record record);

	public void deleteRecord(Integer recordId);

	public void updateRecord(Record record);
	
	/**
	 * �û���ֵ�����
	 * @param rechargeId
	 * @param startIndxe
	 * @param offset
	 * @return
	 */

	public List<Recharge> selectRechargeForPage(Integer rechargeId,
			int startIndxe, int offset);

	public List<Recharge> selectRechargeForPage(int startIndxe, int offset);

	public List<Recharge> selectRechargeForId(Integer rechargeId);

	public List<Recharge> selectRechargeForUserId(Integer userId);

	public void insertRecharge(Recharge recharge);

	public void deleteRecharge(Integer rechargeId);

	public void updateRecharge(Recharge Recharge);

	public void updateRechargeByUserId(Recharge Recharge);
	

}
