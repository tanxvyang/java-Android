import java.util.Scanner;
/*
*����������ΪӢ����public
*/

 class Convert{

	public static void main(String[] args) {
		double cm;
		int feet,inches,remainder;
		final double CM_PER_INCH = 2.54;
		final int IN_PER_FOOT =12;
		Scanner in = new Scanner(System.in);

		//��ʾ�û�����ֵ����ȡ���ֵ
		System.out.print("Eactly how many cm?");
		cm = in.nextDouble();

		//ת�������
		inches=(int)(cm/CM_PER_INCH);
		feet=inches/IN_PER_FOOT;
		remainder=inches%IN_PER_FOOT;
		System.out.printf("%.2f cm= %d ft,%d in\n",cm,feet,remainder);
	}
}