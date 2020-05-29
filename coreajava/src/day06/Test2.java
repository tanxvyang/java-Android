package day06;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        a[3] = 5;

        int num = 0;//
        int i = 3;
//        Scanner sc=new Scanner(System.in);
//        num=sc.nextInt();
        while (i != -1 && num < a[i]) {
            a[i + 1] = a[i];
            i--;

        }
        a[i + 1] = num;
        System.out.println(Arrays.toString(a));

    }
}
