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
	 * ���������Ϣ���ҳ�Ʊ
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
	 * ���복Ʊ
	 * @param ticket
	 * @throws TicketCheckoutException
	 */
	public void  insertTicket(Ticket ticket) throws TicketCheckoutException;
	/**
	 * ���ݳ���ɾ����Ʊ
	 * @param ticketNumber
	 * @throws TicketCheckoutException
	 */
	public void  delect(String ticketNumber) throws TicketCheckoutException;
	
	/**
	 * �޸ĳ�Ʊ������Ա���������ݴ���Ķ����޸�
	 * @param ticket
	 * @throws TicketCheckoutException
	 */
	public void update(Ticket ticket) throws TicketCheckoutException;
	
	/**
	 * ����ʵʱ���ݸ��ĳ�Ʊ��Ϣ
	 * @param changeData
	 * @param ticketId
	 * @throws TicketCheckoutException
	 * @throws updataException
	 * @throws buyTicketException 
	 */
	public void updateTicketForRTdata(String changeData,Integer ticketId )throws TicketCheckoutException,updataException, buyTicketException;
	public void refundTicketForRTdata(Integer recordId)throws TicketCheckoutException,updataException, buyTicketException, RefundTicketException;
	/**
	 * ����ҳ����ҳ�Ʊ
	 */
	public Pager selectTicketPageRecords(String pagenums);
	/**
	 * ͨ��ʼ��վ���յ�վ����ҳ�룬���ҳ�Ʊ
	 */
	public Pager selectTicletPageRecordsStation(String departureStation, String terminalStation,String departureTime, String ticketNumber,String pagenums);


	/**
	 * ��Ʊ����
	 */
	public User refundTicket(User user , Integer recordId) throws RefundTicketException, TicketCheckoutException;



}
