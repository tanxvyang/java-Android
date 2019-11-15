package com.wbj.entity;

import java.sql.Date;



public class Ticket {
	private Integer ticket_id ; 			//车票编号
	private String departure_station;			//起始站
	private String terminal_station;			//终点站
	private String departure_time;			//出发时间
	private Integer ticket_number;			//车票数
	private String ticket_state;			//车票状态 1 待售，2 开售，3 售空
	private String train_number;			//车次
	private Double ticket_price;
	
	
	
	public Ticket() {
		super();
	}

	
	
	



	public Ticket(Integer ticketId, String departureStation,
			String terminalStation, String departureTime, Integer ticketNumber,
			String ticketState, String trainNumber, Double ticketPrice) {
		super();
		ticket_id = ticketId;
		departure_station = departureStation;
		terminal_station = terminalStation;
		departure_time = departureTime;
		ticket_number = ticketNumber;
		ticket_state = ticketState;
		train_number = trainNumber;
		ticket_price = ticketPrice;
	}







	@Override
	public String toString() {
		return "departure_station=" + departure_station
				+ ", departure_time=" + departure_time + ", terminal_station="
				+ terminal_station + ", ticket_id=" + ticket_id
				+ ", ticket_number=" + ticket_number + ", ticket_state="
				+ ticket_state + ", train_number=" + train_number +"\n";
	}
	public Integer getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(Integer ticketId) {
		ticket_id = ticketId;
	}
	public String getDeparture_station() {
		return departure_station;
	}
	public void setDeparture_station(String departureStation) {
		departure_station = departureStation;
	}
	public String getTerminal_station() {
		return terminal_station;
	}
	public void setTerminal_station(String terminalStation) {
		terminal_station = terminalStation;
	}
	
	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departureTime) {
		departure_time = departureTime;
	}

	public Integer getTicket_number() {
		return ticket_number;
	}
	public void setTicket_number(Integer ticketNumber) {
		ticket_number = ticketNumber;
	}
	public String getTicket_state() {
//		车票状态 1 待售，2 开售，3 售空 4删除
		if (ticket_state.equals("1")) {
			return "待售" ;
		}
		if (ticket_state.equals("2")) {
			return "开售" ;
		}
		if (ticket_state.equals("3")) {
			return "售空" ;
		}
		if (ticket_state.equals("待售")) {
			return "1" ;
		}
		if (ticket_state.equals("售空")) {
			return "3" ;
		}
		if (ticket_state.equals("开售")) {
			return "2" ;
		}
		
		
		return ticket_state;
	}
	public void setTicket_state(String ticketState) {
		ticket_state = ticketState;
	}
	public String getTrain_number() {
		return train_number;
	}
	public void setTrain_number(String trainNumber) {
		train_number = trainNumber;
	}
	public void setDeparture_station(java.sql.Date date) {
		// TODO Auto-generated method stub
		
	}
	public void setTicket_price(Double ticket_price) {
		this.ticket_price = ticket_price;
	}
	public Double getTicket_price() {
		return ticket_price;
	}
	
	
	
}
