package com.ttb.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.ttb.entity.User;
import com.ttb.exception.LoginFailException;
import com.ttb.service.UserService;
import com.ttb.service.impl.UserServiceImpl;

public class LoginFrame {
	JFrame mainFrame = null;
	JLabel usernameLabel = null;
	JTextField usernameField = null;
	JLabel passwordLabel = null;
	JPasswordField passwordField = null;
	JButton loginButton = null;
	UserService us = null;

	public void init(){
		mainFrame = new JFrame("淘淘宝 - 用户登录");
		usernameLabel = new JLabel("用户名：");
		usernameField = new JTextField();
		passwordLabel = new JLabel("密    码：");
		passwordField = new JPasswordField();
		loginButton = new JButton("登录");
		us = new UserServiceImpl();
	}
	public void build(){
		mainFrame.setSize(300, 300);
		mainFrame.setLocation(500, 100);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);
		
		usernameLabel.setBounds(50, 50, 60, 25);
		mainFrame.add(usernameLabel);
		
		usernameField.setBounds(120, 50, 120, 25);
		mainFrame.add(usernameField);
		
		passwordLabel.setBounds(50, 100, 60, 25);
		mainFrame.add(passwordLabel);
		
		passwordField.setBounds(120, 100, 120, 25);
		mainFrame.add(passwordField);
		
		loginButton.setBounds(100, 150, 60, 25);
		mainFrame.add(loginButton);
		
		mainFrame.setVisible(true);
	}
	public void addAction(){
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				try {
					User user = us.login(username, password);
					JOptionPane.showMessageDialog(mainFrame,"登录成功","登录成功",JOptionPane.INFORMATION_MESSAGE);
					new MainFrame(user).start();
					mainFrame.setVisible(false);
				} catch (LoginFailException e) {
					JOptionPane.showMessageDialog(mainFrame,e.getMessage(),"登录失败",JOptionPane.ERROR_MESSAGE);
//					e.printStackTrace();//打印错误的堆栈信息
				}
			}
		});
	}
	public void start(){
		init();
		addAction();
		build();
	}
}
