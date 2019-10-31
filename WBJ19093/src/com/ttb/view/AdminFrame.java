package com.ttb.view;

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
import javax.swing.table.DefaultTableModel;

import com.ttb.entity.Good;
import com.ttb.exception.GoodNotFoundException;
import com.ttb.service.GoodService;
import com.ttb.service.impl.GoodServiceImpl;

public class AdminFrame {
	JFrame mainFrame = null;
	JLabel goodNameLabel = null;
	JTextField goodNameField = null;
	JButton searchButton = null;
	JButton addButton = null;
	JButton removeButton = null;
	JScrollPane jsp = null;
	JTable resultTable = null;
	GoodService gs = null;
	public void init(){
		mainFrame = new JFrame("淘淘宝 - 后台页面");
		goodNameLabel = new JLabel("商品名：");
		goodNameField = new JTextField();
		searchButton = new JButton("查询");
		addButton = new JButton("添加");
		removeButton = new JButton("删除");
		resultTable = new JTable();
		jsp = new JScrollPane(resultTable);
		gs = new GoodServiceImpl();
	}
	public void setFont(){
		mainFrame.setSize(500, 500);
		mainFrame.setLocation(500,100);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);
		
		goodNameLabel.setBounds(30, 30, 55, 25);
		mainFrame.add(goodNameLabel);
		
		goodNameField.setBounds(90, 30, 100, 25);
		mainFrame.add(goodNameField);
		
		searchButton.setBounds(200, 30, 70, 25);
		mainFrame.add(searchButton);
		
		addButton.setBounds(300, 30, 70, 25);
		mainFrame.add(addButton);

		removeButton.setBounds(400, 30, 70, 25);
		mainFrame.add(removeButton);
		
		jsp.setBounds(10, 70, 460, 380);
		mainFrame.add(jsp);
		
		mainFrame.setVisible(true);
	}
	public void addAction(){
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AddGoodFrame(getInstance()).start();
			}
		});
		
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				remove();
			}
		});
	}
	public AdminFrame getInstance(){
		return this;
	}
	public void search(){
		String goodName = goodNameField.getText();
		//表单验证view（数据是否为空，数据类型是否合法，数据长度是否合法）
//		    逻辑判断service（商品名称是否重复）
		List<Good> goods = gs.queryGoodsByGoodName(goodName);
		//表头如何获得
		String[] columnNames = {"编号","商品名称","商品价格","商品介绍","库存数量"};
		Object[][] data = new Object[goods.size()][columnNames.length];
		for (int i = 0; i < goods.size(); i++) {
			Good good = goods.get(i);
			data[i][0] = good.getGid();
			data[i][1] = good.getGoodName();
			data[i][2] = good.getGoodPrice();
			data[i][3] = good.getGoodIntro();
			data[i][4] = good.getNums();
		}
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		resultTable.setModel(dtm);
	}
	
	public void remove(){
		int row = resultTable.getSelectedRow();
		int col = 0;
		Object value = resultTable.getValueAt(row, col);
		Integer gid = Integer.valueOf(String.valueOf(value));
		try {
			gs.removeGood(gid);
		} catch (GoodNotFoundException e) {
			JOptionPane.showMessageDialog(mainFrame, e.getMessage(), "删除商品错误", JOptionPane.ERROR_MESSAGE);
		}
		search();
	}
	
	public void start(){
		init();
		addAction();
		search();
		setFont();
	}
	
	
	
	
	
	
	
	
	
	
}
