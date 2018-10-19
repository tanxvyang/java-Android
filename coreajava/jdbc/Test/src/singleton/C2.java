package singleton;

public class C2 {
    private static C2 c;

    private C2(){}

    public static C2 getC2(){
        if (c==null){
            c=new C2();
        }

        return c;
    }
}
