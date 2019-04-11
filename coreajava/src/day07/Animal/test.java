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



        Bird b=new Bird("aaaa","red");
        System.out.println(b.getName());
        System.out.println(b.getColor());
        b.eat();
        b.sing();

        Dog d=new Dog("jingba");
        System.out.println(d.getName());

        System.out.println("--------------------------------");
        d.eat();
    }
}