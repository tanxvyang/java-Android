package day07.test6;

public class test07 {

    public static void main(String[] args) {


    A a=new A();  //a类型的对象调用a的方法
    f(a);         //AAAA

    B b=new B();  //b类型的对象调用b的方法
    f(b);            //BBBB

    A ab=new B();  //a类型的对象调用b的方法
    f(ab);         //AAA         //方法的重载  不是重写

}
    public static void f(A a){
        System.out.println("AAAAA");

    }
    public static void f(B a){
        System.out.println("BBB");
    }

}

class A{
}

class B extends A{


}