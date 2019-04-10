package day07.Singleton;

public class TestSingleton {
    public static void main(String[] args) {
        Singleton s2=Singleton.getS();
        Singleton s3=Singleton.getS();
        Singleton s4=Singleton.getS();
        Singleton s5=Singleton.getS();
        Singleton s6=Singleton.getS();

      //  System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);

    }
}
