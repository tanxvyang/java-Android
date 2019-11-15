package com.wbj.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.wbj.entity.Recharge;
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
import com.wbj.util.Pager;
import com.wbj.util.StringUtil;

public class UserCenterFream {

	JFrame userCenterFream = null;
	JLabel userNameLabel = null;
	JLabel realNameLabel = null;
	JButton userCenterButton = null;
	JButton searchButton = null;
	JButton deleteButton = null;

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
	JButton refundTicketButton = null; // 退票

	buyTicketFream buyTicketFream = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	User user = null;// 保存当前登录的用户信息
	TicketService ticketService = null;
	UserService userService = null;
	String prePageNum = null;
	String nextPageNum = null;

	public UserCenterFream(User user) {
		this.user = user;
	}

	public void init(){
		userCenterFream = new JFrame("黄牛网-个人中心");
		 userNameLabel = new JLabel("用户名:"+user.getUsername());
		 realNameLabel =new JLabel("姓名:"+user.getName());
		 userCenterButton = new JButton("余额："+user.getBalance()+"￥  充值 ");
//		
		searchButton = new JButton("查询");
		deleteButton = new JButton("删除");
		resultTable = new JTable();
		jsp = new JScrollPane(resultTable);

		currentPageLabel = new JLabel("当前"); // 当前页码
		currentPageField = new JTextField();
		totalPageLabel = new JLabel("总页数");// 总页数
		totalPageField = new JTextField();
		separtorLabel = new JLabel("/"); // 分隔符
		prePageButton = new JButton("上一页"); // 上一页
		nextPageButton = new JButton("下一页"); // 下一页
		buyButton = new JButton("付款");
		refundTicketButton = new JButton("退票");
		ticketService = (TicketService) ObjectFactory
				.getObject("ticketServiceProxy");
		userService = (UserService) ObjectFactory.getObject("userServiceProxy");
	}
	public void build(){
		userCenterFream.setSize(650, 650);
		userCenterFream.setLocationRelativeTo(null);
		userCenterFream.setLayout(null);
		userCenterFream.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		int marginLeft =30;
		int marginTop = 90;

		userNameLabel.setBounds(marginLeft+=20, marginTop-60, 100, 25);
		userCenterFream.add(userNameLabel);


		realNameLabel.setBounds(marginLeft+=150, marginTop-60, 100, 25);
		userCenterFream.add(realNameLabel);
		 userCenterButton.setBounds(marginLeft+=150, marginTop-70, 200, 50);
		 userCenterFream.add(userCenterButton);

		searchButton.setBounds(marginLeft+=120, marginTop, 60, 25);
		userCenterFream.add(searchButton);
		deleteButton.setBounds(marginLeft+=70, marginTop, 60, 25);
		userCenterFream.add(deleteButton);
		
		jsp.setBounds(25,marginTop+30, 580, 420);
		String[] columnNames = {"编号","车次","购买时间","购买状态"};

		DefaultTableModel dtm = new DefaultTableModel(null, columnNames);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		resultTable.setDefaultRenderer(Object.class, r);
		resultTable.setModel(dtm);
		userCenterFream.add(jsp);


		prePageButton.setBounds(marginLeft=50,marginTop=550,80,25);
		userCenterFream.add(prePageButton);
		currentPageLabel.setBounds(marginLeft+=100,marginTop=550,50,25); 
		userCenterFream.add(currentPageLabel);
		currentPageField.setBounds(marginLeft+=30,marginTop,25,25);
		userCenterFream.add(currentPageField);
		separtorLabel.setBounds(marginLeft+=30,marginTop,10,25);
		userCenterFream.add(separtorLabel);
		totalPageField.setBounds(marginLeft+=10,marginTop,25,25);
		userCenterFream.add(totalPageField);
		totalPageLabel.setBounds(marginLeft+=30,marginTop,50,25);
		userCenterFream.add(totalPageLabel);

		nextPageButton.setBounds(marginLeft+=50,marginTop,80,25);
		userCenterFream.add(nextPageButton);
		
		buyButton.setBounds(marginLeft+=100, marginTop, 80, 25);
		userCenterFream.add(buyButton);
		refundTicketButton.setBounds(marginLeft+=100, marginTop, 80, 25);
		userCenterFream.add(refundTicketButton);

	

		userCenterFream.setVisible(true);
	}



