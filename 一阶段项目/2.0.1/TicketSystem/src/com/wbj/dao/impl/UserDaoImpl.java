package com.wbj.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.wbj.dao.UserDao;
import com.wbj.entity.Recharge;
import com.wbj.entity.Record;
import com.wbj.entity.User;
import com.wbj.mapper.RechargeMapper;
import com.wbj.mapper.RecordMapper;
import com.wbj.mapper.TwoTabaleMapper;
import com.wbj.mapper.UserMapper;
import com.wbj.util.JDBCTemplate;

public class UserDaoImpl implements UserDao {
	JDBCTemplate<User> temp = new JDBCTemplate<User>();
	
	@Override
	public User selectUserByNameAndPwd(String username, String password) {
		

		String sql = new StringBuffer()
			.append(" select  ")	
			.append(" 	user_id,username,password,name,phone_number,id_number,balance,user_state ")	
			.append(" from ")	
			.append(" 	t_user ")	
			.append(" where ")	
			.append(" 	username = ? and ")				
			.append(" 	password = ?  ")				
			.toString();
		
		return temp.selectOne(new UserMapper(), sql,username,password);
	}



	@Override
	public User selectUserById_number(String idNumber) {
	//	List params = new ArrayList();
		String sql = new StringBuffer()
		.append(" select  ")	
		.append(" 	user_id,username,password,name,phone_number,id_number,balance,user_state ")	
		.append(" from ")	
		.append(" 	t_user ")	
		.append(" where ")	
		.append(" 	id_number = ? ")
		.toString();
			
	
	return temp.selectOne(new UserMapper(),sql,idNumber);

	}

	@Override//插入数据
	public void insertUser(User user) {  
		String sql = new StringBuffer()
		.append(" insert into  ")
		.append(" 	t_user(user_id,username,password,name,phone_number,id_number,balance,user_state )  ")
		.append(" values ")	
		.append(" 	(?,?,?,?,?,?,?,?) ")			
		.toString();
	
		temp.insert(sql , user.getId(),user.getUsername(),
			user.getPassword(),user.getName(),user.getPhone_number(),
			 	user.getId_number(),user.getBalance(),user.getUser_state());
		
	}

	@Override
	public void deleteUser(Integer id) {
		String sql = new StringBuffer()
				.append(" delete ")
				.append(" from ")
				.append(" 	t_user  ")
				.append(" where ")
				.append(" 	user_id = ? ")
				.toString();
		temp.delete(sql, id);
	}

	@Override
	public void updateUserState(User user) {
		String sql = new StringBuffer()
				.append(" update ")
				.append(" 	t_user ")
				.append(" set ")
				.append(" 	user_state = ?")
				.append(" where id_number = ? ")
				.toString();
		temp.update(sql,user.getUser_state(),user.getId_number());

	}

	@Override
	public List<User> selectUserForPage(String username,String idNumber,String userState, int startIndxe, int offset) {
		List params = new ArrayList();
		StringBuffer sql = new StringBuffer()
				.append(" select ")
				.append(" 	user_id,username,password,name,phone_number,id_number,balance,user_state ")
				.append(" from ")
				.append(" 	t_user ")
				.append(" where ")
				.append(" 1 = 1 ");

		if(username!=null&&!username.equals("")){
			sql.append(" and username like ? ");
			params.add(username+"%");
		}
		if(idNumber!=null&&!idNumber.equals("")){
			sql.append(" and id_number like ? ");
			params.add(idNumber+"%");
		}
		if(userState!=null&&!userState.equals("")){
			sql.append(" and user_state = ? ");
			params.add(userState);
		}
		sql.append(" limit ?,? ")
				.toString();
		params.add(startIndxe);
		params.add(offset);

		return temp.selectAll(new UserMapper(), sql.toString(),params.toArray());

	}

