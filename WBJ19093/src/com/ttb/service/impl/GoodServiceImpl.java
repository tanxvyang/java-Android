package com.ttb.service.impl;

import java.util.List;

import com.ttb.dao.GoodDao;
import com.ttb.dao.UserDao;
import com.ttb.dao.impl.GoodDaoImpl;
import com.ttb.dao.impl.UserDaoImpl;
import com.ttb.entity.Good;
import com.ttb.entity.User;
import com.ttb.exception.GoodAlreadyExistException;
import com.ttb.exception.GoodNotFoundException;
import com.ttb.exception.MoneyNotEnoughException;
import com.ttb.exception.StoreNotEnoughException;
import com.ttb.service.GoodService;
import com.ttb.view.MainFrame;

public class GoodServiceImpl implements GoodService {
    GoodDao gd = new GoodDaoImpl();
    UserDao ud = new UserDaoImpl();

    public List<Good> queryGoodsByGoodName(String goodName) {
        return gd.selectGoodsByGoodName(goodName);
    }

    public void buy(User user, Good good, Integer buyNums) throws StoreNotEnoughException, MoneyNotEnoughException {
        //�жϹ��������Ƿ���ڿ������
        if (good.getNums() < buyNums) {
            throw new StoreNotEnoughException("��治��");
        }
        //�����ܼ۸�
        Double totalPrice = buyNums * good.getGoodPrice();
        //�ж��û�������Ƿ��㹻���й������
        if (user.getUsermoney() < totalPrice) {
            throw new MoneyNotEnoughException("�û�����");
        }
        //���û��˻��п۳��ܼ۸񣬲����̵����������ܼ۸�
        MainFrame.setShopMoney(MainFrame.getShopMoney() + totalPrice);
        user.setUsermoney(user.getUsermoney() - totalPrice);
        //���û����Ķ�д�����ݿ�
        ud.updateUser(user);
        //����Ʒ�����Ķ�д�����ݿ�
        good.setNums(good.getNums() - buyNums);
        gd.updateGood(good);
    }

    //	1���ϼ���Ʒ���ϼܵ�ʱ��Ҫ���ǵ��ӵ����п�ȡ���
    public void addGood(Good good) throws GoodAlreadyExistException, MoneyNotEnoughException {
//		1����֤��Ʒ���Ƿ��ظ�
        if (gd.selectGoodByGoodName(good.getGoodName()) != null) {
            throw new GoodAlreadyExistException("��Ʒ�����ظ�");
        }
//		2���жϻ����Ƿ��㹻����
        Double shopMoney = MainFrame.getShopMoney() - good.getGoodPrice() * good.getNums();
        if (shopMoney < 0) {
            throw new MoneyNotEnoughException("�����");
        }
//		3������Ʒ�������
        gd.insertGood(good);
        MainFrame.setShopMoney(shopMoney);
    }

    //	2���¼���Ʒ���˻ػ��
    public void removeGood(Integer gid) throws GoodNotFoundException {
//		1����֤��Ʒ�Ƿ����
        Good good = gd.selectGoodByGid(gid);
        if (good == null) {
            throw new GoodNotFoundException("��Ʒ������");
        }
//		2��ɾ����Ʒ
        gd.deleteGood(gid);
//		3���˿�
        Double shopMoney = MainFrame.getShopMoney() + good.getGoodPrice() * good.getNums();
        MainFrame.setShopMoney(shopMoney);
    }
}
















