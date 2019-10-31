package com.ttb.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ttb.entity.Good;
import com.ttb.exception.GoodAlreadyExistException;
import com.ttb.exception.MoneyNotEnoughException;
import com.ttb.service.GoodService;
import com.ttb.service.impl.GoodServiceImpl;
import com.ttb.util.StringUtil;

public class AddGoodFrame {
	JFrame mainFrame = null;
	JLabel goodNameLabel = null;
	JLabel goodPriceLabel = null;
	JLabel goodIntroLabel = null;
	JLabel numsLabel = null;
	JTextField goodNameField = null;
	JTextField goodPriceField = null;
	JTextArea goodIntroArea = null;
	JTextField numsField = null;
	JButton saveButton = null;
	JButton cancelButton = null;
	AdminFrame masterFrame = null;
	GoodService gs = null;
	public AddGoodFrame(AdminFrame adminFrame) {
		masterFrame = adminFrame;
	}
	public void init(){
		mainFrame = new JFrame("淘淘宝 - 添加商品");
		goodNameLabel = new JLabel("名称：");
		goodPriceLabel = new JLabel("价格：");
		goodIntroLabel = new JLabel("简介：");
		numsLabel = new JLabel("数量");
		goodNameField = new JTextField();
		goodPriceField = new JTextField();
		numsField = new JTextField();
		goodIntroArea = new JTextArea();
		saveButton = new JButton("确认");
		cancelButton = new JButton("取消");
		gs = new GoodServiceImpl();
	}
	public void build(){
		mainFrame.setSize(400, 200);
		mainFrame.setLocation(550, 250);
		mainFrame.setLayout(null);
		
		goodNameLabel.setBounds(10, 10, 55, 25);
		mainFrame.add(goodNameLabel);
		
		goodNameField.setBounds(70, 10, 95, 25);
		mainFrame.add(goodNameField);
		
		goodPriceLabel.setBounds(10, 40, 55, 25);
		mainFrame.add(goodPriceLabel);
		
		goodPriceField.setBounds(70, 40, 95, 25);
		mainFrame.add(goodPriceField);
		
		numsLabel.setBounds(10, 70, 55, 25);
		mainFrame.add(numsLabel);
		
		numsField.setBounds(70, 70, 95, 25);
		mainFrame.add(numsField);
		
		goodIntroLabel.setBounds(200, 10, 55, 25);
		mainFrame.add(goodIntroLabel);
		
		goodIntroArea.setBounds(260, 10, 95, 85);
		mainFrame.add(goodIntroArea);
		
		saveButton.setBounds(90, 110, 75, 25);
		mainFrame.add(saveButton);
		
		cancelButton.setBounds(200, 110, 75, 25);
		mainFrame.add(cancelButton);
		
		mainFrame.setVisible(true);
	}
	public void addAction(){
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> errorMessages = new ArrayList<String>();
				//表单验证
				String goodName = goodNameField.getText();
				if(StringUtil.checkString(goodName)){
					errorMessages.add( "商品名不能为空");
				}
				
				Double goodPrice = null;
				try {
					goodPrice = Double.valueOf(goodPriceField.getText());
					if(goodPrice < 0){
						errorMessages.add( "商品价格不能小于0");
					}
				} catch (Exception e) {
					errorMessages.add( "商品价格格式错误");
				}
				
				Integer nums = null;
				try {
					nums = Integer.valueOf(numsField.getText());
					if(nums < 0){
						errorMessages.add( "商品数量不能小于0");
					}
				} catch (Exception e) {
					errorMessages.add( "商品数量格式错误");
				}
				
				String goodIntro = goodIntroArea.getText();
				if(StringUtil.checkString(goodIntro)){
					errorMessages.add( "商品简介不能为空");
				}
				
				if(errorMessages.size() != 0){
					StringBuffer sb = new StringBuffer();
					for (String string : errorMessages) {
						sb.append(string).append("\n");
					}
					JOptionPane.showMessageDialog(mainFrame, sb.toString(), "添加商品错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Good good = new Good();
				good.setGoodIntro(goodIntro);
				good.setGoodName(goodName);
				good.setNums(nums);
				good.setGoodPrice(goodPrice);

				try {
					gs.addGood(good);
				} catch (GoodAlreadyExistException e) {
					e.printStackTrace();
				} catch (MoneyNotEnoughException e) {
					e.printStackTrace();
				}
				
				masterFrame.search();
				
				mainFrame.setVisible(false);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.setVisible(false);
			}
		});
	}
	
	public void start(){
		init();
		addAction();
		build();
	}
	
}












