package day03;

import java.util.Scanner;

/* 小学数学考试系统
 * 10题
 * 系统随机出2位数的+ - * ,/ 运算
 * 学生给出答案
 * 批改，并打分，一题10分
 * 所有数据使用int 型*/

public class Test14 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int	score=0;
		
		for(int i=0;i<10;i++){
			System.out.println("第"+(i+1)+"题:");
		//出题，并保存结果
			  int x = (int)(Math.random()*(99-10+1))+10;
				int y = (int)(Math.random()*(99-10+1))+10;
				int z=(int)(Math.random()*(3-0+1))+0;
			
				int rs=9999;
				switch(z){
				case 0://+
					System.out.println(x+"+"+y+"=?");
					 rs=x+y;
					break;
					case 1://-
						System.out.println(x+"-"+y+"=?");
						rs=x-y;
						break;
					case 2://*
						System.out.println(x+"*"+y+"=?");
						rs=x*y;
						break;
					case 3://  /
						System.out.println(x+"/"+y+"=?");
						rs=x/y;
						break;
					
				}
				
				
				//答题
				int result =sc.nextInt();
				//批改
			
				if(rs==result){
					System.out.println("正确");
				    score+=10;
				}else{
					System.out.println("错误");
				}
		}
		System.out.println("成绩为："+score+"分");
	}

}
