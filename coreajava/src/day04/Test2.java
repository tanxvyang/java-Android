package day04;

public class Test2 {
    public static void main(String[] args) {
        int n = 100;
        while (true) {
            int a = n / 100;
            int b = n / 10 % 10;
            int c = n % 10;
            if (n == Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)) {
                System.out.println(n);

            }
            n++;
            if (n == 1000) {
                break;
            }
        }
    }
}
