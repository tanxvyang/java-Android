package com.wbj.ui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.exception.TicketCheckoutException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.TicketService;
import com.wbj.service.UserService;
import com.wbj.util.Pager;
import com.wbj.util.ProjectStaticFinal;

public class ManagerMainFream {
	
	JFrame managerMainFream = null;
	JLabel userNameLabel = null;
	JLabel realNameLabel = null;
	JButton userCenterButton = null;//�û����ģ�
	JLabel departureStationLabel = null;
	JLabel terminalStationLabel = null; ///??????????????????????/
	JLabel departureTimeLabel = null;


	JTextField departureStationField = null;
	JTextField terminalStationField = null;
	JTextField departureTimeField = null;
	JButton searchButton = null;
	JScrollPane jsp = null;
	JTable resultTable = null;
	//��ҳ��ť��ҳ����ʾ
	
	JLabel currentPageLabel = null;	//��ǰҳ��
	JTextField currentPageField = null;
	JLabel totalPageLabel = null;	//��ҳ��
	JTextField totalPageField = null; 
	JLabel separtorLabel = null;	//�ָ���
	JButton prePageButton =null;	//��һҳ
	JButton nextPageButton =null;	//��һҳ
	JButton addButton = null; //���
	JButton deleteButton = null; //ɾ��
	ManagerAddTicketFream managerAddTicketFream = null;
	ManagerUserFream  managerUserFream = null;
	
	
	





	User user = null;//���浱ǰ��¼���û���Ϣ
	TicketService ticketService =null;
	UserService userService = null;
	String prePageNum = null;
	String nextPageNum = null;
	

	public ManagerMainFream(User user){
		this.user = user;
	}
	
	public void init(){
		managerMainFream = new JFrame("��ţ��-����Աҳ��");
		userNameLabel = new JLabel("�û���:" + user.getUsername());
		realNameLabel = new JLabel("����:" + user.getName());
		userCenterButton = new JButton("�û�����");
		departureStationLabel = new JLabel("ʼ��վ��");
		terminalStationLabel = new JLabel("�յ�վ��"); // /??????????????????????/
		departureTimeLabel = new JLabel("����ʱ�䣺");

		departureStationField = new JTextField();
		terminalStationField = new JTextField();
		departureTimeField = new JTextField();
		searchButton = new JButton("��ѯ");
		resultTable = new JTable();
		jsp = new JScrollPane(resultTable);

		currentPageLabel = new JLabel("��ǰ"); // ��ǰҳ��
		currentPageField = new JTextField();
		totalPageLabel = new JLabel("��ҳ��");// ��ҳ��
		totalPageField = new JTextField();
		separtorLabel = new JLabel("/"); // �ָ���
		prePageButton = new JButton("��һҳ"); // ��һҳ
		nextPageButton = new JButton("��һҳ"); // ��һҳ
		addButton = new JButton("���");
		deleteButton = new JButton("ɾ��");
		managerAddTicketFream = new ManagerAddTicketFream();
		managerUserFream = new ManagerUserFream(user);
		ticketService = (TicketService) ObjectFactory
				.getObject("ticketService");
		userService = (UserService) ObjectFactory.getObject("userService");

	}
	public void build(){
		managerMainFream.setSize(600, 650);
		managerMainFream.setLocationRelativeTo(null);
		managerMainFream.setLayout(null);
		managerMainFream.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		int marginLeft =20;
		int marginTop = 90;

		userNameLabel.setBounds(marginLeft, marginTop - 60, 100, 25);
		managerMainFream.add(userNameLabel);

		realNameLabel.setBounds(marginLeft += 150, marginTop - 60, 100, 25);
		managerMainFream.add(realNameLabel);
		userCenterButton.setBounds(marginLeft += 150, marginTop - 70, 90, 50);
		managerMainFream.add(userCenterButton);

		departureStationLabel.setBounds(marginLeft = 20, marginTop, 60, 25);
		managerMainFream.add(departureStationLabel);

		departureStationField.setBounds(marginLeft += 50, marginTop, 90, 25);
		managerMainFream.add(departureStationField);

		terminalStationLabel.setBounds(marginLeft += 100, marginTop, 60, 25);
		managerMainFream.add(terminalStationLabel);

		terminalStationField.setBounds(marginLeft += 50, marginTop, 90, 25);
		managerMainFream.add(terminalStationField);

		departureTimeLabel.setBounds(marginLeft += 100, marginTop, 80, 25);
		managerMainFream.add(departureTimeLabel);

		departureTimeField.setBounds(marginLeft += 65, marginTop, 135, 25);
		departureTimeField.setText(ProjectStaticFinal.INFO_DATE); // ������ʾ��Ϣ
		managerMainFream.add(departureTimeField);

		searchButton.setBounds(marginLeft += 140, marginTop, 60, 25);
		managerMainFream.add(searchButton);

		jsp.setBounds(10, marginTop + 30, 580, 420);
		String[] columnNames = { "���", "����", "ʼ��վ", "�յ�վ", "����ʱ��", "ʣ��Ʊ��",
				"��Ʊ״̬", "Ʊ��" };

		DefaultTableModel dtm = new DefaultTableModel(null, columnNames);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		resultTable.setDefaultRenderer(Object.class, r);
		resultTable.setModel(dtm);

		managerMainFream.add(jsp);


		prePageButton.setBounds(marginLeft=50,marginTop=550,80,25);
		managerMainFream.add(prePageButton);
		currentPageLabel.setBounds(marginLeft+=100,marginTop=550,50,25); 
		managerMainFream.add(currentPageLabel);
		currentPageField.setBounds(marginLeft+=30,marginTop,25,25);
		managerMainFream.add(currentPageField);
		separtorLabel.setBounds(marginLeft+=30,marginTop,10,25);
		managerMainFream.add(separtorLabel);
		totalPageField.setBounds(marginLeft+=10,marginTop,25,25);
		managerMainFream.add(totalPageField);
		totalPageLabel.setBounds(marginLeft+=30,marginTop,50,25);
		managerMainFream.add(totalPageLabel);

		nextPageButton.setBounds(marginLeft+=50,marginTop,80,25);
		managerMainFream.add(nextPageButton);
		
		addButton.setBounds(marginLeft+=100, marginTop, 80, 25);
		managerMainFream.add(addButton);
		deleteButton.setBounds(marginLeft+=100, marginTop, 80, 25);
		managerMainFream.add(deleteButton);
		
	





		managerMainFream.setVisible(true);
	}







