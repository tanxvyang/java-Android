package day07.Animal;

public class test {
    public static void main(String[] args) {
        // /*
        // * 1.堆中分配父类的空间
        // * 2.堆中分配子类空间
        // * 3.属性初始化
        // * 4.调用构造方法,其中构造方法的第一行是调用父类的构造方法
        // *
        // * */


        Animal b = new Bird("aaa", "red");
        //Bird b=new Bird("aaaa","red");
        System.out.println(b.getName());
        System.out.println(((Bird) b).getColor());
        b.eat();
        //如果b是鸟类型才可以转换成鸟

        if (b instanceof Bird) {

            ((Bird) b).sing();
        }

        Animal d = new Dog("qqq");
        // Dog d=new Dog("jingba");
        System.out.println(d.getName());
        // ((Bird) d).sing();    //java.lang.ClassCastException  报错

        if (d instanceof Bird) {

            ((Bird) d).sing();
        }

        System.out.println("--------------------------------");
        d.eat();
        System.out.println("----------------------------------");

        Bird c = new Bird("aaa", "erer");
        c.eat();
        Dog e = new Dog("bbbb");
        e.eat();
        Animal cc = new Bird("ererer", "re");
        cc.eat();


    }
}