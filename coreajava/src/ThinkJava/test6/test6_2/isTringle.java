package ThinkJava.test6.test6_2;


public class isTringle {
    public static void main(String[] args) {
        isTringle tringle = new isTringle();
        System.out.println(tringle.isTriangle(3, 4, 10));
        System.out.println("===========================");
        boolean sanjiao = isDivisible(3, 4);
        System.out.println(sanjiao);

        boolean jvxing = isTriangle(3, 4, 5);

        System.out.println(jvxing);

        System.out.println("=================================");
        isTringle isdiv = new isTringle();
        System.out.println(isDivisible(2, 3));
    }

    public static boolean isDivisible(int n, int m) {
        return n % m == 0;
    }

    public static boolean isTriangle(int x, int y, int z) {
        // if(x+y>z){
        //     return true;
        // }else{
        // return false;
        // }
        return x + y > z;
    }


}
