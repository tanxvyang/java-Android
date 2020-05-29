package day05;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(f(5));
    }
    //9！=9*8！
    //1！=1
    //一个数的阶乘=这个数*比他小一的数

    public static int f(int num) {
        int x;
        if (num == 1) {
            return 1;
        } else {
            x = num * f(num - 1);
        }
        return x;
    }
}
