package day03;

public class Test8 {
    public static void main(String[] args) {


        // ��ϰ����ϰ�� �����2000�굽2500�������
        //�����ܱ�400����  ���ܱ�4�����Ҳ��ܱ�100������


        for (int num = 2000; num < 2500; num++) {

            if ((num % 400 == 0) || (num % 4 == 0 && num % 100 != 0)) {

                //������
                System.out.println(num + "������");
            }
        }
    }
}