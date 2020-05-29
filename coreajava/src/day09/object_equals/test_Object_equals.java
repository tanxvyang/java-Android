package day09.object_equals;

public class test_Object_equals {
    public static void main(String[] args) throws Exception {
        person p = new person();
        p.setId("1212");
        p.setAge(1);
        p.setName("aaa");
        p.setSex(true);
        Addres addr = new Addres();
        addr.setCaity("nanjng");
        p.setAddr(addr);
        person p2 = (person) p.clone();  //clone()保护子类,


        System.out.println(p.getAddr().getCaity());
        System.out.println(p2.getAge());
        System.out.println(p2.getId());
        System.out.println(p2.getName());
        System.out.println(p2.isSex());
        System.out.println(p2.getAddr().getCaity());

        System.out.println(p == p2);


        // System.out.println(p.equals(p2)); //false
        System.out.println(p.equals(p2));
        System.out.println(p.hashCode());
        System.out.println(p2.hashCode());


        new person();
        System.gc();
        Runtime.getRuntime().gc();


    }
}
