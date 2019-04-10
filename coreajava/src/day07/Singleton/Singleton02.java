package day07.Singleton;

public class Singleton02 {


    private static Singleton02 s;          //可共享,只有一个


    private Singleton02() {

    }


    public static Singleton02 getS() {

        //第一次调用这个方法是创建对象
        if (s==null){
            s=new Singleton02();
        }

        return s;
    }
}