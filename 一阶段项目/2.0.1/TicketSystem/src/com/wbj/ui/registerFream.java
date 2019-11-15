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
		regusterMainFrame = new JFrame("黄牛网-账户注册");
		usernameLabel = new JLabel("用户名：");
		passwordLabel = new JLabel("密  码：");
		affPasswordLabel = new JLabel("确认密码：");
		nameLabel     = new JLabel("姓  名：");
		phoneNumberLabel = new JLabel("手机号码:");
		idNumberLabel = new JLabel("身份证号:");
		
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		affPasswordField = new JPasswordField();
		nameField = new JTextField();
		phoneNumberField = new JTextField();
		idNumberField = new JTextField();
		
		saveButton = new JButton("确认");
		cancelButton = new JButton("取消");
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
				//表单验证
				
				//验证用户名
				String username = usernameField.getText();
				if(StringUtil.checkString(username)){
					errorMessages.add( "用户名不能为空");
				}
				//验证密码格式
				String password = passwordField.getText();
				String affPassword = affPasswordField.getText();
				if(StringUtil.checkString(password)){
					errorMessages.add( "密码不能为空！");
				}else {
					if(StringUtil.checkString(affPassword)){
						errorMessages.add( "请再次输入密码，确认密码不能为空！");
					}
					if(!(password.equals(affPassword))){
						errorMessages.add( "密码确认失败，请重新确认！");
					}
				}
				
				
				
				//真实姓名
				String name = nameField.getText();
				if(StringUtil.checkString(name)){
					errorMessages.add( "实名认证，姓名不可为空！");
				}
				//电话号码
				String phoneNumber = phoneNumberField.getText(); //电话号码？可为空
				if(StringUtil.checkString(phoneNumber)){
					errorMessages.add( "电话号码不能为空！");
				}else if(!StringUtil.cheickPhoneNumber(phoneNumber)){
					errorMessages.add( "电话号码格式不符合要求");
				}
				
				//身份证号
				String idNumber = idNumberField.getText(); 
				if(StringUtil.checkString(idNumber)){
					errorMessages.add( "实名认证要求，身份证不能为空！");
				}else if(!StringUtil.cheickIdNumber(idNumber)){
					errorMessages.add( "身份证不符合要求");
				}
				
				
				if(errorMessages.size() != 0){
					StringBuffer sb = new StringBuffer();
					for (String string : errorMessages) {
						sb.append(string).append("\n");
					}
					JOptionPane.showMessageDialog(regusterMainFrame, sb.toString(), "注册错误", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(regusterMainFrame,"注册成功！","注册成功",JOptionPane.INFORMATION_MESSAGE);
				} catch (RegisterFailException e) {
					JOptionPane.showMessageDialog(regusterMainFrame, e
							.getMessage(), "注册失败", JOptionPane.ERROR_MESSAGE);
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
