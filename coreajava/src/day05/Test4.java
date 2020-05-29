package day05;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"MySQL", "CoreJava", "JavaWeb", "Spring", "Script", "MyBatis"};
        int[] scores = new int[names.length];
        int sum = 0;
        for (int i = 0; i < names.length; i++) {
            System.out.println("输入课程" + names[i] + "的成绩:");
            scores[i] = sc.nextInt();
            sum += scores[i];
        }
        System.out.println("sum=" + sum);
        System.out.println("avg=" + sum / names.length);
    }
}
