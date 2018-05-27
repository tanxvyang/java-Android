package day07;

public class Test {
    public static void main(String[] args) {
//        Person p;
//
//        /*
//        * 1.堆里分配空间
//        * 2.属性初始化
//        * 3.调用构造方法*/
//        p=new Person("谭旭洋",true);
//        p.eat("肉");
//        p.sleep();
//
//
//        Person ps =new Person(false);
//        ps.name="张三";
//        ps.sleep();
//        ps.eat("饭");

        Person p =new Person(true);
//        p.age=-67;
//        p.money-=5000;
//        System.out.println(p.name);
        p.setAge(100);
        System.out.println(p.getAge());
      //  System.out.println(p.getName());
        System.out.println(p.getSex());
        p.setName("abc");
        System.out.println(p.getName());

        System.out.println("main p:"+p);

        Person ps=new Person(  false);
        System.out.println("main ps:"+ps);

        ps.setName("aaa");
        System.out.println(ps.getName());
    }
}
