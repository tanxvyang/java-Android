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
		loginMainFrame = new JFrame("��ţ��-�û���¼");
		helloLabel = new JLabel("��ˮǧɽ·�����������С�");
		usernameLabel = new JLabel("�û�����");
		usernameField = new JTextField();
		passwordLabel = new JLabel("��    �룺");
		passwordField = new JPasswordField();
		loginButton = new JButton("��¼");
		registerButton = new JButton("ע��");
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
		
		//��Ҫ�����ж��û�״̬���������ͨ�û������빺Ʊҳ�棬����Ա�������ҳ�棬�����û���ʾ
		if (user.getUser_state().equals("1")) {
			//������ͨ�û�����
			JOptionPane.showMessageDialog(loginMainFrame,"�û���¼�ɹ�","��¼�ɹ�",JOptionPane.INFORMATION_MESSAGE);
			loginMainFrame.setVisible(false);
			new UserMainFream(user).start();
		}else if (user.getUser_state().equals("2")) {
			//�������Աҳ��
			JOptionPane.showMessageDialog(loginMainFrame,"����Ա��¼�ɹ�","��¼�ɹ�",JOptionPane.INFORMATION_MESSAGE);
			loginMainFrame.setVisible(false);
			 new ManagerMainFream(user).start();
		}else if (user.getUser_state().equals("3")) {
			JOptionPane.showMessageDialog(loginMainFrame,"��ǰ�˻��쳣��¼ʧ��","��¼ʧ��",JOptionPane.ERROR_MESSAGE);
			//�ɼ����쳣����ҳ��
		}
	} catch (LoginFailException e) {
		JOptionPane.showMessageDialog(loginMainFrame,e.getMessage(),"��¼ʧ��",JOptionPane.ERROR_MESSAGE);
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
