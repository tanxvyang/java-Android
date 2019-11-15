package com.wbj.ui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.exception.NullChooseException;
import com.wbj.exception.TicketCheckoutException;
import com.wbj.exception.buyTicketException;
import com.wbj.exception.updataException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.TicketService;
import com.wbj.service.UserService;
import com.wbj.util.Pager;
import com.wbj.util.ProjectStaticFinal;

public class UserMainFream {
	
	JFrame userMainFream = null;
	JLabel userNameLabel = null;
	JLabel realNameLabel = null;
	JButton userCenterButton = null;
	JLabel departureStationLabel = null;
	JLabel terminalStationLabel = null; // /??????????????????????/
	JLabel departureTimeLabel = null;

	JTextField departureStationField = null;
	JTextField terminalStationField = null;
	JTextField departureTimeField = null;
	JButton searchButton = null;
	JScrollPane jsp = null;
	JTable resultTable = null;
	// 分页按钮和页数显示
	JLabel currentPageLabel = null;// 当前页码
	JTextField currentPageField = null;
	JLabel totalPageLabel = null; // 总页数
	JTextField totalPageField = null;
	JLabel separtorLabel = null; // 分隔符
	JButton prePageButton = null; // 上一页
	JButton nextPageButton = null; // 下一页
	JButton buyButton = null; // 购买
	buyTicketFream buyTicketFream = null;

	User user = null;// 保存当前登录的用户信息
	TicketService ticketService = null;
	UserService userService = null;
	String prePageNum = null;
	String nextPageNum = null;

	public UserMainFream(User user){
		this.user = user;
	}
	
	public void init(){
		userMainFream = new JFrame("黄牛网-用户页面");
		userNameLabel = new JLabel("用户名:" + user.getUsername());
		realNameLabel = new JLabel("姓名:" + user.getName());
		userCenterButton = new JButton("个人中心");
		departureStationLabel = new JLabel("始发站：");
		terminalStationLabel = new JLabel("终点站："); // /??????????????????????/
		departureTimeLabel = new JLabel("出发时间：");

		departureStationField = new JTextField();
		terminalStationField = new JTextField();
		departureTimeField = new JTextField();
		searchButton = new JButton("查询");
		resultTable = new JTable();
		jsp = new JScrollPane(resultTable);

		currentPageLabel = new JLabel("当前"); // 当前页码
		currentPageField = new JTextField();
		totalPageLabel = new JLabel("总页数");// 总页数
		totalPageField = new JTextField();
		separtorLabel = new JLabel("/"); // 分隔符
		prePageButton = new JButton("上一页"); // 上一页
		nextPageButton = new JButton("下一页"); // 下一页
		buyButton = new JButton("购买");
		ticketService = (TicketService) ObjectFactory
				.getObject("ticketServiceProxy");
		userService = (UserService) ObjectFactory.getObject("userServiceProxy");
	}
	public void build(){
		userMainFream.setSize(800, 650);
		userMainFream.setLocationRelativeTo(null);
		userMainFream.setLayout(null);
		userMainFream.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		int marginLeft =20;
		int marginTop = 90;

		userNameLabel.setBounds(marginLeft+=50, marginTop-60, 100, 25);
		userMainFream.add(userNameLabel);


		realNameLabel.setBounds(marginLeft+=150, marginTop-60, 100, 25);
		userMainFream.add(realNameLabel);
		
		 userCenterButton.setBounds(marginLeft+=400, marginTop-70, 90, 50);
		 userMainFream.add(userCenterButton);

		departureStationLabel.setBounds(marginLeft=20, marginTop, 60, 25);
		userMainFream.add(departureStationLabel);

		departureStationField.setBounds(marginLeft+=50, marginTop, 90, 25);
		userMainFream.add(departureStationField);

		terminalStationLabel.setBounds(marginLeft+=100, marginTop, 60, 25);
		userMainFream.add(terminalStationLabel);
		
		terminalStationField.setBounds(marginLeft+=50, marginTop, 90, 25);
		userMainFream.add(terminalStationField);
		
		departureTimeLabel.setBounds(marginLeft+=100, marginTop, 80, 25);
		userMainFream.add(departureTimeLabel);
		
		departureTimeField.setBounds(marginLeft+=80, marginTop,140, 25);
		departureTimeField.setText(ProjectStaticFinal.INFO_DATE);	//设置提示信息
		userMainFream.add(departureTimeField);
		
		searchButton.setBounds(marginLeft+=180, marginTop, 60, 25);
		userMainFream.add(searchButton);
		
		jsp.setBounds(10,marginTop+30, 770, 420);
		String[] columnNames = {"编号","车次","始发站","终点站","出发时间","剩余票数","车票状态","票价"};

		DefaultTableModel dtm = new DefaultTableModel(null, columnNames);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		resultTable.setDefaultRenderer(Object.class, r);
		resultTable.setModel(dtm);
		userMainFream.add(jsp);


		prePageButton.setBounds(marginLeft=140,marginTop=560,80,25);
		userMainFream.add(prePageButton);
		currentPageLabel.setBounds(marginLeft+=100,marginTop,50,25); 
		userMainFream.add(currentPageLabel);
		currentPageField.setBounds(marginLeft+=30,marginTop,25,25);
		userMainFream.add(currentPageField);
		separtorLabel.setBounds(marginLeft+=30,marginTop,10,25);
		userMainFream.add(separtorLabel);
		totalPageField.setBounds(marginLeft+=10,marginTop,25,25);
		userMainFream.add(totalPageField);
		totalPageLabel.setBounds(marginLeft+=30,marginTop,50,25);
		userMainFream.add(totalPageLabel);

		nextPageButton.setBounds(marginLeft+=50,marginTop,80,25);
		userMainFream.add(nextPageButton);
		
		buyButton.setBounds(marginLeft+=100, marginTop, 80, 25);
		userMainFream.add(buyButton);


		userMainFream.setVisible(true);
	}







