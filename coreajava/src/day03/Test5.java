package day03;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("����������:");
        //��ȡ�û�����
        int num = sc.nextInt();
        System.out.println("��������Ϊ��" + num);
        String s = num % 2 != 0 ? "����" : "ż��";
        System.out.println(s);
    }
}