	public void addAction(){
	 ticketService =(TicketService) ObjectFactory.getObject("ticketServiceProxy");
		/**
		 * @time 11-05 23:50
		 */
		userCenterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Recharge recharge = new Recharge();

				try {
					String inputValue = JOptionPane.showInputDialog("请输入充值金额!");
					Double money = Double.valueOf(inputValue);
					if (!(StringUtil.checkString(inputValue)) && (money > 0)) {
						recharge.setApplyMoney(money);
						recharge.setApplyTime(sdf.format(new Date()));
						recharge.setUserId(user.getId());
						recharge.setApplyState("未处理");
						recharge.setUsername(user.getUsername());
						userService.addRecharge(recharge);

					} else {
						JOptionPane.showMessageDialog(userCenterFream,
								"充值金额格式错误,不可为空要大于零，且符合格式 例：88.88", "金额错误",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(userCenterFream,
							"未输入金额，充值取消", "金额错误", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		/**
 *
 */

		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				search("1");
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int[] rows = resultTable.getSelectedRows();// 返回所选定的所有行数，去判断是否多选
				if (rows.length > 1) {
					JOptionPane.showMessageDialog(userCenterFream,
							"选择过多，默认删除第一条", "删除", JOptionPane.ERROR_MESSAGE);
				}

				int row = resultTable.getSelectedRow();
				int col = 0;
				try {

					Object value = resultTable.getValueAt(row, col);
					Integer recordId = (Integer) value;
					userService.deleteRrecord(recordId);
					search(currentPageField.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(userCenterFream, "未选择要删除的内容",
							"无法删除", JOptionPane.ERROR_MESSAGE);
				}
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
		
		//退票
		refundTicketButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Record record= null;
				Ticket ticket=null;
				List<Ticket> ticketList =	null;
				try {
				int[] rows = resultTable.getSelectedRows();//返回所选定的所有行数，去判断是否多选
				if(rows.length > 1){
					JOptionPane.showMessageDialog(userCenterFream,"选择过多，默认选择第一条","退票提示",JOptionPane.ERROR_MESSAGE);
				}

				int row = resultTable.getSelectedRow();
				int col = 0;
			
				Object value = resultTable.getValueAt(row, col);
				Integer recordId = (Integer) value;
				int colState = 3;
				Object valueState = resultTable.getValueAt(row, colState);
				String  buyState = (String)valueState;
			if (buyState.equals("未付款")) {
				ticketService.refundTicketForRTdata(recordId);
			}else if (!buyState.equals("已退票")) {
				
				
				try {
					user = ticketService.refundTicket(user,recordId);
				} catch (RefundTicketException e) {
					JOptionPane.showMessageDialog(userCenterFream,e.getMessage(),"退票失败",JOptionPane.ERROR_MESSAGE);

				} catch (TicketCheckoutException e) {
					JOptionPane.showMessageDialog(userCenterFream,e.getMessage(),"退票失败",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}else {
				JOptionPane.showMessageDialog(userCenterFream,"票已退，无法重复退票","退票失败",JOptionPane.ERROR_MESSAGE);
			}
			user = userService.refresh(user);
			userCenterButton.setText("余额："+user.getBalance()+"￥  充值 ");
			search(currentPageField.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(userCenterFream,"未选择，无法退票","未选择",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		
		
		
		/**
		 * 付款
		 */
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Record record = null;
				Ticket ticket = null;
				List<Ticket> ticketList = null;
				int[] rows = resultTable.getSelectedRows();// 返回所选定的所有行数，去判断是否多选
				if (rows.length > 1) {
					JOptionPane.showMessageDialog(userCenterFream,
							"选择过多，默认选择第一条", "付款提示", JOptionPane.ERROR_MESSAGE);
				}
				int row = resultTable.getSelectedRow();
				int col = 0;
				try {

					Object value = resultTable.getValueAt(row, col);
					Integer recordId = (Integer) value;
					int colState = 3;
					Object valueState = resultTable.getValueAt(row, colState);
					String buyState = (String) valueState;

					if (buyState.equals("未付款")) {
						record = userService.selectRecordById(recordId);

						if (record != null) {

							try {
								ticketList = ticketService
										.selectTicketByDepartureAndTerminalStation(
												null, null, null, null,
												userService.selectRecordById(
														recordId).getTicketId());
							} catch (TicketCheckoutException e) {
								e.printStackTrace();
							} catch (Exception e) {
								e.printStackTrace();
							}
							if (ticketList.size() != 0) {
								ticket = ticketList.get(0);

								if (user.getBalance() >= ticket
										.getTicket_price()) {
									user.setBalance(user.getBalance()
											- ticket.getTicket_price());
									//						
									// //修改用户余额（扣款）

									userService.updateUserBalance(user);
									// //向当前购票记录里加入用户id,修改购票状态
									record.setBuyState("已购买");// 2.表示已付款
									// //添加向数据库中添加记录
									userService.updateRecord(record);

									if (currentPageField.getText() != null) {

										search(currentPageField.getText());
									} else {
										search("1");
									}

									userCenterButton.setText("余额："
											+ user.getBalance() + "￥  充值 ");
								} else {

									JOptionPane.showMessageDialog(
											userCenterFream, "无法付款，账户余额不足",
											"付款失败", JOptionPane.ERROR_MESSAGE);
								}
							}

						}

					} else {
						if (buyState.equals("已退票")) {

							JOptionPane.showMessageDialog(userCenterFream,
									"该车票已退票，无法付款", "付款失败",
									JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(userCenterFream,
									"该车票已付款，无法重复付款", "付款失败",
									JOptionPane.ERROR_MESSAGE);

						}

					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(userCenterFream, "未选择，无法付款",
							"未选择", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
	}
		


	@SuppressWarnings("unchecked")
	public void search(String pagenums) {
		List<Record> recordList = null;
		Pager<Record> pager = null;
		Integer userId = user.getId();
		pager = userService.selectUserPageRecords(userId, pagenums);
		recordList = pager.getData();
		String[] columnNames = { "编号", "车次", "购买时间", "购买状态" };
		Object[][] data = new Object[recordList.size()][columnNames.length];
		for (int i = 0; i < recordList.size(); i++) {
			Record record = recordList.get(i);
			data[i][0] = record.getRecordId();
			data[i][1] = record.getTrainNumber();
			data[i][2] = record.getBuyTime();
			data[i][3] = record.getBuyState();

		}
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
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
