package day08.interface_test;

public class C1 implements I1, I2 {
    //实现

    @Override
    public void f1() {
        System.out.println("c1.f1()");

        //    I1.I=2;     不可改变
    }

    @Override
    public void f2() {
        System.out.println("c1.f2()");
    }


}
