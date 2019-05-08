package day10.Innerclass;

import sun.security.util.AuthResources_it;

public class TestInnerClass2 {
    public static void main(String[] args) {
        OuterB outerB=new OuterB();
        outerB.f1(2);
    }
}



class OuterB{
    private  int i=1;
    public void f1(final int j){
        //局部内部类
       final int k=3;
        class InnerC{
            public void innerF(){
                System.out.println(i);
                System.out.println(j);//error :  改成final int j
                System.out.println(k);//error :  改成final int k=3
            }
        }
        InnerC innerC=new InnerC();
        innerC.innerF();//只能在类中使用
    }
}
