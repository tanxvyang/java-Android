package day03;

import java.util.Scanner;

/*           x*x-1    x<-1
   	练习：  y=  |x|+1     -1<=x<=1 
   	         3x+3     x>1
   	        */

public class Test12 {

	public static void main(String[] args) {
	 //
	 Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字:");
		//获取用户输入
		int x=sc.nextInt();
		System.out.println("x="+x);
	/*	int y;
	 * if(x<-1){
			y=x*x-1 ;
			//System.out.println( "y="+y);
		}else if(x>1){
			y=3*x+3  ;
			//System.out.println("y="+y);
		}else{
			y=Math.abs(x)+1; //绝对值函数 Math.abs(x)
			//System.out.println("y="+y);
		}
		
		*/
		int y=0;//在之前要定义，否则报错,但实际上并不是真正的解决了问题
		//Interger y=null;   //真正的解决问题，后续学习解释
		if(x<-1){
			y=x*x-1 ;
			//System.out.println( "y="+y);
		}
		if(x>1){
			y=3*x+3  ;
			//System.out.println("y="+y);
		}
       if(x<=-1&&x>=1) {
			y=Math.abs(x)+1; //绝对值函数 Math.abs(x)
			//System.out.println("y="+y);
		}
		System.out.println(y); //全if语句时 会报错
	 
	}

	
}
