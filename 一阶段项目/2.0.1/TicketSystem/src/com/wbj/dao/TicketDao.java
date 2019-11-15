package com.wbj.dao;

import java.util.Date;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.wbj.entity.Ticket;

public interface TicketDao {



	public List<Ticket> selectTicketByDepartureAndTerminalStation(
			String departure_station, String terminal_station,
			String departureTime, String ticket_Number, Integer ticket_id);

	public List<Ticket> selectTicketByDate(String departure_time);

	public void insertTicket(Ticket ticket);

	public void updateTicket(Ticket ticket);// �޸ĳ�Ʊ

	// ʵʱ�޸ĳ�Ʊ�����ڵ�ǰ���ݿ�����������޸ģ�����д�������
	public void updateTicketForRTdata(String changeData, Integer ticketId);

	public void deleteTicket(String train_number);

	public List<Ticket> selectTicketForPage(int startIndxe, int offset);

	public List<Ticket> selectTicketForPage(String departureStation,
			String terminalStation, String departureTime, String ticketNumber,
			int startIndxe, int offset);

}
