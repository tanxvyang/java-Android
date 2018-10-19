package singleton;

public class C {
    private static  C c;
    static {
        c=new C();
    }
    private C(){}

    public static C getC(){
        return c;
    }
}
