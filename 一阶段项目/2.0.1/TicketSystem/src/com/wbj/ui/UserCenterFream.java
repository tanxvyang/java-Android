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
	// ��ҳ��ť��ҳ����ʾ
	JLabel currentPageLabel = null;// ��ǰҳ��
	JTextField currentPageField = null;
	JLabel totalPageLabel = null; // ��ҳ��
	JTextField totalPageField = null;
	JLabel separtorLabel = null; // �ָ���
	JButton prePageButton = null; // ��һҳ
	JButton nextPageButton = null; // ��һҳ
	JButton buyButton = null; // ����
	JButton refundTicketButton = null; // ��Ʊ

	buyTicketFream buyTicketFream = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	User user = null;// ���浱ǰ��¼���û���Ϣ
	TicketService ticketService = null;
	UserService userService = null;
	String prePageNum = null;
	String nextPageNum = null;

	public UserCenterFream(User user) {
		this.user = user;
	}

	public void init(){
		userCenterFream = new JFrame("��ţ��-��������");
		 userNameLabel = new JLabel("�û���:"+user.getUsername());
		 realNameLabel =new JLabel("����:"+user.getName());
		 userCenterButton = new JButton("��"+user.getBalance()+"��  ��ֵ ");
//		
		searchButton = new JButton("��ѯ");
		deleteButton = new JButton("ɾ��");
		resultTable = new JTable();
		jsp = new JScrollPane(resultTable);

		currentPageLabel = new JLabel("��ǰ"); // ��ǰҳ��
		currentPageField = new JTextField();
		totalPageLabel = new JLabel("��ҳ��");// ��ҳ��
		totalPageField = new JTextField();
		separtorLabel = new JLabel("/"); // �ָ���
		prePageButton = new JButton("��һҳ"); // ��һҳ
		nextPageButton = new JButton("��һҳ"); // ��һҳ
		buyButton = new JButton("����");
		refundTicketButton = new JButton("��Ʊ");
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
		String[] columnNames = {"���","����","����ʱ��","����״̬"};

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
					String inputValue = JOptionPane.showInputDialog("�������ֵ���!");
					Double money = Double.valueOf(inputValue);
					if (!(StringUtil.checkString(inputValue)) && (money > 0)) {
						recharge.setApplyMoney(money);
						recharge.setApplyTime(sdf.format(new Date()));
						recharge.setUserId(user.getId());
						recharge.setApplyState("δ����");
						recharge.setUsername(user.getUsername());
						userService.addRecharge(recharge);

					} else {
						JOptionPane.showMessageDialog(userCenterFream,
								"��ֵ����ʽ����,����Ϊ��Ҫ�����㣬�ҷ��ϸ�ʽ ����88.88", "������",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(userCenterFream,
							"δ�������ֵȡ��", "������", JOptionPane.ERROR_MESSAGE);
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

				int[] rows = resultTable.getSelectedRows();// ������ѡ��������������ȥ�ж��Ƿ��ѡ
				if (rows.length > 1) {
					JOptionPane.showMessageDialog(userCenterFream,
							"ѡ����࣬Ĭ��ɾ����һ��", "ɾ��", JOptionPane.ERROR_MESSAGE);
				}

				int row = resultTable.getSelectedRow();
				int col = 0;
				try {

					Object value = resultTable.getValueAt(row, col);
					Integer recordId = (Integer) value;
					userService.deleteRrecord(recordId);
					search(currentPageField.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(userCenterFream, "δѡ��Ҫɾ��������",
							"�޷�ɾ��", JOptionPane.ERROR_MESSAGE);
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
		
		//��Ʊ
		refundTicketButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Record record= null;
				Ticket ticket=null;
				List<Ticket> ticketList =	null;
				try {
				int[] rows = resultTable.getSelectedRows();//������ѡ��������������ȥ�ж��Ƿ��ѡ
				if(rows.length > 1){
					JOptionPane.showMessageDialog(userCenterFream,"ѡ����࣬Ĭ��ѡ���һ��","��Ʊ��ʾ",JOptionPane.ERROR_MESSAGE);
				}

				int row = resultTable.getSelectedRow();
				int col = 0;
			
				Object value = resultTable.getValueAt(row, col);
				Integer recordId = (Integer) value;
				int colState = 3;
				Object valueState = resultTable.getValueAt(row, colState);
				String  buyState = (String)valueState;
			if (buyState.equals("δ����")) {
				ticketService.refundTicketForRTdata(recordId);
			}else if (!buyState.equals("����Ʊ")) {
				
				
				try {
					user = ticketService.refundTicket(user,recordId);
				} catch (RefundTicketException e) {
					JOptionPane.showMessageDialog(userCenterFream,e.getMessage(),"��Ʊʧ��",JOptionPane.ERROR_MESSAGE);

				} catch (TicketCheckoutException e) {
					JOptionPane.showMessageDialog(userCenterFream,e.getMessage(),"��Ʊʧ��",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}else {
				JOptionPane.showMessageDialog(userCenterFream,"Ʊ���ˣ��޷��ظ���Ʊ","��Ʊʧ��",JOptionPane.ERROR_MESSAGE);
			}
			user = userService.refresh(user);
			userCenterButton.setText("��"+user.getBalance()+"��  ��ֵ ");
			search(currentPageField.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(userCenterFream,"δѡ���޷���Ʊ","δѡ��",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		
		
		
		/**
		 * ����
		 */
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Record record = null;
				Ticket ticket = null;
				List<Ticket> ticketList = null;
				int[] rows = resultTable.getSelectedRows();// ������ѡ��������������ȥ�ж��Ƿ��ѡ
				if (rows.length > 1) {
					JOptionPane.showMessageDialog(userCenterFream,
							"ѡ����࣬Ĭ��ѡ���һ��", "������ʾ", JOptionPane.ERROR_MESSAGE);
				}
				int row = resultTable.getSelectedRow();
				int col = 0;
				try {

					Object value = resultTable.getValueAt(row, col);
					Integer recordId = (Integer) value;
					int colState = 3;
					Object valueState = resultTable.getValueAt(row, colState);
					String buyState = (String) valueState;

					if (buyState.equals("δ����")) {
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
									// //�޸��û����ۿ

									userService.updateUserBalance(user);
									// //��ǰ��Ʊ��¼������û�id,�޸Ĺ�Ʊ״̬
									record.setBuyState("�ѹ���");// 2.��ʾ�Ѹ���
									// //��������ݿ�����Ӽ�¼
									userService.updateRecord(record);

									if (currentPageField.getText() != null) {

										search(currentPageField.getText());
									} else {
										search("1");
									}

									userCenterButton.setText("��"
											+ user.getBalance() + "��  ��ֵ ");
								} else {

									JOptionPane.showMessageDialog(
											userCenterFream, "�޷�����˻�����",
											"����ʧ��", JOptionPane.ERROR_MESSAGE);
								}
							}

						}

					} else {
						if (buyState.equals("����Ʊ")) {

							JOptionPane.showMessageDialog(userCenterFream,
									"�ó�Ʊ����Ʊ���޷�����", "����ʧ��",
									JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(userCenterFream,
									"�ó�Ʊ�Ѹ���޷��ظ�����", "����ʧ��",
									JOptionPane.ERROR_MESSAGE);

						}

					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(userCenterFream, "δѡ���޷�����",
							"δѡ��", JOptionPane.ERROR_MESSAGE);
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
		String[] columnNames = { "���", "����", "����ʱ��", "����״̬" };
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
