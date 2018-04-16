package day03;

import java.util.Scanner;

public class Test15 {
     public static void main(String[] args) {
		
    	 //实行矩形n*n
    	 Scanner sc= new Scanner(System.in);
    	 int n=sc.nextInt();
    	 
    	 for(int i=0;i<n;i++){
    		 
    		 for(int j=0;j<n;j++){
    			 System.out.print("*");
    		 }
    		 System.out.println();
    	 }
    	
    	System.out.println("-----------------------------------"); 
    	/*//空心矩形*/ 
    	
        for(int i=0;i<n;i++){
    		 
    		 for(int j=0;j<n;j++){
    			if(i==0||i==n-1||j==0||j==n-1){ 
    				System.out.print("*");
    			}else{
    				System.out.print(" ");
    			}
    		 }
    		 System.out.println();
 }
 System.out.println("-----------------------------------------------");
 
 
 
 //打印实心直角三角形
 for(int i=1;i<n;i++){//控制行
		
		for(int j=1;j<i;j++){//控制列
			System.out.print("*");
			}
		System.out.println();//换行
	}
 
 System.out.println("----------------------------------");

 
 //打印空心直角三角形
 /*for(int i=1;i<n;i++){//控制行
		
		for(int j=1;j<i;j++){//控制列
			if(i==1||j==n){ 
				System.out.print("*");
			}else{
				System.out.print(" ");
			}
			
	}*/
 for(int i=0;i<n;i++){//控制行
		
		for(int j=0;j<i+1;j++){//控制列
		if(i==0||i==n-1||j==0||j==i){
			System.out.print("*");
			} else{
				System.out.print(" ");
			}
		}
		System.out.println();//换行
	}

 }
}