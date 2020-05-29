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

    public void init() {
        mainFrame = new JFrame("���Ա� - �����Ʒ");
        goodNameLabel = new JLabel("���ƣ�");
        goodPriceLabel = new JLabel("�۸�");
        goodIntroLabel = new JLabel("��飺");
        numsLabel = new JLabel("����");
        goodNameField = new JTextField();
        goodPriceField = new JTextField();
        numsField = new JTextField();
        goodIntroArea = new JTextArea();
        saveButton = new JButton("ȷ��");
        cancelButton = new JButton("ȡ��");
        gs = new GoodServiceImpl();
    }

    public void build() {
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

    public void addAction() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                List<String> errorMessages = new ArrayList<String>();
                //����֤
                String goodName = goodNameField.getText();
                if (StringUtil.checkString(goodName)) {
                    errorMessages.add("��Ʒ������Ϊ��");
                }

                Double goodPrice = null;
                try {
                    goodPrice = Double.valueOf(goodPriceField.getText());
                    if (goodPrice < 0) {
                        errorMessages.add("��Ʒ�۸���С��0");
                    }
                } catch (Exception e) {
                    errorMessages.add("��Ʒ�۸��ʽ����");
                }

                Integer nums = null;
                try {
                    nums = Integer.valueOf(numsField.getText());
                    if (nums < 0) {
                        errorMessages.add("��Ʒ��������С��0");
                    }
                } catch (Exception e) {
                    errorMessages.add("��Ʒ������ʽ����");
                }

                String goodIntro = goodIntroArea.getText();
                if (StringUtil.checkString(goodIntro)) {
                    errorMessages.add("��Ʒ��鲻��Ϊ��");
                }

                if (errorMessages.size() != 0) {
                    StringBuffer sb = new StringBuffer();
                    for (String string : errorMessages) {
                        sb.append(string).append("\n");
                    }
                    JOptionPane.showMessageDialog(mainFrame, sb.toString(), "�����Ʒ����", JOptionPane.ERROR_MESSAGE);
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

    public void start() {
        init();
        addAction();
        build();
    }

}












