package com.wbj.dao.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wbj.dao.TicketDao;
import com.wbj.entity.Ticket;
import com.wbj.mapper.TicketMapper;
import com.wbj.util.JDBCTemplate;

public class TicketDaoImpl implements TicketDao {
	JDBCTemplate<Ticket> temp = new JDBCTemplate<Ticket>();
	@Override
	public void insertTicket(Ticket ticket) {
		String sql = new StringBuffer()
		.append(" insert into  ")
		.append(" 	t_ticket(  ")
		.append(" 	ticket_id,departure_station,terminal_station,departure_time,ticket_number,ticket_state,train_number,ticket_price) ")	
	     .append(" values ")	
		.append(" 	(?,?,?,?,?,?,?,?) ")			
		.toString();
		temp.insert(sql, ticket.getTicket_id(),ticket.getDeparture_station(),
				ticket.getTerminal_station(),ticket.getDeparture_time(),
				ticket.getTicket_number(),ticket.getTicket_state(),ticket.getTrain_number(),
				ticket.getTicket_price()
			);
	}

	@Override
	public  List<Ticket> selectTicketByDate(String departureTime) {
		String sql = new StringBuffer()
		.append(" select  ")	
		.append(" 	ticket_id,departure_station,terminal_station,departure_time,ticket_number,ticket_state,train_number,ticket_price ")	
		.append(" from ")	
		.append(" 	t_ticket ")	
		.append(" where ")	
		.append(" 	departure_time = ? ")				
		.toString();
	
	return  temp.selectAll(new TicketMapper(), sql,departureTime);

		
	}

	@Override
	public  List<Ticket> selectTicketByDepartureAndTerminalStation(
			String departureStation, String terminalStation,String departureTime,String ticketNumber ,Integer ticketId) {
		List params = new ArrayList();
		StringBuffer sql = new StringBuffer()
			.append(" select  ")	
			.append(" 	ticket_id,departure_station,terminal_station,departure_time,ticket_number,ticket_state,train_number,ticket_price ")	
			.append(" from ")	
			.append(" 	t_ticket ")	
			.append(" where ")	
			.append(" 	1 = 1 ");	
			
			if(departureStation!=null&&!departureStation.equals("")){
				sql.append(" and departure_station = ? ");	
				params.add(departureStation);
			}
			if(terminalStation!=null&&!terminalStation.equals("")){
				sql.append(" and terminal_station = ? ");
				params.add(terminalStation);
			}
			if(departureTime!=null&&!departureTime.equals("")){
				sql.append(" and departure_time = ? ");
				params.add(departureTime);
			}
			if(ticketNumber!=null&&!ticketNumber.equals("")){
				sql.append(" and train_number = ? ");	
				params.add(ticketNumber);
			}
			if(ticketId!=null&&!ticketId.equals("")){
				sql.append(" and ticket_id = ? ");	
				params.add(ticketId);
			}
			//	sql.append(" order by departure_time ");
		
		return temp.selectAll(new TicketMapper(), sql.toString(), params.toArray());

	}

	@Override
	public void deleteTicket(String trainNumber) {  //
		String sql = new StringBuffer()
			.append(" delete ")
			.append(" from ")
			.append(" 	t_ticket  ")
			.append(" where ")
			.append(" 	train_number = ? ")
			.toString();
		temp.delete(sql, trainNumber);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		List params = new ArrayList();
			StringBuffer sql = new StringBuffer()
				.append(" update ")
				.append(" 	t_ticket ")
				.append(" set ")
				.append(" 	departure_station =?,terminal_station = ?,departure_time = ?,ticket_number =? ,ticket_state = ?,train_number =?,ticket_price = ? ")
				.append(" where ");
			sql.append(" 	1 = 1 ");	
			
				params.add(ticket.getDeparture_station());
				params.add(ticket.getTerminal_station());
				params.add(ticket.getDeparture_time());
				params.add(ticket.getTicket_number());
				params.add(ticket.getTicket_state());
				params.add(ticket.getTrain_number());
				params.add(ticket.getTicket_price());
			
		if(ticket.getTicket_id()!=null&&!ticket.getTicket_id().equals("")){
			sql.append(" and ticket_id = ? ");	
			params.add(ticket.getTicket_id());
	}
			
						
			temp.update(sql.toString(),params.toArray());
		
		
	}

	@Override
	public List<Ticket> selectTicketForPage(int startIndxe, int offset) {
		String sql = new StringBuffer()
			.append(" select ")
			.append(" 	ticket_id,departure_station,terminal_station,departure_time,ticket_number,ticket_state,train_number,ticket_price ")
			.append(" from ")
			.append(" 	t_ticket ")
			.append(" limit ?,? ")
			.toString();
		return temp.selectAll(new TicketMapper(), sql, startIndxe,offset);
	}

	@Override
	public List<Ticket> selectTicketForPage(String departureStation,
			String terminalStation, String departureTime, String ticketNumber,
			int startIndxe, int offset) {
		List params = new ArrayList();
		StringBuffer sql = new StringBuffer()
			.append(" select ")
			.append(" 	ticket_id,departure_station,terminal_station,departure_time,ticket_number,ticket_state,train_number,ticket_price ")
			.append(" from ")
			.append(" 	t_ticket ")
			.append(" where ")
			.append(" 1 = 1 ")
			.append(" and ticket_state in (1,2,3) ");
			

			if(departureStation!=null&&!departureStation.equals("")){
				sql.append(" and departure_station like ? ");	
				params.add(departureStation+"%");
			}
			if(terminalStation!=null&&!terminalStation.equals("")){
				sql.append(" and terminal_station like ? ");
				params.add(terminalStation+"%");
			}
			if(departureTime!=null&&!departureTime.equals("")){
				sql.append(" and departure_time like ? ");
				params.add(departureTime+"%");
			}
			if(ticketNumber!=null&&!ticketNumber.equals("")){
				sql.append(" and train_number = ? ");	
				params.add(ticketNumber);
			}
			sql.append(" order by departure_time ");
			sql.append(" limit ?,? ")
			.toString();
			params.add(startIndxe);
			params.add(offset);
			
		return temp.selectAll(new TicketMapper(), sql.toString(),params.toArray());
	}

	@Override
	public void updateTicketForRTdata(String changeData,Integer ticketId) {
		List params = new ArrayList();
		StringBuffer sql = new StringBuffer()
		.append(" update ")
		.append(" 	t_ticket ")
		.append(" set ");
		if(changeData.equals("add")){
			sql.append(" ticket_number = ticket_number+1  ");	
		}
		if(changeData.equals("subtract")){
			sql.append(" ticket_number = ticket_number-1  ");	
		}
		sql.append(" where ")
		.append(" 	ticket_id = ? ")
		.toString();
		temp.update(sql.toString(),ticketId);
	}




	

}
