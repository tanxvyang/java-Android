package com.wbj.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Severity;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wbj.entity.User;
import com.wbj.exception.RegisterFailException;
import com.wbj.exception.UserNotFoundException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.UserService;
import com.wbj.util.Pager;
import com.wbj.util.StringUtil;

public class registerFream {

	JFrame regusterMainFrame = null;
	JLabel	usernameLabel = null;
	JLabel passwordLabel = null;
	JLabel affPasswordLabel = null;
	JLabel nameLabel = null;
	JLabel phoneNumberLabel = null;
	JLabel idNumberLabel = null;
	
	
	
	JTextField usernameField = null;
	JTextField passwordField = null;
	JTextField affPasswordField = null;
	JTextField nameField = null;
	JTextField phoneNumberField = null;
	JTextField idNumberField = null;
	JButton saveButton = null;
	JButton cancelButton = null;
	UserService userService = null;
	LoginFream loginFream = null;

	public void init(){
		regusterMainFrame = new JFrame("��ţ��-�˻�ע��");
		usernameLabel = new JLabel("�û�����");
		passwordLabel = new JLabel("��  �룺");
		affPasswordLabel = new JLabel("ȷ�����룺");
		nameLabel     = new JLabel("��  ����");
		phoneNumberLabel = new JLabel("�ֻ�����:");
		idNumberLabel = new JLabel("���֤��:");
		
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		affPasswordField = new JPasswordField();
		nameField = new JTextField();
		phoneNumberField = new JTextField();
		idNumberField = new JTextField();
		
		saveButton = new JButton("ȷ��");
		cancelButton = new JButton("ȡ��");
		loginFream =new LoginFream();
	   userService = (UserService) ObjectFactory.getObject("userServiceProxy");
		
	}
	public void build(){
		regusterMainFrame.setSize(300, 300);
		regusterMainFrame.setLocationRelativeTo(null);
		regusterMainFrame.setLayout(null);
		int lable_x= 20; 
		int field_x= 100; 
		int y=0;
		int length = 0;
		int width = 0;
		
		usernameLabel.setBounds(lable_x, y+=10, length+=60, width+=25);
		regusterMainFrame.add(usernameLabel);
		
		usernameField.setBounds(field_x, y, length+=80, width);
		regusterMainFrame.add(usernameField);
		
		passwordLabel.setBounds(lable_x, y+=30, length-=80, width);
		regusterMainFrame.add(passwordLabel);
		
		passwordField.setBounds(field_x, y, length+=80, width);
		regusterMainFrame.add(passwordField);
		affPasswordLabel.setBounds(lable_x, y+=30, 100, width);
		regusterMainFrame.add(affPasswordLabel);
		length-=80;
		affPasswordField.setBounds(field_x, y, length+=80, width);
		regusterMainFrame.add(affPasswordField);
		
		nameLabel.setBounds(lable_x, y+=30,  length-=80, width);
		regusterMainFrame.add(nameLabel);
		
		nameField.setBounds(field_x, y, length+=80, width);
		regusterMainFrame.add(nameField);
		
		phoneNumberLabel.setBounds(lable_x, y+=30, length-=80, width);
		regusterMainFrame.add(phoneNumberLabel);
		
		phoneNumberField.setBounds(field_x, y, length+=80, width);
		regusterMainFrame.add(phoneNumberField);
		
		idNumberLabel.setBounds(lable_x, y+=30, length-=80, width);
		regusterMainFrame.add(idNumberLabel);
		
		idNumberField.setBounds(field_x, y, length+=80, width);
		regusterMainFrame.add(idNumberField);
		
		saveButton.setBounds(70, y+=60, 75, 25);
		regusterMainFrame.add(saveButton);
		
		cancelButton.setBounds(170, y, 75, 25);
		regusterMainFrame.add(cancelButton);
		
		regusterMainFrame.setVisible(true);
	}
	public void addAction(){
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> errorMessages = new ArrayList<String>();
				//����֤
				
				//��֤�û���
				String username = usernameField.getText();
				if(StringUtil.checkString(username)){
					errorMessages.add( "�û�������Ϊ��");
				}
				//��֤�����ʽ
				String password = passwordField.getText();
				String affPassword = affPasswordField.getText();
				if(StringUtil.checkString(password)){
					errorMessages.add( "���벻��Ϊ�գ�");
				}else {
					if(StringUtil.checkString(affPassword)){
						errorMessages.add( "���ٴ��������룬ȷ�����벻��Ϊ�գ�");
					}
					if(!(password.equals(affPassword))){
						errorMessages.add( "����ȷ��ʧ�ܣ�������ȷ�ϣ�");
					}
				}
				
				
				
				//��ʵ����
				String name = nameField.getText();
				if(StringUtil.checkString(name)){
					errorMessages.add( "ʵ����֤����������Ϊ�գ�");
				}
				//�绰����
				String phoneNumber = phoneNumberField.getText(); //�绰���룿��Ϊ��
				if(StringUtil.checkString(phoneNumber)){
					errorMessages.add( "�绰���벻��Ϊ�գ�");
				}else if(!StringUtil.cheickPhoneNumber(phoneNumber)){
					errorMessages.add( "�绰�����ʽ������Ҫ��");
				}
				
				//���֤��
				String idNumber = idNumberField.getText(); 
				if(StringUtil.checkString(idNumber)){
					errorMessages.add( "ʵ����֤Ҫ�����֤����Ϊ�գ�");
				}else if(!StringUtil.cheickIdNumber(idNumber)){
					errorMessages.add( "���֤������Ҫ��");
				}
				
				
				if(errorMessages.size() != 0){
					StringBuffer sb = new StringBuffer();
					for (String string : errorMessages) {
						sb.append(string).append("\n");
					}
					JOptionPane.showMessageDialog(regusterMainFrame, sb.toString(), "ע�����", JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setName(name);
				user.setId_number(idNumber);
				user.setPhone_number(phoneNumber);
				user.setUser_state("1");
				user.setBalance(0.0);

				try {
					userService.register(user);
					JOptionPane.showMessageDialog(regusterMainFrame,"ע��ɹ���","ע��ɹ�",JOptionPane.INFORMATION_MESSAGE);
				} catch (RegisterFailException e) {
					JOptionPane.showMessageDialog(regusterMainFrame, e
							.getMessage(), "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
				}

				regusterMainFrame.setVisible(false);
				loginFream.start();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				regusterMainFrame.setVisible(false);
				loginFream.start();
			}
		});
	}
	
	public void start(){
		init();
		addAction();
		build();
	}
	


}
