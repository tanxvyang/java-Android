package com.wbj.ui;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import com.wbj.exception.UserNotFoundException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.TicketService;
import com.wbj.service.UserService;
import com.wbj.util.Pager;

public class ManagerUserFream {

	
	JFrame managerUserFream = null;
	
	JLabel userNameLabel = null;
	JLabel realNameLabel = null;
	JLabel username = null;
	JLabel idNumber = null; ///??????????????????????/
	JLabel userState = null;


	JTextField userNameField = null;
	JTextField idNumberField = null;
	JTextField userStateField = null;
	JButton searchButton = null;
	JButton checkButton = null;
	JScrollPane jsp = null;
	JTable resultTable = null;
	//分页按钮和页数显示
	
	JLabel currentPageLabel = null;	//当前页码
	JTextField currentPageField = null;
	JLabel totalPageLabel = null;	//总页数
	JTextField totalPageField = null; 
	JLabel separtorLabel = null;	//分隔符
	JButton prePageButton =null;	//上一页
	JButton nextPageButton =null;	//下一页
	JButton LockButton = null; //封禁
	JButton unlockButton = null; //解封
	JButton authorizationButton = null; //解封
	ManagerDealRechargeFream  dealRechargeFream= null ;
	
	
	





	User user = null;//保存当前登录的用户信息
	UserService userService =null;
	String prePageNum = null;
	String nextPageNum = null;
	

	public ManagerUserFream(User user){
		this.user = user;
	}
	
