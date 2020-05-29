package com.ttb.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.ttb.entity.Good;
import com.ttb.entity.User;
import com.ttb.service.GoodService;
import com.ttb.service.impl.GoodServiceImpl;

public class MainFrame {
    private static double shopMoney = 100;
    JFrame mainFrame = null;
    JPanel searchResultPane = null;
    JTextField searchTextField = null;
    JButton searchButton = null;
    User user = null;//���浱ǰ��¼���û���Ϣ
    GoodService gs = null;

    public MainFrame(User user) {
        this.user = user;
    }

    public void init() {
        mainFrame = new JFrame("���Ա� - ��ҳ��");
        searchTextField = new JTextField();
        searchButton = new JButton("��ѯ");
        searchResultPane = new JPanel();
        gs = new GoodServiceImpl();
    }

    public void build() {
        mainFrame.setSize(400, 600);
        mainFrame.setLocation(500, 100);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        searchTextField.setBounds(70, 30, 200, 25);
        mainFrame.add(searchTextField);

        searchButton.setBounds(300, 30, 70, 25);
        mainFrame.add(searchButton);

        searchResultPane.setBounds(0, 100, 400, 500);
        mainFrame.add(searchResultPane);

        mainFrame.setVisible(true);
    }

    public void addAction() {
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                search();
            }
        });
    }

    public void search() {
        String goodName = searchTextField.getText();
        List<Good> goods = gs.queryGoodsByGoodName(goodName);
        searchResultPane.removeAll();
        for (int i = 0; i < goods.size(); i++) {
            final Good good = goods.get(i);
            JLabel goodNameLabel = new JLabel(good.getGoodName());
            goodNameLabel.setBounds(16, (i * (25 + 15)), 80, 25);
            JLabel goodPriceLabel = new JLabel(String.valueOf(good.getGoodPrice()));
            goodPriceLabel.setBounds(16 + 80 + 16, (i * (25 + 15)), 80, 25);
            JLabel goodNumsLabel = new JLabel(String.valueOf(good.getNums()));
            goodNumsLabel.setBounds(16 + 80 + 16 + 80 + 16, (i * (25 + 15)), 80, 25);
            JButton buyButton = new JButton("����");
            buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    GoodServiceImpl gs = new GoodServiceImpl();
                    //��ȡ��������
                    String str = JOptionPane.showInputDialog(searchResultPane, "������Ҫ���������", "��������", JOptionPane.QUESTION_MESSAGE);
                    try {
                        Integer buyNums = Integer.parseInt(str);
                        gs.buy(user, good, buyNums);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(searchResultPane, "�����������ʽ����ȷ", "������ʾ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            buyButton.setBounds(16 + 80 + 16 + 80 + 16 + 80 + 16, (i * (25 + 15)), 80, 25);
            searchResultPane.add(goodNameLabel);
            searchResultPane.add(goodPriceLabel);
            searchResultPane.add(goodNumsLabel);
            searchResultPane.add(buyButton);
        }
        mainFrame.repaint();
    }

    public void start() {
        init();
        addAction();
        build();
    }

    public static double getShopMoney() {
        return shopMoney;
    }

    public static void setShopMoney(double shopMoney) {
        MainFrame.shopMoney = shopMoney;
    }
}
