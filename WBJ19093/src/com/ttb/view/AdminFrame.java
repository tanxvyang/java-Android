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

    public void init() {
        mainFrame = new JFrame("���Ա� - ��̨ҳ��");
        goodNameLabel = new JLabel("��Ʒ����");
        goodNameField = new JTextField();
        searchButton = new JButton("��ѯ");
        addButton = new JButton("���");
        removeButton = new JButton("ɾ��");
        resultTable = new JTable();
        jsp = new JScrollPane(resultTable);
        gs = new GoodServiceImpl();
    }

    public void setFont() {
        mainFrame.setSize(500, 500);
        mainFrame.setLocation(500, 100);
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

    public void addAction() {
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

    public AdminFrame getInstance() {
        return this;
    }

    public void search() {
        String goodName = goodNameField.getText();
        //����֤view�������Ƿ�Ϊ�գ����������Ƿ�Ϸ������ݳ����Ƿ�Ϸ���
//		    �߼��ж�service����Ʒ�����Ƿ��ظ���
        List<Good> goods = gs.queryGoodsByGoodName(goodName);
        //��ͷ��λ��
        String[] columnNames = {"���", "��Ʒ����", "��Ʒ�۸�", "��Ʒ����", "�������"};
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

    public void remove() {
        int row = resultTable.getSelectedRow();
        int col = 0;
        Object value = resultTable.getValueAt(row, col);
        Integer gid = Integer.valueOf(String.valueOf(value));
        try {
            gs.removeGood(gid);
        } catch (GoodNotFoundException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage(), "ɾ����Ʒ����", JOptionPane.ERROR_MESSAGE);
        }
        search();
    }

    public void start() {
        init();
        addAction();
        search();
        setFont();
    }


}
