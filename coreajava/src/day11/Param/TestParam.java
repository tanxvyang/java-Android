package day11.Param;

public class TestParam {
    public static void main(String... args) {
       System.out.println("Hello word");

        //可以传任意长度的参数,包括无惨

        // String[]  s = {"zAAA","asdf","asfda"};
        // f(s);
        // System.out.println("----------------");
        // f("abc");
        // System.out.println("--------------------");
        // f("aaa","Avvvv","afdasfasf");
        // System.out.println("--------------------");
        // f();

    }
    public static void f(String... s){//可变参数只能作为最后一个参数也
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);

        }
    }
    public static  void f(String str,String... s ){

    }
}
