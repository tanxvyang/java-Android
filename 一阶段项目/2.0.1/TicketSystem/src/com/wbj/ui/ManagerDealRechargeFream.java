package com.wbj.ui;

import com.wbj.entity.Recharge;
import com.wbj.entity.Record;
import com.wbj.entity.Ticket;
import com.wbj.entity.User;
import com.wbj.exception.TicketCheckoutException;
import com.wbj.factory.ObjectFactory;
import com.wbj.service.TicketService;
import com.wbj.service.UserService;
import com.wbj.util.Pager;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

public class ManagerDealRechargeFream {


        JFrame dealRechargeFream = null;
        JLabel userNameLabel = null;
        JLabel realNameLabel = null;
        JButton searchButton = null;
        JButton deleteButton = null;

        JScrollPane jsp = null;
        JTable resultTable = null;
        //��ҳ��ť��ҳ����ʾ
        JLabel currentPageLabel = null;//��ǰҳ��
        JTextField currentPageField = null;
        JLabel totalPageLabel = null;	//��ҳ��
        JTextField totalPageField = null;
        JLabel separtorLabel = null;	//�ָ���
        JButton prePageButton =null;		//��һҳ
        JButton nextPageButton =null;		//��һҳ
        JButton passButton = null; //ͨ��
        JButton rejectButton = null; //����

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        User user = null;//���浱ǰ��¼���û���Ϣ
        TicketService ticketService =null;
        UserService userService =null;
        String prePageNum = null;
        String nextPageNum = null;


	 public ManagerDealRechargeFream(User user){
         this.user = user;
     }

        public void init(){
        dealRechargeFream = new JFrame("��ţ��-��˳�ֵ����");
        userNameLabel = new JLabel("����Ա:"+user.getUsername());
        realNameLabel =new JLabel("����:"+user.getName());
        searchButton = new JButton("��ѯ");
        deleteButton = new JButton("ɾ��");
        resultTable = new JTable();
        jsp = new JScrollPane(resultTable);

        currentPageLabel =  new JLabel("��ǰ");	//��ǰҳ��
        currentPageField = new JTextField();
        totalPageLabel =  new JLabel("��ҳ��");//��ҳ��
        totalPageField =new JTextField();
        separtorLabel = new JLabel("/");	//�ָ���
        prePageButton = new JButton("��һҳ");	//��һҳ
        nextPageButton =new JButton("��һҳ");	//��һҳ
        passButton = new JButton("ͨ��");
        rejectButton = new JButton("����");
        ticketService =(TicketService) ObjectFactory.getObject("ticketServiceProxy");
        userService = (UserService) ObjectFactory.getObject("userServiceProxy");
    }

        public void build(){
        dealRechargeFream.setSize(600, 700);
        dealRechargeFream.setLocationRelativeTo(null);
        dealRechargeFream.setLayout(null);
        dealRechargeFream.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        int marginLeft =20;
        int marginTop = 90;

        userNameLabel.setBounds(marginLeft, marginTop-60, 100, 25);
        dealRechargeFream.add(userNameLabel);


        realNameLabel.setBounds(marginLeft+=150, marginTop-60, 100, 25);
        dealRechargeFream.add(realNameLabel);


        searchButton.setBounds(marginLeft+=120, marginTop, 60, 25);
        dealRechargeFream.add(searchButton);
        deleteButton.setBounds(marginLeft+=70, marginTop, 60, 25);
        dealRechargeFream.add(deleteButton);

        jsp.setBounds(10,marginTop+30, 580, 420);
        String[] columnNames = {"���","�û���־","�û���","����ʱ��","������","����״̬"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnNames);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		resultTable.setDefaultRenderer(Object.class, r);
        resultTable.setModel(dtm);
        dealRechargeFream.add(jsp);


        prePageButton.setBounds(marginLeft=50,marginTop=550,80,25);
        dealRechargeFream.add(prePageButton);
        currentPageLabel.setBounds(marginLeft+=100,marginTop=550,50,25);
        dealRechargeFream.add(currentPageLabel);
        currentPageField.setBounds(marginLeft+=30,marginTop,25,25);
        dealRechargeFream.add(currentPageField);
        separtorLabel.setBounds(marginLeft+=30,marginTop,10,25);
        dealRechargeFream.add(separtorLabel);
        totalPageField.setBounds(marginLeft+=10,marginTop,25,25);
        dealRechargeFream.add(totalPageField);
        totalPageLabel.setBounds(marginLeft+=30,marginTop,50,25);
        dealRechargeFream.add(totalPageLabel);

        nextPageButton.setBounds(marginLeft+=50,marginTop,80,25);
        dealRechargeFream.add(nextPageButton);

        passButton.setBounds(marginLeft+=100, marginTop, 80, 25);
        dealRechargeFream.add(passButton);
        rejectButton.setBounds(marginLeft+=100, marginTop, 80, 25);
        dealRechargeFream.add(rejectButton);







        dealRechargeFream.setVisible(true);
    }