	public void init(){
		managerUserFream = new JFrame("黄牛网-用户管理");
		 userNameLabel = new JLabel("管理员:"+user.getUsername());
		 realNameLabel =new JLabel("姓名:"+user.getName());
		username =  new JLabel("用户名：");
		 idNumber = new JLabel("身份证："); ///??????????????????????/
		 userState = new JLabel("用户状态：");

		 userNameField = new JTextField();
		 idNumberField = new JTextField();
		 userStateField = new JTextField();
		 searchButton = new JButton("查询");
		 checkButton = new JButton("充值审核");
		 resultTable = new JTable();
			jsp = new JScrollPane(resultTable);
			
			 currentPageLabel =  new JLabel("当前");	//当前页码
			 currentPageField = new JTextField();
			 totalPageLabel =  new JLabel("总页数");//总页数
			 totalPageField =new JTextField();
			 separtorLabel = new JLabel("/");	//分隔符
			 prePageButton = new JButton("上一页");	//上一页
			 nextPageButton = new JButton("下一页");	//下一页
			 LockButton = new JButton("封禁");
			 unlockButton = new JButton("解封");
			 authorizationButton = new JButton("授权");
			 dealRechargeFream = new ManagerDealRechargeFream(user);
		 userService = (UserService) ObjectFactory.getObject("userService");
	}
	public void build(){
		managerUserFream.setSize(800, 800);
		managerUserFream.setLocation(500, 100);
		managerUserFream.setLayout(null);
		managerUserFream.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		int marginLeft =20;
		int marginTop = 90;

		userNameLabel.setBounds(marginLeft, marginTop-60, 100, 25);
		managerUserFream.add(userNameLabel);


		realNameLabel.setBounds(marginLeft+=150, marginTop-60, 60, 25);

		username.setBounds(marginLeft=20, marginTop, 60, 25);
		managerUserFream.add(username);

		userNameField.setBounds(marginLeft+=50, marginTop, 90, 25);
		managerUserFream.add(userNameField);

		idNumber.setBounds(marginLeft+=100, marginTop, 60, 25);
		managerUserFream.add(idNumber);
		
		idNumberField.setBounds(marginLeft+=50, marginTop, 90, 25);
		managerUserFream.add(idNumberField);
		
		userState.setBounds(marginLeft+=100, marginTop, 80, 25);
		managerUserFream.add(userState);
		
		userStateField.setBounds(marginLeft+=80, marginTop,90, 25);
		managerUserFream.add(userStateField);
		
		searchButton.setBounds(marginLeft+=120, marginTop, 60, 25);
		managerUserFream.add(searchButton);
		checkButton.setBounds(marginLeft+=80, marginTop, 100, 25);
		managerUserFream.add(checkButton);
		
		jsp.setBounds(10,marginTop+30,680, 420);
		String[] columnNames = {"编号","用户名","姓名","身份证号","余额","用户状态"};

		DefaultTableModel dtm = new DefaultTableModel(null, columnNames){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		resultTable.setDefaultRenderer(Object.class, r);
		resultTable.setModel(dtm);

		managerUserFream.add(jsp);


		prePageButton.setBounds(marginLeft=50,marginTop=550,80,25);
		managerUserFream.add(prePageButton);
		currentPageLabel.setBounds(marginLeft+=100,marginTop=550,50,25); //=  new JLabel("当前");	//当前页码
		managerUserFream.add(currentPageLabel);
		currentPageField.setBounds(marginLeft+=30,marginTop,25,25);
		managerUserFream.add(currentPageField);
		separtorLabel.setBounds(marginLeft+=30,marginTop,10,25);
		managerUserFream.add(separtorLabel);
		totalPageField.setBounds(marginLeft+=10,marginTop,25,25);
		managerUserFream.add(totalPageField);
		totalPageLabel.setBounds(marginLeft+=30,marginTop,50,25);
		managerUserFream.add(totalPageLabel);

		nextPageButton.setBounds(marginLeft+=50,marginTop,80,25);
		managerUserFream.add(nextPageButton);
		
		LockButton.setBounds(marginLeft+=100, marginTop, 80, 25);
		managerUserFream.add(LockButton);
		unlockButton.setBounds(marginLeft+=100, marginTop, 80, 25);
		managerUserFream.add(unlockButton);
		authorizationButton.setBounds(marginLeft+=100, marginTop, 80, 25);
		managerUserFream.add(authorizationButton);
		



		managerUserFream.setVisible(true);
	}




	public void addAction(){
		
		
		
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				search("1");
			}
		});
		checkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dealRechargeFream.start();
				
				
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
		LockButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// 封禁 changeState = 3
				try {
					int unlock =JOptionPane.showConfirmDialog(managerUserFream, "是否对该用户进行封禁操作？");
					if ( unlock !=0 ) {
						return;
					}
					changeUserState("3");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(managerUserFream,
							"未选中要封禁的用户！", "封禁失败", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		unlockButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// 解封 changeState = 1
				try {
					int unlock =JOptionPane.showConfirmDialog(managerUserFream, "是否对该用户进行解封操作？");
					if ( unlock !=0 ) {
						return;
					}
					changeUserState("1");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(managerUserFream,
							"未选中要解封的用户！", "解封失败", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		authorizationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					authorization();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(managerUserFream,
							"未选中要授权的用户！", "操作失败", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}
	public void changeUserState(String changeState){
		User user = null;
		//获得选中的用户
		int row = resultTable.getSelectedRow();
		int col = 3;
		Object value = resultTable.getValueAt(row, col);
		String idNumber = String.valueOf(value);
		//查找相关用户，使用身份证号  idNumber
		 try {
		 user =userService.selectUserByidNumber(idNumber);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		//对用户状态标志位做修改
		
		if (!user.getUser_state().equals("2")) {
			user.setUser_state(changeState);
		}
		
		userService.updateUserState(user);
		
		search("1");
	}
	/**
	 * 授权用户/取消
	 * @param changeState
	 */
	
	public void authorization(){
		User user = null;
		//获得选中的用户
		int row = resultTable.getSelectedRow();
		int col = 3;
		Object value = resultTable.getValueAt(row, col);
		String idNumber = String.valueOf(value);
		//查找相关用户，使用身份证号  idNumber
		 try {
		 user =userService.selectUserByidNumber(idNumber);
		} catch (UserNotFoundException e) {
			JOptionPane.showMessageDialog(managerUserFream,
					"该用户不存在", "操作失败", JOptionPane.ERROR_MESSAGE);
		}
		//对用户状态标志位做修改
		
		if (!user.getUser_state().equals("3")) {
			if (user.getId()==1) {
				JOptionPane.showMessageDialog(managerUserFream,
						"无法对超级管理员进行此操作", "操作失败", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (user.getUser_state().equals("1")) {
				int authorization =JOptionPane.showConfirmDialog(managerUserFream, "是否授权该用户成为管理员？");
				if ( authorization !=0 ) {
					return;
				}
				user.setUser_state("2");
			}else if (user.getUser_state().equals("2")) {
				int authorization =JOptionPane.showConfirmDialog(managerUserFream, "是否收回该管理员的权限？");
				if ( authorization !=0 ) {
					return;
				}
				user.setUser_state("1");
			}
			
		}else {
			JOptionPane.showMessageDialog(managerUserFream,
					"该用户已经被封禁，无法授权成为管理员", "操作失败", JOptionPane.ERROR_MESSAGE);
		}
		
		userService.updateUserState(user);
		
		search("1");
	}
	




	public void search(String pagenums)  {
			String username = userNameField.getText();
			String idNumber = idNumberField.getText();
			String userState = userStateField.getText();
		
		
		List<User> userlist = null;
		
		Pager pager = null;
		pager =userService.selectUserForPage(username,idNumber,userState,pagenums);
		userlist = pager.getData();
		//表头如何获得
		String[] columnNames = {"编号","用户名","姓名","身份证号","用户状态"};
		Object[][] data = new Object[userlist.size()][columnNames.length];
		for (int i = 0; i < userlist.size(); i++) {
			User user = userlist.get(i);
			data[i][0] = user.getId();
			data[i][1] = user.getUsername();
			data[i][2] = user.getName();
			data[i][3] = user.getId_number();
			
			if (user.getUser_state().equals("1")) {
				user.setUser_state("普通用户");
			}if (user.getUser_state().equals("2")) {
				user.setUser_state("管理员");
			}if (user.getUser_state().equals("3")) {
				user.setUser_state("封禁用户");
			}
			data[i][4] = user.getUser_state();
		}
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		resultTable.setModel(dtm);
		currentPageField .setText(pager.getCurrentPageNum().toString());//传入页码
		totalPageField .setText(pager.getTotalPage().toString());//传入总页数
		prePageNum = pager.getPrePageNum().toString(); //记录上一页
		nextPageNum = pager.getNextPageNum().toString();//记录下一页
	}

	public void start(){
		init();
	addAction();
		build();
	}






}
