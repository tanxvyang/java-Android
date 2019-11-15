package com.wbj.service;

import java.util.Date;
import java.util.List;

import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.exception.RefundTicketException;
import com.wbj.exception.TicketCheckoutException;
import com.wbj.exception.buyTicketException;
import com.wbj.exception.updataException;
import com.wbj.util.Pager;

public interface TicketService {
	/**
	 * 根据相关信息查找车票
	 * @param departureStation
	 * @param terminalStation
	 * @param departureTime
	 * @param ticketNumber
	 * @param ticketId
	 * @return
	 * @throws TicketCheckoutException
	 * @throws Exception
	 */
	public List<Ticket> selectTicketByDepartureAndTerminalStation(String departureStation, String terminalStation,String departureTime,String ticketNumber ,Integer ticketId) throws TicketCheckoutException,Exception;
	
	public List<Ticket> selectTicketByDate(String departure_time ) throws TicketCheckoutException;
	/**
	 * 插入车票
	 * @param ticket
	 * @throws TicketCheckoutException
	 */
	public void  insertTicket(Ticket ticket) throws TicketCheckoutException;
	/**
	 * 根据车次删除车票
	 * @param ticketNumber
	 * @throws TicketCheckoutException
	 */
	public void  delect(String ticketNumber) throws TicketCheckoutException;
	
	/**
	 * 修改车票，管理员操作，根据传入的对象修改
	 * @param ticket
	 * @throws TicketCheckoutException
	 */
	public void update(Ticket ticket) throws TicketCheckoutException;
	
	/**
	 * 根据实时数据更改车票信息
	 * @param changeData
	 * @param ticketId
	 * @throws TicketCheckoutException
	 * @throws updataException
	 * @throws buyTicketException 
	 */
	public void updateTicketForRTdata(String changeData,Integer ticketId )throws TicketCheckoutException,updataException, buyTicketException;
	public void refundTicketForRTdata(Integer recordId)throws TicketCheckoutException,updataException, buyTicketException, RefundTicketException;
	/**
	 * 根据页码查找车票
	 */
	public Pager selectTicketPageRecords(String pagenums);
	/**
	 * 通过始发站和终到站还有页码，查找车票
	 */
	public Pager selectTicletPageRecordsStation(String departureStation, String terminalStation,String departureTime, String ticketNumber,String pagenums);


	/**
	 * 退票操作
	 */
	public User refundTicket(User user , Integer recordId) throws RefundTicketException, TicketCheckoutException;



}
