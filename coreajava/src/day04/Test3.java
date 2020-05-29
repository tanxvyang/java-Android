package day04;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(rint(3.4));
        System.out.println(rint(2.1));
        System.out.println(Test3.rint(4.5));
    }

    public static int rint(double number) {
        if (number > 0) {
            return (int) (number + 0.5);
        }
        System.out.println("这个方法只能对正数四舍五入");
        return -1;
    }

}
