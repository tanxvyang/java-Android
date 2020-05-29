package day09.object_clone;

public class test_Object_clone {
    public static void main(String[] args) throws Exception {
        person p = new person();
        p.setId("1212");
        p.setAge(1);
        p.setName("aaa");
        p.setSex(true);
        Addres addr = new Addres();
        addr.setCaity("nanjng");

        p.setAddr(addr);

        // person p2=p.clone();  //clone()保护子类,只能在子类中访问
        //浅克隆
        person p2 = (person) p.clone();  //clone()保护子类,
        System.out.println(p.getAddr().getCaity());
        System.out.println(p2.getAge());
        System.out.println(p2.getId());
        System.out.println(p2.getName());
        System.out.println(p2.isSex());
        System.out.println(p2.getAddr().getCaity());
        System.out.println(p == p2);    // 比较栈中的数据,结果是false,表示这是两个不同的东西
        System.out.println(p.getAddr() == p2.getAddr());


        System.out.println(p);
        System.out.println(p2);
        System.out.println(p.getAddr());
        System.out.println(p2.getAddr());

    }
}