        public void addAction(){
        ticketService =(TicketService) ObjectFactory.getObject("ticketServiceProxy");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                search("1");
            }
        });
        
        
        deleteButton.addActionListener(new ActionListener() {
            Recharge recharge =null;

            @Override
            public void actionPerformed(ActionEvent arg0) {
            	
            	int[] rows = resultTable.getSelectedRows();//������ѡ��������������ȥ�ж��Ƿ��ѡ
				if(rows.length > 1){
					JOptionPane.showMessageDialog(dealRechargeFream,"ѡ����࣬Ĭ��ѡ���һ��","ɾ����ʾ",JOptionPane.ERROR_MESSAGE);
				}
            	
                int row = resultTable.getSelectedRow();
                int col = 0;
                try {
                	 Object value = resultTable.getValueAt(row, col);
                     Integer rechargeId = (Integer) value;
                     userService.deleteRecharge(rechargeId);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(dealRechargeFream,"��ѡ��Ҫɾ���ļ�¼","ɾ����ʾ",JOptionPane.ERROR_MESSAGE);

				}
                Object value = resultTable.getValueAt(row, col);
                Integer rechargeId = (Integer) value;
                //record.setRecordId(recordId);
                userService.deleteRecharge(rechargeId);
                search(currentPageField.getText());

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

/**
 * ��������
 */
        rejectButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
           Recharge recharge = new Recharge();
   	 User passUser = new User();
	 int[] rows = resultTable.getSelectedRows();//������ѡ��������������ȥ�ж��Ƿ��ѡ
		if(rows.length > 1){
			JOptionPane.showMessageDialog(dealRechargeFream,"ѡ����࣬Ĭ��ѡ���һ��","�����ʾ",JOptionPane.ERROR_MESSAGE);
		}
	 
    int row = resultTable.getSelectedRow();
    try {
	Object applyStatevalue = resultTable.getValueAt(row, 5);
	String applyState = String.valueOf(applyStatevalue);
    if (applyState.equals("δ����")) {
    	Object value = resultTable.getValueAt(row, 0);
        Integer rechargeId = (Integer) value;    
    	recharge.setRechargeId(rechargeId);
    	recharge.setApplyState("�Ѳ���");
    	userService.updateRecharge(recharge);
    }else {
    	JOptionPane.showMessageDialog(dealRechargeFream,"��������ͨ�����޷�����","�����ʾ",JOptionPane.ERROR_MESSAGE);
	}
    }catch (Exception e) {
			JOptionPane.showMessageDialog(dealRechargeFream,"δѡ���޷����","δѡ��",JOptionPane.ERROR_MESSAGE);
	}
        }
    });

       
        passButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            	 Recharge recharge = new Recharge();
            	 User passUser = new User();
            	 int[] rows = resultTable.getSelectedRows();//������ѡ��������������ȥ�ж��Ƿ��ѡ
 				if(rows.length > 1){
 					JOptionPane.showMessageDialog(dealRechargeFream,"ѡ����࣬Ĭ��ѡ���һ��","�����ʾ",JOptionPane.ERROR_MESSAGE);
 				}
            	 
                int row = resultTable.getSelectedRow();
                try {
					
				
        		Object applyStatevalue = resultTable.getValueAt(row, 5);
        		String applyState = String.valueOf(applyStatevalue);
                if (applyState.equals("δ����")) {
                	Object value = resultTable.getValueAt(row, 0);
                    Integer rechargeId = (Integer) value;    
                	recharge.setRechargeId(rechargeId);
                	recharge.setApplyState("��ͨ��");
                	userService.updateRecharge(recharge);
                	
                	//��ȡ�û�id
                	value = resultTable.getValueAt(row, 1);
                    Integer userId = (Integer) value;
                    
                    Object balanceValue = resultTable.getValueAt(row, 4);
                    Double balance = (Double) balanceValue;
                    
                    passUser.setId(userId);
                    passUser.setBalance(balance);
                	userService.updateUserBalance(passUser);
                	
                	search(currentPageField.getText());
                	
				}
                } catch (Exception e) {
 					JOptionPane.showMessageDialog(dealRechargeFream,"δѡ���޷����","δѡ��",JOptionPane.ERROR_MESSAGE);

				}
                
                
            }
        });


    }
     

        public void search(String pagenums){
        List<Recharge> rechargeList = null;
        Pager<Recharge> pager = null;
        pager = userService.selectUserPageRecharge(pagenums);
            rechargeList = pager.getData();
        String[] columnNames = {"���","�û���־","�û���","����ʱ��","������","����״̬"};
        Object[][] data = new Object[rechargeList.size()][columnNames.length];
        for (int i = 0; i < rechargeList.size(); i++) {
            Recharge recharge = rechargeList.get(i);
            data[i][0] = recharge.getRechargeId();
            data[i][1] = recharge.getUserId();
            data[i][2] = recharge.getUsername();
            data[i][3] = recharge.getApplyTime();
            data[i][4] = recharge.getApplyMoney();
            data[i][5] = recharge.getApplyState();



        }
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames){
            public boolean isCellEditable(int row, int column){
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
