package day03;

import java.util.Scanner;

/*           x*x-1    x<-1
   	��ϰ��  y=  |x|+1     -1<=x<=1 
   	         3x+3     x>1
   	        */

public class Test12 {

    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);
        System.out.println("����������:");
        //��ȡ�û�����
        int x = sc.nextInt();
        System.out.println("x=" + x);
	/*	int y;
	 * if(x<-1){
			y=x*x-1 ;
			//System.out.println( "y="+y);
		}else if(x>1){
			y=3*x+3  ;
			//System.out.println("y="+y);
		}else{
			y=Math.abs(x)+1; //����ֵ���� Math.abs(x)
			//System.out.println("y="+y);
		}
		
		*/
        int y = 0;//��֮ǰҪ���壬���򱨴�,��ʵ���ϲ����������Ľ��������
        //Interger y=null;   //�����Ľ�����⣬����ѧϰ����
        if (x < -1) {
            y = x * x - 1;
            //System.out.println( "y="+y);
        }
        if (x > 1) {
            y = 3 * x + 3;
            //System.out.println("y="+y);
        }
        if (x <= -1 && x >= 1) {
            y = Math.abs(x) + 1; //����ֵ���� Math.abs(x)
            //System.out.println("y="+y);
        }
        System.out.println(y); //ȫif���ʱ �ᱨ��

    }


}
