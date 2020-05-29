package day10.Innerclass;

public class TestInnerCless1 {
    public static void main(String[] args) {
        // System.out.println(OuterA.i);

        //  OuterA.fun();//直接访问fun
        // OuterA.InnerA innerA=new OuterA.InnerA();//创建外部
        // innerA.f();
        System.out.println("---------------------------");

        OuterA outerA = new OuterA();
        outerA.fun2();
        OuterA.InnerB innerB = outerA.new InnerB();


    }

}

class OuterA {
    private static int i = 1;
    private int j = 2;

    //静态内部类
    public static class InnerA {
        public void f() {
            System.out.println(i);
            // System.out.println(j);//报错,静态的不能访问成员的
        }
    }

    //成员内部类
    public class InnerB {
        private int j = 3;

        public void f() {
            System.out.println(i);
            System.out.println(this.j);
            System.out.println(OuterA.this.j);
        }
    }


    public static void fun() {
        // new InnerA();
        InnerA innerA = new InnerA();
        innerA.f();
    }

    public void fun2() {
        InnerB innerB = new InnerB();
        innerB.f();
    }


}
