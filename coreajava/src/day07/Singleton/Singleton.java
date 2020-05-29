package day07.Singleton;

public class Singleton {


    private static Singleton s;          //可共享,只有一个

    static {                               //只执行一次
        s = new Singleton();
    }


    private Singleton() {

    }


    public static Singleton getS() {
        return s;
    }
}
