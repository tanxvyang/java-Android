package com.wbj.entity;

import java.sql.Date;

/**
 * 用户购票记录
 * 用于记载用户购票的全部记录
 * record_id int primary key auto_increment, #编号
 * 	user_id int references t_user(user_id),		#用户编号
 * 	ticket_id int references t_ticket(ticket_id),	#车票编号
 * 	train_number varchar(10)  references  t_ticket(train_number),  # 车次
 * 	buy_time date,									#购买时间
 * 	buy_state varchar(3)
 */
public class Record {
 private Integer recordId ;
 private Integer userId ;
 private Integer ticketId ;
 private String trainNumber;  //车次
 private String buyTime;         //购买时间
 private String buyState;      //购买状态,1 未付款，2 已付款，3 已退票

 public Record() {
 }

 

 @Override
public String toString() {
	return "Record [buyState=" + buyState + ", buyTime=" + buyTime
			+ ", recordId=" + recordId + ", ticketId=" + ticketId
			+ ", trainNumber=" + trainNumber + ", userId=" + userId + "]";
}



public Record(Integer recordId, Integer userId, Integer ticketId,
		String trainNumber, String buyTime, String buyState) {
	super();
	this.recordId = recordId;
	this.userId = userId;
	this.ticketId = ticketId;
	this.trainNumber = trainNumber;
	this.buyTime = buyTime;
	this.buyState = buyState;
}



public Integer getRecordId() {
  return recordId;
 }

 public void setRecordId(Integer recordId) {
  this.recordId = recordId;
 }

 public Integer getUserId() {
  return userId;
 }

 public void setUserId(Integer userId) {
  this.userId = userId;
 }

 public Integer getTicketId() {
  return ticketId;
 }

 public void setTicketId(Integer ticketId) {
  this.ticketId = ticketId;
 }

 public String getTrainNumber() {
  return trainNumber;
 }

 public void setTrainNumber(String trainNumber) {
  this.trainNumber = trainNumber;
 }

 

 public String getBuyTime() {
	return buyTime;
}



public void setBuyTime(String buyTime) {
	this.buyTime = buyTime;
}



public String getBuyState() {
	//1 未付款，2 已付款，3 已退票
	if (buyState.equals("1")) {
		return "未付款" ;
	}
	if (buyState.equals("2")) {
		return "已购买" ;
	}
	if (buyState.equals("3")) {
		return "已退票" ;
	}
	
	if (buyState.equals("未付款")) {
		return "1" ;
	}
	if (buyState.equals("已购买")) {
		return "2" ;
	}
	if (buyState.equals("已退票")) {
		return "3" ;
	}
	
  return buyState;
 }

 public void setBuyState(String buyState) {
  this.buyState = buyState;
 }


}
