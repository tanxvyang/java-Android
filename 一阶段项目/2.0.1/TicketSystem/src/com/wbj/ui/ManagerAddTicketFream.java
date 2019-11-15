package com.wbj.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.wbj.entity.Ticket;
import com.wbj.exception.TicketCheckoutException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.TicketService;
import com.wbj.util.ProjectStaticFinal;
import com.wbj.util.StringUtil;

public class ManagerAddTicketFream {
	
	JFrame managerAddTicketFrame = null;
	JLabel departureStationLabel = null;
	JLabel terminalStationLabel = null;
	JLabel departureTimeLabel = null;
	JLabel ticketNumberLabel = null;
	JLabel ticketStateLabel = null; 
	JLabel trainNumberLabel = null;
	JLabel ticketPriceLabel = null;
	
	
	
	JTextField departureStationField = null;
	JTextField terminalStationField = null;
	JTextField departureTimeField = null;
	JTextField ticketNumberField = null;
	JTextField ticketStateField = null;
	JTextField trainNumberField = null;
	JTextField ticketPriceField = null;
	
	JButton saveButton = null;
	JButton cancelButton = null;
	TicketService ticketService =null;
	LoginFream loginFream = null;
	SimpleDateFormat sdf = null;
	
	
	
	

	public void init(){
		managerAddTicketFrame = new JFrame("管理员-添加车票");
		departureStationLabel = new JLabel("起始站：");
		terminalStationLabel = new JLabel("终点站：");
		departureTimeLabel = new JLabel("出发时间:");
		ticketNumberLabel = new JLabel("车票数");
		ticketStateLabel = new JLabel("售卖状态");
		trainNumberLabel = new JLabel("车次:");
		ticketPriceLabel= new JLabel("票价:");
		
		departureStationField = new JTextField();
		terminalStationField = new JTextField();
		departureTimeField = new JTextField();
		ticketNumberField = new JTextField();
		ticketStateField = new JTextField();
		trainNumberField = new JTextField();
		ticketPriceField = new JTextField();
		
		saveButton = new JButton("确认");
		cancelButton = new JButton("取消");
		loginFream =new LoginFream();
		ticketService = (TicketService) ObjectFactory.getObject("ticketServiceProxy");
		sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	}
	public void build(){
		managerAddTicketFrame.setSize(350, 400);
		managerAddTicketFrame.setLocationRelativeTo(null);
		managerAddTicketFrame.setLayout(null);
		managerAddTicketFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		int marginLeftOfLable= 20; 
		int marginLeftOfField= 100; 
		int marginTop=10;
		int width = 20;
		int height = 25;
		
		departureStationLabel.setBounds(marginLeftOfLable, marginTop+=30, width+=80, height);
		managerAddTicketFrame.add(departureStationLabel);
		
		departureStationField.setBounds(marginLeftOfField, marginTop, width+=80, height);
		managerAddTicketFrame.add(departureStationField);
		
		terminalStationLabel.setBounds(marginLeftOfLable, marginTop+=30,  width-=80, height);
		managerAddTicketFrame.add(terminalStationLabel);
		
		terminalStationField.setBounds(marginLeftOfField, marginTop, width+=80, height);
		managerAddTicketFrame.add(terminalStationField);
		
		departureTimeLabel.setBounds(marginLeftOfLable, marginTop+=30, width-=80, height);
		managerAddTicketFrame.add(departureTimeLabel);

		departureTimeField.setBounds(marginLeftOfField, marginTop, width += 80,
				height);
		departureTimeField.setText(ProjectStaticFinal.INFO_DATE); // 设置提示信息
		managerAddTicketFrame.add(departureTimeField);

		ticketNumberLabel.setBounds(marginLeftOfLable, marginTop += 30,
				width -= 80, height);
		managerAddTicketFrame.add(ticketNumberLabel);

		ticketNumberField.setBounds(marginLeftOfField, marginTop, width+=80, height);
		managerAddTicketFrame.add(ticketNumberField);
		
		ticketStateLabel.setBounds(marginLeftOfLable, marginTop+=30, width-=80, height);
		managerAddTicketFrame.add(ticketStateLabel);

		ticketStateField.setBounds(marginLeftOfField, marginTop, width += 80,
				height);
		ticketStateField.setText(ProjectStaticFinal.INFO_TICKET_STATE);// 设置提示信息
		managerAddTicketFrame.add(ticketStateField);

		trainNumberLabel.setBounds(marginLeftOfLable, marginTop += 30,
				width -= 80, height);
		managerAddTicketFrame.add(trainNumberLabel);

		trainNumberField.setBounds(marginLeftOfField, marginTop, width += 80,
				height);
		managerAddTicketFrame.add(trainNumberField);

		ticketPriceLabel.setBounds(marginLeftOfLable, marginTop += 30,
				width -= 80, height);
		managerAddTicketFrame.add(ticketPriceLabel);

		ticketPriceField.setBounds(marginLeftOfField, marginTop, width += 80,
				height);
		ticketPriceField.setText(ProjectStaticFinal.INFO_PRICE);
		managerAddTicketFrame.add(ticketPriceField);

		saveButton.setBounds(70, marginTop += 60, 75, 25);
		managerAddTicketFrame.add(saveButton);

		cancelButton.setBounds(170, marginTop, 75, 25);
		managerAddTicketFrame.add(cancelButton);

		managerAddTicketFrame.setVisible(true);
	}
	public void addAction(){
		
		
	
		departureTimeField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {// 失去焦点时
				if (departureTimeField.getText().equals("")) {// 如果没有输入，提示输入
					departureTimeField.setText(ProjectStaticFinal.INFO_DATE);
					departureTimeField.setForeground(Color.LIGHT_GRAY);
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {// 获得焦点时
				if (departureTimeField.getText().equals(
						ProjectStaticFinal.INFO_DATE)) {
					departureTimeField.setText("");
					departureTimeField.setForeground(Color.BLACK);
				}
			}
		});
		
		
		ticketStateField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {//失去焦点时
				if (ticketStateField.getText().equals("")) {//如果没有输入，提示输入
					ticketStateField.setText(ProjectStaticFinal.INFO_TICKET_STATE);
					ticketStateField.setForeground(Color.LIGHT_GRAY);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {//获得焦点时
				if (ticketStateField.getText().equals(ProjectStaticFinal.INFO_TICKET_STATE)) {
					ticketStateField.setText("");
					ticketStateField.setForeground(Color.BLACK);
				}
			}
		});
		
		ticketPriceField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {//失去焦点时
				if (ticketPriceField.getText().equals("")) {//如果没有输入，提示输入
					ticketPriceField.setText(ProjectStaticFinal.INFO_PRICE);
					ticketPriceField.setForeground(Color.LIGHT_GRAY);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {//获得焦点时
				if (ticketPriceField.getText().equals(ProjectStaticFinal.INFO_PRICE)) {
					ticketPriceField.setText("");
					ticketPriceField.setForeground(Color.BLACK);
				}
			}
		});
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> errorMessages = new ArrayList<String>();
				
				String departureStation = departureStationField.getText();
				if(StringUtil.checkString(departureStation)){
					errorMessages.add( "始发站不可为空");
				}
				String terminalStation = terminalStationField.getText();
				if(StringUtil.checkString(terminalStation)){
					errorMessages.add( "终点站不可为空");
				}
				String departureTime = departureTimeField.getText();
				if (StringUtil.checkString(departureTime)) {
					errorMessages.add( "出发时间不能为空");
				}
				if (StringUtil.cheickDate(departureTime)) {
					errorMessages.add( "出发时间格式不正确");
				}
				
				if (departureStation.equals(terminalStation)) {
					errorMessages.add( "始发和终点站不能相同");
				}
				
				String ticketState = ticketStateField.getText();
				if (StringUtil.checkString(ticketState)) {
					errorMessages.add("售卖状态不可为空，“待售，开售，售空");
				}

				String trainNumber = trainNumberField.getText();
				if (StringUtil.checkString(trainNumber)) {
					errorMessages.add("车次不可为空");
				}

				String ticketNumber = ticketNumberField.getText();
				if (StringUtil.checkString(ticketNumber)) {
					errorMessages.add("车票数不能为空");
				}

				String ticketPrice = ticketPriceField.getText();
				if (StringUtil.checkString(ticketPrice)) {
					errorMessages.add("票价不能为空");
				} else if (Double.valueOf(ticketPrice) < 0) {
					errorMessages.add("票价不能小于0 例：88.8 ");
				}
				else if (!(StringUtil.cheickMoney(ticketPrice))) {
					errorMessages.add("票价格式不正确 ，例：88.88");
					
				}
				if(errorMessages.size() != 0){
					StringBuffer sb = new StringBuffer();
					for (String string : errorMessages) {
						sb.append(string).append("\n");
					}
					JOptionPane.showMessageDialog(managerAddTicketFrame, sb.toString(), "添加失败", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Ticket ticket = new Ticket();
				ticket.setDeparture_station(departureStationField.getText());
				ticket.setTerminal_station(terminalStationField.getText());
				ticket.setDeparture_time(departureTimeField.getText());
				ticket.setTicket_number(Integer.valueOf(ticketNumberField
						.getText()));
				ticket.setTicket_state(ticketStateField.getText());
				ticket.setTrain_number(trainNumberField.getText());
				ticket.setTicket_price(Double.valueOf(ticketPriceField
						.getText()));

				try {
					ticketService.insertTicket(ticket);

				} catch (TicketCheckoutException e) {
					e.printStackTrace();
				}

				managerAddTicketFrame.setVisible(false);

			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				managerAddTicketFrame.setVisible(false);
			}
		});
	}
	
	public void start(){
		init();
		build();
		addAction();
	}
	




}
