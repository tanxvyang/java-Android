package day08.interface_test02.shibing;

import day08.interface_test02.able.Mobile;

import day08.interface_test02.able.Treatable;


public class Doctors implements Mobile, Treatable {

    @Override
    public void Move() {
        System.out.println("护士移动");

    }

    @Override
    public void treatment() {
        System.out.println("治疗");
    }
}
