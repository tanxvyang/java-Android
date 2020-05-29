package day03;

import java.util.Scanner;

/* Сѧ��ѧ����ϵͳ
 * 10��
 * ϵͳ�����2λ����+ - * ,/ ����
 * ѧ��������
 * ���ģ�����֣�һ��10��
 * ��������ʹ��int ��*/

public class Test14 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("��" + (i + 1) + "��:");
            //���⣬��������
            int x = (int) (Math.random() * (99 - 10 + 1)) + 10;
            int y = (int) (Math.random() * (99 - 10 + 1)) + 10;
            int z = (int) (Math.random() * (3 - 0 + 1)) + 0;

            int rs = 9999;
            switch (z) {
                case 0://+
                    System.out.println(x + "+" + y + "=?");
                    rs = x + y;
                    break;
                case 1://-
                    System.out.println(x + "-" + y + "=?");
                    rs = x - y;
                    break;
                case 2://*
                    System.out.println(x + "*" + y + "=?");
                    rs = x * y;
                    break;
                case 3://  /
                    System.out.println(x + "/" + y + "=?");
                    rs = x / y;
                    break;

            }


            //����
            int result = sc.nextInt();
            //����

            if (rs == result) {
                System.out.println("��ȷ");
                score += 10;
            } else {
                System.out.println("����");
            }
        }
        System.out.println("�ɼ�Ϊ��" + score + "��");
    }

}
