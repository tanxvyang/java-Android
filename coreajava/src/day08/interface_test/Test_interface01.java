package day08.interface_test;

public class Test_interface01 {
    public static void main(String[] args) {
        System.out.println(I1.I);
//    I1.I=2;     不可改变
        I1 i1=new C1();   //接口不能new ,但可以new他的
        i1.f1();

        if (i1 instanceof I2){
            ((I2) i1).f2();
        }
    }
}