	public void addAction(){
		
		
		 ticketService =(TicketService) ObjectFactory.getObject("ticketServiceProxy");
		 
		 
		 
		 departureTimeField.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent arg0) {//ʧȥ����ʱ
					if (departureTimeField.getText().equals("")) {//���û�����룬��ʾ����
						departureTimeField.setText(ProjectStaticFinal.INFO_DATE);
						departureTimeField.setForeground(Color.LIGHT_GRAY);
					}

				}

				@Override
				public void focusGained(FocusEvent arg0) {//��ý���ʱ
					if (departureTimeField.getText().equals(ProjectStaticFinal.INFO_DATE)) {
						departureTimeField.setText("");
						departureTimeField.setForeground(Color.BLACK);
					}
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
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				managerAddTicketFream.start();
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Ticket deleteTicket = null;
				  int row = resultTable.getSelectedRow();
				  try {
				  Object ticketStatevalue = resultTable.getValueAt(row, 6);
	        		String applyState = String.valueOf(ticketStatevalue);
	        		
						
	                if (!(applyState.equals("����"))) {
	                	
	                	Object value = resultTable.getValueAt(row, 0);
	                    Integer deleteTicketId = (Integer) value;
	                    try {
							List<Ticket> ticketList = ticketService.selectTicketByDepartureAndTerminalStation(null, null, null, null, deleteTicketId);
							if (ticketList.size()!=0) {
								deleteTicket = ticketList.get(0);
								 deleteTicket.setTicket_state("ʧЧ");
								ticketService.update(deleteTicket);		
							}
	                    } catch (TicketCheckoutException e1) {
							e1.printStackTrace();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
	                
	                }else {
	                	JOptionPane.showMessageDialog(managerMainFream,"�޷�ɾ�����������ĳ�Ʊ��","ɾ��ʧ��",JOptionPane.INFORMATION_MESSAGE);
					}

	        		}catch (Exception e)  {
	        			JOptionPane.showMessageDialog(managerMainFream,"δѡ��Ʊ���޷�ɾ��","",JOptionPane.INFORMATION_MESSAGE);
						
					}
	                
	                search(currentPageField.getText());
	                
			}
		});
		
		userCenterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				managerUserFream.start();
			}
		});
		

	}





	public void search(String pagenums)  {
		String departureStation = departureStationField.getText();
		String terminalStation = terminalStationField.getText();

		List<Ticket> ticketlist = null;
		Pager<Ticket> pager = null;

		pager = ticketService.selectTicletPageRecordsStation(departureStation,
				terminalStation, null, null, pagenums);
		ticketlist = pager.getData();
		// ��ͷ��λ��
		String[] columnNames = { "���", "����", "ʼ��վ", "�յ�վ", "����ʱ��", "ʣ��Ʊ��",
				"��Ʊ״̬", "Ʊ��" };
		Object[][] data = new Object[ticketlist.size()][columnNames.length];
		for (int i = 0; i < ticketlist.size(); i++) {
			Ticket ticket = ticketlist.get(i);
			if (ticket.getTicket_state().equals("ʧЧ")) {
				continue;
			}
			
			data[i][0] = ticket.getTicket_id();
			data[i][1] = ticket.getTrain_number();
			data[i][2] = ticket.getDeparture_station();
			data[i][3] = ticket.getTerminal_station();
			data[i][4] = ticket.getDeparture_time();
			data[i][5] = ticket.getTicket_number();
			data[i][6] = ticket.getTicket_state();
			data[i][7] = ticket.getTicket_price();

		}
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		resultTable.setModel(dtm);
		currentPageField .setText(pager.getCurrentPageNum().toString());//����ҳ��
		totalPageField .setText(pager.getTotalPage().toString());//������ҳ��
		prePageNum = pager.getPrePageNum().toString(); //��¼��һҳ
		nextPageNum = pager.getNextPageNum().toString();//��¼��һҳ
	}



	public void start(){
		init();
		addAction();
		build();
	}




}
