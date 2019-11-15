package com.wbj.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.wbj.dao.CountDao;
import com.wbj.dao.TicketDao;
import com.wbj.dao.UserDao;
import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.exception.RefundTicketException;
import com.wbj.exception.TicketCheckoutException;
import com.wbj.exception.buyTicketException;
import com.wbj.exception.updataException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.TicketService;
import com.wbj.util.Pager;

public class TicketServiceImpl implements TicketService{
	TicketDao ticketDao = (TicketDao) ObjectFactory.getObject("ticketDao");
	CountDao countDao = (CountDao) ObjectFactory.getObject("countDao");
	UserDao userDao = (UserDao) ObjectFactory.getObject("userDao");

	@Override
	public void insertTicket(Ticket ticket) throws TicketCheckoutException {
		ticketDao.insertTicket(ticket);
	}

	@Override
	public List<Ticket> selectTicketByDate(String departure_time)
			throws TicketCheckoutException {

		List<Ticket> ticket = ticketDao.selectTicketByDate(departure_time);
		if (ticket.size() == 0) {
			throw new TicketCheckoutException("未找到相应车票");
		}

		return ticket;
	}

	@Override
	public List<Ticket> selectTicketByDepartureAndTerminalStation(
			String departureStation, String terminalStation,
			String departureTime, String ticketNumber, Integer ticketId)
			throws TicketCheckoutException, Exception {
		List<Ticket> ticket = ticketDao
				.selectTicketByDepartureAndTerminalStation(departureStation,
						terminalStation, departureTime, ticketNumber, ticketId);
		if (ticket.size() == 0) {
			throw new TicketCheckoutException("未找到相应车票");
		}

		return ticket;
	}

	@Override
	public void delect(String ticketNumber) throws TicketCheckoutException {
		List<Ticket> ticket = ticketDao
				.selectTicketByDepartureAndTerminalStation(null, null, null,
						ticketNumber, null);
		if (ticket.size() == 0) {
			throw new TicketCheckoutException("无法删除，未找到相应车票");
		}
		ticketDao.deleteTicket(ticketNumber);
	}

	@Override
	public void update(Ticket ticket) throws TicketCheckoutException {
		List<Ticket> searchTicket = ticketDao
				.selectTicketByDepartureAndTerminalStation(null, null, null,
						null, ticket.getTicket_id());
		if (searchTicket.size() == 0) {
			throw new TicketCheckoutException("无法更改，未找到相应车票");
		}
		ticketDao.updateTicket(ticket);
	}

	@Override
	public Pager selectTicketPageRecords(String pagenums) {
		int currentPageNum = 1;
		if (pagenums != null) {
			currentPageNum = Integer.parseInt(pagenums);
		}
		int totalRrecords = countDao.countTicket();

		Pager pager = new Pager(currentPageNum, totalRrecords);
		pager.setData(ticketDao.selectTicketForPage(pager.getStartIndex(),
				pager.getPageSize()));
		return pager;
	}

	@Override
	public Pager selectTicletPageRecordsStation(String departureStation,
			String terminalStation, String departureTime, String ticketNumber,
			String pagenums) {
		int currentPageNum = 1;
		if (pagenums != null) {
			currentPageNum = Integer.parseInt(pagenums);
		}
		int totalRrecords = countDao.countTicket();

		Pager pager = new Pager(currentPageNum, totalRrecords);
		pager.setData(ticketDao.selectTicketForPage(departureStation,
				terminalStation, departureTime, ticketNumber, pager
						.getStartIndex(), pager.getPageSize()));
		return pager;
	}

	@Override
	public User refundTicket(User user, Integer recordId)
			throws RefundTicketException, TicketCheckoutException {
		List<Ticket> ticketList = null;
		Ticket ticket = null;
		List<Record> records = userDao.selectRecordForId(recordId);
		if (records.size() != 0) {
			Record getrecord = records.get(0);
			ticketList = ticketDao.selectTicketByDepartureAndTerminalStation(
					null, null, null, null, getrecord.getTicketId());
			if (ticketList.size() != 0) {

				ticket = ticketList.get(0);
				if ((ticket.getTicket_state().equals("停售"))) {
					throw new RefundTicketException("车票已停售,无法退票");
				} else {

					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm");
					String date = sdf.format(new Date());

					String changeData = "add";
					ticketDao.updateTicketForRTdata(changeData, ticket
							.getTicket_id());

					user.setBalance(ticket.getTicket_price());
					//
					// //修改用户余额（退款）

					userDao.updateUserBalance(user);

					getrecord.setBuyState("已退票");// 2.表示已付款
					// //添加向数据库中添加记录

					userDao.updateRecord(getrecord);
					// }

					return user;
				}

			} else {
				throw new TicketCheckoutException("未找到相关车票");
			}
		}
		return user;

	}

	@Override
	public void updateTicketForRTdata(String changeData, Integer ticketId)throws TicketCheckoutException, updataException, buyTicketException {
		List<Ticket> searchTicket =  ticketDao.selectTicketByDepartureAndTerminalStation(null, null, null, null, ticketId);
		if (searchTicket.size()!=0) {
			Ticket ticket = searchTicket.get(0);
		if (ticket.getTicket_number() == 0 && changeData.equals("subtract")) {	
			throw new updataException("车票数为零，无法修改");
		}
		if (ticket.getTicket_state().equals("开售")) {
			if (ticket.getTicket_number() > 0) {
				//当最后一张车票被减去后，将状态改为售空
				if (ticket.getTicket_number() == 1) {
					ticket.setTicket_state("售空");
					ticketDao.updateTicket(ticket);
				}
				ticketDao.updateTicketForRTdata(changeData, ticketId);
				
			}
			
		}else if (ticket.getTicket_state().equals("售空") && changeData.equals("add") ) {
			
			ticket.setTicket_state("开售");
			ticketDao.updateTicket(ticket);
			
			ticketDao.updateTicketForRTdata(changeData, ticketId);
			
		} else {
			throw new buyTicketException("车票未开售，无法购票");
		}
		}else {
			
			throw new TicketCheckoutException("无法更改，未找到相应车票");
		}
	}

	@Override
	public void refundTicketForRTdata(Integer recordId)
			throws TicketCheckoutException, updataException,
			buyTicketException, RefundTicketException {
		List<Ticket> ticketList = null;
		Ticket ticket = null;
		List<Record> records = userDao.selectRecordForId(recordId);

		Record getrecord = records.get(0);
		ticketList = ticketDao.selectTicketByDepartureAndTerminalStation(null,
				null, null, null, getrecord.getTicketId());
		if (ticketList.size() != 0) {

			ticket = ticketList.get(0);
			if ((ticket.getTicket_state().equals("停售"))
					|| (ticket.getTicket_state().equals("无效"))) {
				throw new RefundTicketException("车票已停售,无法退票");
			} else {

				String changeData = "add";

				if (ticket.getTicket_state().equals("售空")) {

					ticket.setTicket_state("开售");
					ticketDao.updateTicket(ticket);
				}

				ticketDao.updateTicketForRTdata(changeData, ticket
						.getTicket_id());
				getrecord.setBuyState("已退票");// 2.表示已付款
				// //添加向数据库中添加记录

				userDao.updateRecord(getrecord);

			}

		} else {
			throw new TicketCheckoutException("未找到相关车票");
		}

	}


}
