package day03;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字:");
		//获取用户输入
		int num=sc.nextInt();
		System.out.println("输入数字为："+num);
	  String s=	num%2!=0?"奇数": "偶数";
			System.out.println(s);	
	}
}
