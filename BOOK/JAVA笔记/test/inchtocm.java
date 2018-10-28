import java.util.Scanner;
/*
*将厘米数化为英寸数public
*/

 class Convert{

	public static void main(String[] args) {
		double cm;
		int feet,inches,remainder;
		final double CM_PER_INCH = 2.54;
		final int IN_PER_FOOT =12;
		Scanner in = new Scanner(System.in);

		//提示用户输入值并读取这个值
		System.out.print("Eactly how many cm?");
		cm = in.nextDouble();

		//转换并输出
		inches=(int)(cm/CM_PER_INCH);
		feet=inches/IN_PER_FOOT;
		remainder=inches%IN_PER_FOOT;
		System.out.printf("%.2f cm= %d ft,%d in\n",cm,feet,remainder);
	}
}