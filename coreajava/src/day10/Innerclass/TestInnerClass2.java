package day10.Innerclass;

import java.sql.SQLOutput;

//
// public class TestInnerClass2 {
//     public static void main(String[] args) {
//         OuterB outerB=new OuterB();
//         outerB.f1(2);
//     }
// }
//
//
//
// class OuterB{
//     private  int i=1;
//     public void f1(final int j){
//         //局部内部类
//        final int k=3;
//         class InnerC{
//             public void innerF(){
//                 System.out.println(i);
//                 System.out.println(j);//error :  改成final int j
//                 System.out.println(k);//error :  改成final int k=3
//             }
//         }
//         InnerC innerC=new InnerC();
//         innerC.innerF();//只能在类中使用
//     }
// }
public class TestInnerClass2 {
    public static void main(String[] args) {
        OuterB outerB = new OuterB();
        // outerB.f1(2);
        MyInterface myInterface = outerB.f1(2);
        //-----------------------------------------
        //   myInterface.innerF();
        outerB.f4(new MyInterface() {
            @Override
            public void innerF() {
                System.out.println("1111111");
                System.out.println("2222222");
                System.out.println("3333333");
            }
        });
        System.out.println("++++++++++++++++++++++++++++++ ");
        outerB.f4(new MyInterface() {
            @Override
            public void innerF() {
                System.out.println("99999999");
                System.out.println("99999999");
                System.out.println("99999999");
            }
        });


    }
}

interface MyInterface {
    public void innerF();
}

class OuterB {
    private int i = 1;

    public MyInterface f1(final int j) {
        //局部内部类
        final int k = 3;
        class InnerC implements MyInterface {
            public void innerF() {
                System.out.println(i);
                System.out.println(j);//error :  改成final int j
                System.out.println(k);//error :  改成final int k=3
            }
        }
        InnerC innerC = new InnerC();
        //innerC.innerF();//只能在类中使用
        return innerC;
    }


    //匿名内部类
    public MyInterface f2() {
        final int j = 2;
        return new MyInterface() {   //匿名内部类

            public void innerF() {
                System.out.println(i);
                System.out.println(j);

            }
        };
    }

    public void f4(MyInterface inter) {
        System.out.println("aaaaaaaaaa");
        System.out.println("bbbbbbbbbb");
        System.out.println("ccccccccccc");

        inter.innerF();

        System.out.println("ddddddddddddd");
        System.out.println("fffffffffffff");


    }
}


//
// public MyInterFace f1(){
//     final int j=2;
//     return new MyInterface(){
//         public void innerF(){
//             System.out.println(i);
//             System.out.println(j);
//         }
//     };
// }