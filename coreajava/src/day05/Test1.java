package day05;

public class Test1 {
    public static void main(String[] args) {
//        int num = f(6);
//        System.out.println(num);
//        for (int i=0; i<20;i++){
//            System.out.println(f(i));
//        }

        for (int i = 1; i <= 20; i++) {
            System.out.println(g(i));
        }

    }


    public static int f(int n) {
        int n1 = 1;
        int n2 = 2;
        int ni = 1;
        for (int i = 3; i <= n; i++) {
            ni = n1 + n2;
            n1 = n2;
            n2 = ni;
        }
        return ni;

    }


    //递归调用
    public static int g(int n) {
        int ni;
        if (n == 1 || n == 2) {
            ni = 1;
        } else {
            ni = g(n - 1) + g(n - 2);
        }
        return ni;
    }

}
