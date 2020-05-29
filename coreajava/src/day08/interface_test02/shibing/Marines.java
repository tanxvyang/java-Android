package day08.interface_test02.shibing;


import day08.interface_test02.able.Attachable;
import day08.interface_test02.able.Mobile;

public class Marines implements Attachable, Mobile {

    @Override
    public void attack() {
        System.out.println("机枪兵攻击");

    }

    @Override
    public void Move() {
        System.out.println("机枪兵移动");

    }
}
