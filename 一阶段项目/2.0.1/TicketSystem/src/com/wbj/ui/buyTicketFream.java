package com.wbj.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.exception.LoginFailException;
import com.wbj.exception.RegisterFailException;
import com.wbj.exception.TicketCheckoutException;
import com.wbj.exception.buyTicketException;
import com.wbj.exception.updataException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.TicketService;
import com.wbj.service.UserService;
import com.wbj.util.StringUtil;

public class buyTicketFream {
	User user =null;
	Ticket ticket =null;
	Record record =null;
	JFrame buyTicketFream = null;
	JLabel	usernameLabel = null;
	JLabel nameLabel = null;
	JLabel id_numberLabel = null;
	JLabel trainNumberLabel = null;
	JLabel departureTimeLabel = null;
	JTextField usernameField = null;
	JTextField nameField = null;
	JTextField idNumberField = null;
	JTextField trainNumberField = null;
	JTextField departureTimeField = null;
	JButton saveButton = null;
	JButton cancelButton = null;
	UserMainFream UserMainFream = null;
	
	UserService userService = null;
	TicketService ticketService =null;
	
	
	public void init(){
		buyTicketFream = new JFrame("��ţ��-��Ʊȷ��");
		usernameLabel = new JLabel("�û�����");
		nameLabel     = new JLabel("��  ����");
		id_numberLabel = new JLabel("���֤��:");
		trainNumberLabel =new JLabel("���Σ�");
		departureTimeLabel = new JLabel("����ʱ�䣺");
		usernameField = new JTextField();
		nameField = new JTextField();
		idNumberField = new JTextField();
		trainNumberField = new JTextField();
		departureTimeField = new JTextField();
		
		saveButton = new JButton("ȷ��");
		cancelButton = new JButton("ȡ��");
		
	   userService = (UserService) ObjectFactory.getObject("userServiceProxy");
	   ticketService =(TicketService) ObjectFactory.getObject("ticketServiceProxy");
		
		
	}
	
	public buyTicketFream(User user, Ticket ticket, Record record) {
		super();
		this.user = user;
		this.ticket = ticket;
		this.record = record;
	}

	public void build(){
		buyTicketFream.setSize(300, 300);
		buyTicketFream.setLocation(550, 250);
		buyTicketFream.setLayout(null);
		int marginLeftForLable= 20; 
		int marginLeftForField= 100; 
		int marginTop=0;
		int width = 0;
		int height = 0;
		
		usernameLabel.setBounds(marginLeftForLable, marginTop+=10, width+=60, height+=25);
		buyTicketFream.add(usernameLabel);
		
		usernameField.setBounds(marginLeftForField, marginTop, width+=80, height);
		usernameField.setText(user.getUsername());
		usernameField.setEditable(false);
		buyTicketFream.add(usernameField);
		
		
		nameLabel.setBounds(marginLeftForLable, marginTop+=30,  width-=80, height);
		buyTicketFream.add(nameLabel);
		
		nameField.setBounds(marginLeftForField, marginTop, width+=80, height);
		nameField.setText(user.getName());
		nameField.setEditable(false);
		buyTicketFream.add(nameField);
		
		id_numberLabel.setBounds(marginLeftForLable, marginTop+=30, width-=80, height);
		buyTicketFream.add(id_numberLabel);
		
		idNumberField.setBounds(marginLeftForField, marginTop, width+=80, height);
		idNumberField.setText(user.getId_number());
		idNumberField.setEditable(false);
		buyTicketFream.add(idNumberField);
		//-------
		trainNumberLabel.setBounds(marginLeftForLable, marginTop+=30, width-=80, height);
		buyTicketFream.add(trainNumberLabel);
		
		trainNumberField.setBounds(marginLeftForField, marginTop, width+=80, height);
		trainNumberField.setText(record.getTrainNumber());
		trainNumberField.setEditable(false);
		buyTicketFream.add(trainNumberField);
		
		departureTimeLabel.setBounds(marginLeftForLable, marginTop+=30, width-=60, height);
		buyTicketFream.add(departureTimeLabel);
		
		departureTimeField.setBounds(marginLeftForField, marginTop, width+=60, height);
		departureTimeField.setText(ticket.getDeparture_time());
		departureTimeField.setEditable(false);
		buyTicketFream.add(departureTimeField);
		
		saveButton.setBounds(70, marginTop+=60, 75, 25);
		buyTicketFream.add(saveButton);
		
		cancelButton.setBounds(170, marginTop, 75, 25);
		buyTicketFream.add(cancelButton);
		
		
		
		
		
		
		
		buyTicketFream.setVisible(true);
	}
	public void addAction(){
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buyTicket(user,ticket,record);
				buyTicketFream.setVisible(false);
				
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			
					String changeData = "add";
					try {
						ticketService.updateTicketForRTdata(changeData, ticket.getTicket_id());//
					} catch (TicketCheckoutException e) {
						
						//��Ʊδ�ҵ�
						e.printStackTrace();
					} catch (updataException e) {	
						e.printStackTrace();
					} catch (buyTicketException e) {
						//��������
						e.printStackTrace();
					} 
					
				
				buyTicketFream.setVisible(false);
			}
		});
	}
	
	
	/**
	 * ����Ʊ���뵱ǰ�û���Ϣ��ѡ�еĳ�Ʊ��Ϣ
	 * @param user
	 * @param ticket
	 */
	public void buyTicket(User user,Ticket ticket,Record record){
		//ȷ�Ϲ��򣬸������Ʊ��¼�����������޸Ĺ�Ʊ��¼�еĹ�Ʊ״̬
		
		
		//�ж�����Ƿ��㹻������㹻��ֱ�ӹ���
		if (user.getBalance()>=ticket.getTicket_price()) {
			user.setBalance(0-ticket.getTicket_price());
			//�޸��û����ۿ
			userService.updateUserBalance(user);
			//��ǰ��Ʊ��¼������û�id,�޸Ĺ�Ʊ״̬
			record.setUserId(user.getId());
			record.setBuyState("�ѹ���");//2.��ʾ�Ѹ���
			//��������ݿ�����Ӽ�¼
			userService.addRecord(record);
		}else{
				//��ǰ��Ʊ��¼������û�id,�޸Ĺ�Ʊ״̬
				record.setUserId(user.getId());
				record.setBuyState("δ����");//2.��ʾδ����
				//��������ݿ�����Ӽ�¼
				userService.addRecord(record);
		}
		
		
	}

	
	
	
	public void start(){
		init();
		addAction();
		build();
	}
	


}
