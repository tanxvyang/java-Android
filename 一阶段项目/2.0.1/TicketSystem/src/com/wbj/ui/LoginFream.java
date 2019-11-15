package com.wbj.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.wbj.entity.User;
import com.wbj.exception.LoginFailException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.UserService;

public class LoginFream {
	JFrame loginMainFrame = null;
	JLabel usernameLabel = null;
	JLabel helloLabel = null;
	JTextField usernameField = null;
	JLabel passwordLabel = null;
	JPasswordField passwordField = null;
	JButton loginButton = null;
	JButton registerButton = null; 
	registerFream register = null;
	UserMainFream userMainFream = null;
	ManagerMainFream ManagerMainFream = null;

	public void init(){
		loginMainFrame = new JFrame("黄牛网-用户登录");
		helloLabel = new JLabel("万水千山路，人生足下行。");
		usernameLabel = new JLabel("用户名：");
		usernameField = new JTextField();
		passwordLabel = new JLabel("密    码：");
		passwordField = new JPasswordField();
		loginButton = new JButton("登录");
		registerButton = new JButton("注册");
		register = new registerFream();
		 
	}
	public void build(){
		loginMainFrame.setSize(300, 300);
		loginMainFrame.setLocationRelativeTo(null);
		loginMainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		loginMainFrame.setLayout(null);
		
		int marginTop = 80;
		
		helloLabel.setBounds(70, 30,200, 30);
		
		loginMainFrame.add(helloLabel);
		usernameLabel.setBounds(50, marginTop, 60, 25);
		loginMainFrame.add(usernameLabel);
		
		usernameField.setBounds(120, marginTop, 120, 25);
		loginMainFrame.add(usernameField);
		
		passwordLabel.setBounds(50, marginTop+=50, 60, 25);
		loginMainFrame.add(passwordLabel);
		
		passwordField.setBounds(120, marginTop, 120, 25);
		loginMainFrame.add(passwordField);
		
		loginButton.setBounds(80, marginTop+=50, 60, 25);
		loginMainFrame.add(loginButton);
		
		registerButton.setBounds(180, marginTop, 60, 25);
		loginMainFrame.add(registerButton);
		
		loginMainFrame.setVisible(true);
	}
	public void addAction(){

		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		
	
		
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginMainFrame.setVisible(false);
				register.start();
			}
		});
	}
public void login(){

	UserService userService = (UserService) ObjectFactory.getObject("userServiceProxy");
	String username = usernameField.getText();
	String password = new String(passwordField.getPassword());

	try {
		User user = userService.login(username, password);
		
		//需要加入判断用户状态，如果是普通用户，进入购票页面，管理员进入管理页面，冻结用户提示
		if (user.getUser_state().equals("1")) {
			//进入普通用户界面
			JOptionPane.showMessageDialog(loginMainFrame,"用户登录成功","登录成功",JOptionPane.INFORMATION_MESSAGE);
			loginMainFrame.setVisible(false);
			new UserMainFream(user).start();
		}else if (user.getUser_state().equals("2")) {
			//进入管理员页面
			JOptionPane.showMessageDialog(loginMainFrame,"管理员登录成功","登录成功",JOptionPane.INFORMATION_MESSAGE);
			loginMainFrame.setVisible(false);
			 new ManagerMainFream(user).start();
		}else if (user.getUser_state().equals("3")) {
			JOptionPane.showMessageDialog(loginMainFrame,"当前账户异常登录失败","登录失败",JOptionPane.ERROR_MESSAGE);
			//可加入异常处理页面
		}
	} catch (LoginFailException e) {
		JOptionPane.showMessageDialog(loginMainFrame,e.getMessage(),"登录失败",JOptionPane.ERROR_MESSAGE);
	} catch (Exception e) {
		e.printStackTrace();
	} 
	

	}
	
	public void start(){
		init();
		addAction();
		build();
	}

}
