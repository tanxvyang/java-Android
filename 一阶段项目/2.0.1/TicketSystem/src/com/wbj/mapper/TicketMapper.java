package com.wbj.mapper;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.wbj.entity.Ticket;

public class TicketMapper implements RowMapper<Ticket>{

	@Override
	public Ticket mapperObject(ResultSet rs) throws Exception {
		Ticket ticket = new Ticket();
		ticket.setTicket_id(rs.getInt("ticket_id"));
		ticket.setDeparture_station(rs.getString("departure_station"));
		ticket.setTerminal_station(rs.getString("terminal_station"));
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
//		ticket.setBuyTime(sdf.format(new java.util.Date()));
		
		ticket.setDeparture_time(rs.getString("departure_time"));  //¿ÉÄÜ³ö´í
		ticket.setTicket_number(rs.getInt("ticket_number"));
		ticket.setTicket_state(rs.getString("ticket_state"));
		ticket.setTrain_number(rs.getString("train_number"));
		ticket.setTicket_price(rs.getDouble("ticket_price"));
		return ticket;
	}

}
