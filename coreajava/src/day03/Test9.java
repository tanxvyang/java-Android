package day03;

public class Test9 {
public static void main(String[] args) {
//	  int f=1;
	
//	  double sum=0.0;
//		for(double i=1;i<=20;i++){
//		double temp=f*(i+((2.0*i-1.0)/(i*i)));
//		sum+=temp;
//		f=-f;
//		}
//		System.out.println(sum);
	//练习：求12709到45368之间有哪些其各位数之和是5的倍数的正整数
   	/*
	int a,b,c,d,e;
	for(int i=12709;i<=45368;i++){
		a=i/10000;
		b=i/1000%10;
		c=i/100%10;
		d=i/10%10;
		e=i%10;
		int sum=a+b+c+d+e;
		if( sum%5==0){
			System.out.println(i);
		}
	}
	
	
	*/
	
	
	//    练习：记算1+（1+2）+（1+2+3）。。。。的值
	   //1.公式 i*(i+1)/2
	
	
	//2
	/*
	int sum=0 ,temp=0;
	for(int i=1;i<=100;i++){
		
		for(int j=1;j<=i;j++){
			temp+=j;
		}
		sum+=temp;
	}
	System.out.println(sum);
   }
	*/
   /*//3.每一项是前一项加i
	int temp=0;
	int sum=0;
	for(int i=0;i<=100;i++){
		temp+=i;
		sum+=temp;
	}
System.out.println(sum);
}
*/
    int temp=1;
    int sum=0;
	for(int i=0;i<50;i++){
		temp+=i;
		sum+=temp;
		
	}
	System.out.println(sum);
}

}