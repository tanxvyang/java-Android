package com.wbj.service.proxy;

import java.util.Date;
import java.util.List;

import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.exception.RefundTicketException;
import com.wbj.exception.TicketCheckoutException;
import com.wbj.exception.buyTicketException;
import com.wbj.exception.updataException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.TicketService;
import com.wbj.service.UserService;
import com.wbj.trans.Transaction;
import com.wbj.util.Pager;

public class TickerServiceProxy implements TicketService {
	TicketService ticketService = (TicketService) ObjectFactory
			.getObject("ticketService");
	Transaction trans = (Transaction) ObjectFactory.getObject("trans");

	@Override
	public void insertTicket(Ticket ticket) throws TicketCheckoutException {
		trans.begin();
		try {
			ticketService.insertTicket(ticket);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}

	}

	@Override
	public List<Ticket> selectTicketByDate(String departureTime)
			throws TicketCheckoutException {
		List<Ticket> tickte = null;
		trans.begin();
		try {
			tickte = ticketService.selectTicketByDate(departureTime);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		return tickte;
	}

	@Override
	public List<Ticket> selectTicketByDepartureAndTerminalStation(
			String departureStation, String terminalStation,
			String departureTime, String ticketNumber, Integer ticketId)
			throws TicketCheckoutException {
		List<Ticket> tickte = null;
		trans.begin();
		try {
			tickte = ticketService.selectTicketByDepartureAndTerminalStation(
					departureStation, terminalStation, departureTime,
					ticketNumber, ticketId);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		return tickte;
	}

	@Override
	public void delect(String ticketNumber) throws TicketCheckoutException {
		trans.begin();
		try {
			ticketService.delect(ticketNumber);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}

	}

	@Override
	public void update(Ticket ticket) throws TicketCheckoutException {
		trans.begin();
		try {
			ticketService.update(ticket);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}

	}

	@Override
	public Pager selectTicketPageRecords(String pagenums) {
		Pager<Ticket> pager = null;
		trans.begin();
		try {
			pager = ticketService.selectTicketPageRecords(pagenums);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		return pager;
	}

	@Override
	public Pager selectTicletPageRecordsStation(String departureStation,
			String terminalStation, String departureTime, String ticketNumber,
			String pagenums) {

		Pager<Ticket> pager = null;
		trans.begin();
		try {
			pager = ticketService.selectTicletPageRecordsStation(
					departureStation, terminalStation, departureTime,
					ticketNumber, pagenums);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		return pager;
	}

	@Override
	public User refundTicket(User user, Integer recordId)
			throws RefundTicketException, TicketCheckoutException {
		trans.begin();
		try {
			user = ticketService.refundTicket(user, recordId);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();

		}

		return user;
	}

	@Override
	public void updateTicketForRTdata(String changeData, Integer ticketId)
			throws TicketCheckoutException, updataException {
		trans.begin();
		try {
			ticketService.updateTicketForRTdata(changeData, ticketId);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}

	}

	@Override
	public void refundTicketForRTdata(Integer recordId)
			throws TicketCheckoutException, updataException,
			buyTicketException, RefundTicketException {
		trans.begin();
		try {
			ticketService.refundTicketForRTdata(recordId);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}

	}

}