	/**
	 * ???????????????????////相同的方法,怎么就不能用了呢?
	 * @param startIndxe
	 * @param offset
	 * @return
	 */
	@Override
	public List<Record> selectRecordForPage(Integer userId, int startIndxe, int offset) {
		JDBCTemplate<Record> tempForRecord= new JDBCTemplate<Record>();
		List params = new ArrayList();
		StringBuffer sql = new StringBuffer()
				.append(" select ")
				.append(" 	record_id,user_id,ticket_id,train_number,buy_time,buy_state ")
				.append(" from ")
				.append(" 	t_record ")
				.append(" where ")
				.append(" 1 = 1 ")
				.append(" and user_id = ? ");
				sql.append(" limit ?,? ")
						.toString();
				params.add(userId);
			params.add(startIndxe);
			params.add(offset);
	return tempForRecord.selectAll(new RecordMapper(), sql.toString(),params.toArray());

	}

	@Override
	public void insertRecord(Record record) {
		String sql = new StringBuffer()
				.append(" insert into  ")
				.append(" 	t_record(user_id,ticket_id,train_number,buy_time,buy_state)  ")
				.append(" values ")
				.append(" 	(?,?,?,?,?) ")
				.toString();
		temp.insert(sql ,record.getUserId(),record.getTicketId(),
				record.getTrainNumber(),record.getBuyTime(),record.getBuyState());
	}

	@Override
	public void deleteRecord(Integer recordId) {
		String sql = new StringBuffer()
				.append(" delete ")
				.append(" from ")
				.append(" 	t_record  ")
				.append(" where ")
				.append(" 	record_id = ? ")
				.toString();
		temp.delete(sql, recordId);
	}

	@Override
	public void updateRecord(Record record) {
		String sql = new StringBuffer()
				.append(" update ")
				.append(" 	t_record ")
				.append(" set ")
				.append(" 	buy_state = ? ")
				.append("where record_id = ? ")
				.toString();
		temp.update(sql,record.getBuyState(),record.getRecordId());
	}

	/**
	 * 添加用户金额? 初步
	 * 应该在原有基础上增加
	 * @param user
	 */
	@Override
	public void updateUserBalance(User user) {
		String sql = new StringBuffer()
		.append(" update ")
		.append(" 	t_user ")
		.append(" set ")
		.append(" 	balance = balance + ?")
		.append(" where  user_id = ? ")
		.toString();
temp.update(sql,user.getBalance(),user.getId());

		
	}



	@Override
	public List<Record> selectRecordForId(Integer recordId) {
		JDBCTemplate<Record> tempForRecord= new JDBCTemplate<Record>();
		List params = new ArrayList();
		String sql = new StringBuffer()
				.append(" select ")
				.append(" 	record_id,user_id,ticket_id,train_number,buy_time,buy_state ")
				.append(" from ")
				.append(" 	t_record ")
				.append(" where ")
				.append(" 1 = 1 ")
				.append(" and record_id = ? ")
				.toString();
			params.add(recordId);
	return tempForRecord.selectAll(new RecordMapper(), sql,params.toArray());

	}

	JDBCTemplate<Recharge> tempForRecharge= new JDBCTemplate<Recharge>();

	@Override
	public void deleteRecharge(Integer rechargeId) {
		String sql = new StringBuffer()
		.append(" delete ")
		.append(" from ")
		.append(" 	t_recharge  ")
		.append(" where ")
		.append(" 	recharge_id = ? ")
		.toString();
		temp.delete(sql, rechargeId);
		
	}



	@Override
	public void insertRecharge(Recharge recharge) {
		String sql = new StringBuffer()
		.append(" insert into  ")
		.append(" 	t_recharge(recharge_id,user_id,username,apply_money,apply_time,apply_state)  ")
		.append(" values ")
		.append(" 	(?,?,?,?,?,?) ")
		.toString();
temp.insert(sql ,recharge.getRechargeId(),recharge.getUserId(),recharge.getUsername(),recharge.getApplyMoney(),recharge.getApplyTime(),recharge.getApplyState());

		
	}



