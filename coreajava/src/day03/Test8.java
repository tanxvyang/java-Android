package day03;

public class Test8 {
public static void main(String[] args) {

	
	// 练习：练习： 输出从2000年到2500年的闰年 	
			//闰年能被400整除  或（能被4整除且不能被100整除）
			
		
	for (int num=2000;num<2500;num++){	
		
			if((num%400==0)||(num%4==0&&num%100!=0)){
					
				//是闰年
				System.out.println(num+"是闰年");
			}
	}
}
}