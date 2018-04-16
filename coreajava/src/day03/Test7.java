package day03;

import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
/*		//随机生成一个【-10~10】的随机整数
  int num=(int) (Math.random()*(10-(-10+1))+(-10));
  //
  System.out.println(num);
   /*  //实际开发中主要使用  ，易读，不易出错
 
  if(num>0){
	   //
    	System.out.println("正数");
    }
   if(num<0){
	   System.out.println("负数");   
   }
   if(num==0){
	   System.out.println("0");
   }
   */
  
  
 /* 
  if(num>0){
	  System.out.println("+");
  }else{
	  if(num<0){
		  System.out.println("-");
	  }else{
		  System.out.println("0");
	  }
  }
  */
  
  /*
  if(num>0){
	  System.out.println("+");
  }else if(num<0){
	  System.out.println("-");
  }else{
	  System.out.println("0");
  }
  */
  
		/*
		// 练习：输入一个年 ，判断是否是闰年
		//闰年能被400整除  或（能被4整除且不能被100整除）
		
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入年份：");
		//获取用户输入
		int num=sc.nextInt();
		
		System.out.println("输入的年份是："+num);
		//
		if((num%400==0)
				||(num%4==0&&num%100!=0)){
			//是闰年
			System.out.println(num+"是闰年");
		}else{
			//否则不是闰年
			System.out.println(num+"不是闰年");
		}
  */
		
		/*  输入一个成绩 0-100之间，判断等级
		
		*/
			System.out.println("请输入成绩：");
			Scanner sc=new Scanner(System.in);
			int score=sc.nextInt();
			
			//如果输入分数不合法；分数无效，提示，并停止程序
		 /*   if(score<0||score>100){
				System.out.println("分数无效 ！");
			  //return;      //程序停止
				System.exit(0);//  停止虚拟机
			}
			
			System.out.println(score);
			char lv;
			if(score>=90){
				lv='A';
			}else if(score>=80){
				lv='B';
			}else if(score>=70){
				lv='C';
			}else if(score>=60){
				lv='D';
			}else{
				lv='E';
			}
			System.out.println(lv);
  
  */
			
		//switch（常量表达式）{ 
//			case 常量1：
//		代码1  }	
			char lv;
			
			switch(score/10){
			case 10:
				lv='A';
				break;
			case 9:
				lv='A';
				break;
			case 8:
				lv='B';
				break;
			case 7:
				lv='C';
				break;
			case 6:
				lv='D';
				break;
			default:
				lv='E';
				break;
			}
			
			System.out.println(lv);
	}

}
