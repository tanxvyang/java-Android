package day02;

public class Test2 {

	public static void main(String[] args) {
	//	int i;//变量的声明
		//System.out.println(i);   报错， 变量必须先初始化再使用
/*
		i=1;
		System.out.println(i);
		{    int j;
				System.out.println(i);
				j=5;
				
		}
		*/
		byte b=1;//int->byte
		
		/*
		 * java内部没有byte和short类型的，
		 * 作int处理
		 * 为了跟c++程序兼容
		 * */
	//	byte b2=b+b;//不能转换Type mismatch: cannot convert from int to byte
		byte b2=(byte)(b+b);//强制类型转换
		
		byte b3=1+1;//JDK会做优化 ，编译时做计算 byte b3=2
		
		int i=128;
		//
		byte b4=(byte)i;
		//System.out.println(b4);//输出为 -128
		
		long l=1; //int->long 自动转换类型    ,正数补0，负数补1
		//0000  0000 0000 0001
		long l2=-1;
		//1111 1111 1111 1111
		
		int max=0x80000000;
		int min=0x7fffffff;
		//System.out.println(min);
		//System.out.println(max);
		
		int i2=010;
		//System.out.println(i2);
		
		long l3=1024*1024*1024*2;//2^31   结果-2147483648 //产生溢出
	//	System.out.println(l3);
		long l4=(long)(1024*1024*1024)*2;
	//	System.out.println(l4);
		
		long l5=1024L*1024*1024*2;  //L
		//System.out.println(l5);
		
		double d=1; //int->double
		System.out.println(d);
		float f=(float)1.2;
        float f1= 1.2f; //以f结尾为float类型
        
//        System.out.println(12.35-12);
//        System.out.println(2.6-2);
//        System.out.println(2.6-2);
        
        double d2=5.0/2;  
        System.out.println(d2);  //输出结果是2.0  
	
	}

}