	@Override
	public List<Recharge> selectRechargeForId(Integer rechargeId) {

		List params = new ArrayList();
		String sql = new StringBuffer()
				.append(" select ")
				.append(" 	recharge_id,user_id,username,apply_money,apply_time,apply_state ")
				.append(" from ")
				.append(" 	t_recharge ")
				.append(" where ")
				.append(" 1 = 1 ")
				.append(" and recharge_id = ? ")
				.toString();
			params.add(rechargeId);
	return tempForRecharge.selectAll(new RechargeMapper(), sql,params.toArray());
	
	}

	@Override
	public List<Recharge> selectRechargeForUserId(Integer userId) {
		List params = new ArrayList();
		String sql = new StringBuffer()
				.append(" select ")
				.append(" 	recharge_id,user_id,username,apply_money,apply_time,apply_state ")
				.append(" from ")
				.append(" 	t_recharge ")
				.append(" where ")
				.append(" 1 = 1 ")
				.append(" and user_id = ? ")
				.toString();
		params.add(userId);
		return tempForRecharge.selectAll(new RechargeMapper(), sql,params.toArray());
	}


	@Override
	public List<Recharge> selectRechargeForPage(Integer rechargeId,
			int startIndxe, int offset) {
		List params = new ArrayList();
		StringBuffer sql = new StringBuffer()
				.append(" select ")
				.append(" 	recharge_id,user_id,username,apply_money,apply_time,apply_state ")
				.append(" from ")
				.append(" 	t_recharge ")
				.append(" where ")
				.append(" 1 = 1 ")
				.append(" and recharge_id = ? ");
				sql.append(" limit ?,? ")
						.toString();
				params.add(rechargeId);
			params.add(startIndxe);
			params.add(offset);
	return tempForRecharge.selectAll(new RechargeMapper(), sql.toString(),params.toArray());

	}

	@Override
	public List<Recharge> selectRechargeForPage(int startIndxe, int offset) {
		List params = new ArrayList();
		StringBuffer sql = new StringBuffer()
				.append(" select ")
				.append(" 	recharge_id,user_id,username,apply_money,apply_time,apply_state ")
				.append(" from ")
				.append(" 	t_recharge ");
			sql.append(" limit ?,? ")
				.toString();

		params.add(startIndxe);
		params.add(offset);
		return tempForRecharge.selectAll(new RechargeMapper(), sql.toString(),params.toArray());

	}


	@Override
	public void updateRecharge(Recharge Recharge) {
		String sql = new StringBuffer()
		.append(" update ")
		.append(" 	t_recharge ")
		.append(" set ")
		.append(" 	apply_state = ? ")
		.append("where recharge_id = ? ")
		.toString();
	temp.update(sql,Recharge.getApplyState(),Recharge.getRechargeId());
		
	}

	/**
	 * 对状态为未处理,user_ID = recharge.userid的 数据进行整合
	 * 11-06 00:14
	 * @param Recharge
	 *
	 */
	@Override
	public void updateRechargeByUserId(Recharge Recharge) {
		String sql = new StringBuffer()
				.append(" update ")
				.append(" 	t_recharge ")
				.append(" set ")
				.append(" 	apply_money = apply_money + ? ")
				.append(" 	, apply_time = ?	 ")
				.append("where 1=1 ")
				.append(" 	and apply_state = '1' ")
				.append(" 	and user_id = ?")
				.toString();
		temp.update(sql,Recharge.getApplyMoney(),Recharge.getApplyTime(),Recharge.getUserId());
	}



	@Override
	public List<Record> selectStateFromTow(Integer userId) {

		JDBCTemplate<Record> tempForRecord= new JDBCTemplate<Record>();
		List params = new ArrayList();
		String sql = new StringBuffer()
				.append(" select ")
				.append(" 	r.record_id,t.ticket_id,r.buy_state ")
				.append(" from ")
				.append(" 	t_record r ,t_ticket t  ")
				.append(" where ")
				.append("  t.ticket_id = r.ticket_id  ")
				.append(" and r.user_id =  ? ")
				.append(" group by  ")
				.append(" 	 r.record_id  ")
				.append("  desc; ")
				.toString();
			params.add(userId);
	return tempForRecord.selectAll(new TwoTabaleMapper(), sql,params.toArray());

	
	}


}
