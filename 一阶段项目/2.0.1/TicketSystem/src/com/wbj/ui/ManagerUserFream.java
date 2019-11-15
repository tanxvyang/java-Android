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
	//��ҳ��ť��ҳ����ʾ
	
	JLabel currentPageLabel = null;	//��ǰҳ��
	JTextField currentPageField = null;
	JLabel totalPageLabel = null;	//��ҳ��
	JTextField totalPageField = null; 
	JLabel separtorLabel = null;	//�ָ���
	JButton prePageButton =null;	//��һҳ
	JButton nextPageButton =null;	//��һҳ
	JButton LockButton = null; //���
	JButton unlockButton = null; //���
	JButton authorizationButton = null; //���
	ManagerDealRechargeFream  dealRechargeFream= null ;
	
	
	





	User user = null;//���浱ǰ��¼���û���Ϣ
	UserService userService =null;
	String prePageNum = null;
	String nextPageNum = null;
	

	public ManagerUserFream(User user){
		this.user = user;
	}
	
	public void init(){
		managerUserFream = new JFrame("��ţ��-�û�����");
		 userNameLabel = new JLabel("����Ա:"+user.getUsername());
		 realNameLabel =new JLabel("����:"+user.getName());
		username =  new JLabel("�û�����");
		 idNumber = new JLabel("���֤��"); ///??????????????????????/
		 userState = new JLabel("�û�״̬��");

		 userNameField = new JTextField();
		 idNumberField = new JTextField();
		 userStateField = new JTextField();
		 searchButton = new JButton("��ѯ");
		 checkButton = new JButton("��ֵ���");
		 resultTable = new JTable();
			jsp = new JScrollPane(resultTable);
			
			 currentPageLabel =  new JLabel("��ǰ");	//��ǰҳ��
			 currentPageField = new JTextField();
			 totalPageLabel =  new JLabel("��ҳ��");//��ҳ��
			 totalPageField =new JTextField();
			 separtorLabel = new JLabel("/");	//�ָ���
			 prePageButton = new JButton("��һҳ");	//��һҳ
			 nextPageButton = new JButton("��һҳ");	//��һҳ
			 LockButton = new JButton("���");
			 unlockButton = new JButton("���");
			 authorizationButton = new JButton("��Ȩ");
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
		String[] columnNames = {"���","�û���","����","���֤��","���","�û�״̬"};

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
		currentPageLabel.setBounds(marginLeft+=100,marginTop=550,50,25); //=  new JLabel("��ǰ");	//��ǰҳ��
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

				// ��� changeState = 3
				try {
					int unlock =JOptionPane.showConfirmDialog(managerUserFream, "�Ƿ�Ը��û����з��������");
					if ( unlock !=0 ) {
						return;
					}
					changeUserState("3");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(managerUserFream,
							"δѡ��Ҫ������û���", "���ʧ��", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		unlockButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// ��� changeState = 1
				try {
					int unlock =JOptionPane.showConfirmDialog(managerUserFream, "�Ƿ�Ը��û����н�������");
					if ( unlock !=0 ) {
						return;
					}
					changeUserState("1");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(managerUserFream,
							"δѡ��Ҫ�����û���", "���ʧ��", JOptionPane.ERROR_MESSAGE);
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
							"δѡ��Ҫ��Ȩ���û���", "����ʧ��", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}
	public void changeUserState(String changeState){
		User user = null;
		//���ѡ�е��û�
		int row = resultTable.getSelectedRow();
		int col = 3;
		Object value = resultTable.getValueAt(row, col);
		String idNumber = String.valueOf(value);
		//��������û���ʹ�����֤��  idNumber
		 try {
		 user =userService.selectUserByidNumber(idNumber);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		//���û�״̬��־λ���޸�
		
		if (!user.getUser_state().equals("2")) {
			user.setUser_state(changeState);
		}
		
		userService.updateUserState(user);
		
		search("1");
	}
	/**
	 * ��Ȩ�û�/ȡ��
	 * @param changeState
	 */
	
	public void authorization(){
		User user = null;
		//���ѡ�е��û�
		int row = resultTable.getSelectedRow();
		int col = 3;
		Object value = resultTable.getValueAt(row, col);
		String idNumber = String.valueOf(value);
		//��������û���ʹ�����֤��  idNumber
		 try {
		 user =userService.selectUserByidNumber(idNumber);
		} catch (UserNotFoundException e) {
			JOptionPane.showMessageDialog(managerUserFream,
					"���û�������", "����ʧ��", JOptionPane.ERROR_MESSAGE);
		}
		//���û�״̬��־λ���޸�
		
		if (!user.getUser_state().equals("3")) {
			if (user.getId()==1) {
				JOptionPane.showMessageDialog(managerUserFream,
						"�޷��Գ�������Ա���д˲���", "����ʧ��", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (user.getUser_state().equals("1")) {
				int authorization =JOptionPane.showConfirmDialog(managerUserFream, "�Ƿ���Ȩ���û���Ϊ����Ա��");
				if ( authorization !=0 ) {
					return;
				}
				user.setUser_state("2");
			}else if (user.getUser_state().equals("2")) {
				int authorization =JOptionPane.showConfirmDialog(managerUserFream, "�Ƿ��ջظù���Ա��Ȩ�ޣ�");
				if ( authorization !=0 ) {
					return;
				}
				user.setUser_state("1");
			}
			
		}else {
			JOptionPane.showMessageDialog(managerUserFream,
					"���û��Ѿ���������޷���Ȩ��Ϊ����Ա", "����ʧ��", JOptionPane.ERROR_MESSAGE);
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
		//��ͷ��λ��
		String[] columnNames = {"���","�û���","����","���֤��","�û�״̬"};
		Object[][] data = new Object[userlist.size()][columnNames.length];
		for (int i = 0; i < userlist.size(); i++) {
			User user = userlist.get(i);
			data[i][0] = user.getId();
			data[i][1] = user.getUsername();
			data[i][2] = user.getName();
			data[i][3] = user.getId_number();
			
			if (user.getUser_state().equals("1")) {
				user.setUser_state("��ͨ�û�");
			}if (user.getUser_state().equals("2")) {
				user.setUser_state("����Ա");
			}if (user.getUser_state().equals("3")) {
				user.setUser_state("����û�");
			}
			data[i][4] = user.getUser_state();
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