	public void addAction(){

		departureTimeField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {//失去焦点时
				if (departureTimeField.getText().equals("")) {//如果没有输入，提示输入
					departureTimeField.setText(ProjectStaticFinal.INFO_DATE);
					departureTimeField.setForeground(Color.LIGHT_GRAY);
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {//获得焦点时
				if (departureTimeField.getText().equals(ProjectStaticFinal.INFO_DATE)) {
					departureTimeField.setText("");
					departureTimeField.setForeground(Color.BLACK);
				}
			}
		});





		ticketService =(TicketService) ObjectFactory.getObject("ticketServiceProxy");
		
		
	 	userCenterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 user = userService.refresh(user);
				 
				new UserCenterFream(user).start();
			}
		});
	 
	 
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				search("1");
			}
		});

		prePageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				search(prePageNum);
			}
		});
		nextPageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				search(nextPageNum);

			}
		});
		
		
		
		buyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Ticket ticket = new Ticket();
				try {
					int[] rows = resultTable.getSelectedRows();// 返回所选定的所有行数，去判断是否多选
					if (rows.length > 1) {
						JOptionPane.showMessageDialog(userMainFream,
								"选择过多，默认购买所选择的第一张车票", "购买提示",
								JOptionPane.ERROR_MESSAGE);
					}
					int row = resultTable.getSelectedRow();
					int col = 0;
					int timeCol = 4;
					Object value = resultTable.getValueAt(row, col);
					Integer ticketId = (Integer) value;
					Object timevalue = resultTable.getValueAt(row, timeCol);
					String time = (String) timevalue;
					ticket.setTicket_id(ticketId);
					ticket.setDeparture_time(time);
// 获得用户购票记录表
					Record record = userService.buyTicket(user, ticket);
					if (record != null) {
						new buyTicketFream(user, ticket, record).start();
					}
					
					if (currentPageField.getText() != null) {
						search(currentPageField.getText());
					} else {
						search("1");
					}
				} catch (buyTicketException e) {
					JOptionPane.showMessageDialog(userMainFream,
							e.getMessage(), "购票失败", JOptionPane.ERROR_MESSAGE);

				} catch (TicketCheckoutException e) {
					JOptionPane.showMessageDialog(userMainFream,
							e.getMessage(), "购票失败", JOptionPane.ERROR_MESSAGE);

				} catch (NullChooseException e) {
					JOptionPane.showMessageDialog(userMainFream,
							e.getMessage(), "未选择车票", JOptionPane.ERROR_MESSAGE);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(userMainFream, "未选择车票",
							"购票失败", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

	@SuppressWarnings("unchecked")
	public void search(String pagenums)  {
		String departureStation = departureStationField.getText();
		String terminalStation = terminalStationField.getText();
		String departureTime = departureTimeField.getText();
		
		
		
		List<Ticket> ticketlist = null;
		Pager<Ticket> pager = null;
		if (departureTime.equals(ProjectStaticFinal.INFO_DATE)) {
			departureTime=null;
		}
			pager = ticketService.selectTicletPageRecordsStation(departureStation, terminalStation,departureTime , null, pagenums);
			ticketlist = pager.getData();
			String[] columnNames = {"编号","车次","始发站","终点站","出发时间","剩余票数","车票状态","票价"};
		Object[][] data = new Object[ticketlist.size()][columnNames.length];
		for (int i = 0; i < ticketlist.size(); i++) {
			Ticket ticket = ticketlist.get(i);
			data[i][0] = ticket.getTicket_id();
			data[i][1] = ticket.getTrain_number();
			data[i][2] = ticket.getDeparture_station();
			data[i][3] = ticket.getTerminal_station();
			data[i][4] = ticket.getDeparture_time();
			data[i][5] = ticket.getTicket_number();
			data[i][6] = ticket.getTicket_state();
			data[i][7] = ticket.getTicket_price();

		}
		
		//设置单元格不可修改
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		resultTable.setModel(dtm);
		currentPageField .setText(pager.getCurrentPageNum().toString());
		totalPageField .setText(pager.getTotalPage().toString());
		prePageNum = pager.getPrePageNum().toString(); 
		nextPageNum = pager.getNextPageNum().toString();
	}



	public void start(){
		init();
	addAction();
		build();
	}
}
