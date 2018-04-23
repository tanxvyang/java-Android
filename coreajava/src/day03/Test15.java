package day03;

import java.util.Scanner;

public class Test15 {
     public static void main(String[] args) {

		 //实行矩形n*n
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();

		 for (int i = 0; i < n; i++) {

			 for (int j = 0; j < n; j++) {
				 System.out.print("*");
			 }
			 System.out.println();
		 }

		 System.out.println("-----------------------------------");
		 /*//空心矩形*/

		 for (int i = 0; i < n; i++) {

			 for (int j = 0; j < n; j++) {
				 if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
					 System.out.print("*");
				 } else {
					 System.out.print(" ");
				 }
			 }
			 System.out.println();
		 }
		 System.out.println("-----------------------------------------------");


		 //打印实心直角三角形
		 for (int i = 1; i < n; i++) {//控制行

			 for (int j = 1; j < i; j++) {//控制列
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
		 for (int i = 0; i < n; i++) {//控制行

			 for (int j = 0; j < i + 1; j++) {//控制列
				 if (i == 0 || i == n - 1 || j == 0 || j == i) {
					 System.out.print("*");
				 } else {
					 System.out.print(" ");
				 }
			 }
			 System.out.println();//换行
		 }
		 System.out.println("------------------------------------------------");

		 //打印  实心等腰三角形（输入n,打印n行的实心等腰三角形） 空格=n-i-1   *=2*i+1

		 for (int i = 0; i < n; i++) {//控制行

			 for (int j = 0; j < n - i - 1; j++) {//控制列
				 System.out.print(" ");
			 }
			 for (int j = 0; j < 2 * i + 1; j++) {
				 System.out.print("*");
			 }
			 System.out.println();
		 }

		 System.out.println("---------------------------------------------");

		 //打印空心等腰三角形（（输入n,打印n行的实心等腰三角形）
		 for (int i = 0; i < n; i++) {//控制行

			 for (int j = 0; j < n - i - 1; j++) {//控制列
				 System.out.print(" ");
			 }
			 for (int j = 0; j < 2 * i + 1; j++) {
				 if (i == 0 || i == n - 1 || j == 0 || j == 2 * i) {
					 System.out.print("*");
				 } else {
					 System.out.print(" ");
				 }

			 }
			 System.out.println();
		 }


		 System.out.println("---------------------------------------");




		 //打印实心菱形（输入n,打印2n+1行的空心菱形）


		 for (int i = -n; i <= n; i++) {//控制行

			 for (int j =0; j < Math.abs(i); j++) {//控制列
				 System.out.print(" ");
			 }
//			 for (int j = 0; j <(n-Math.abs(i))*2+1; j++) {
////
////					System.out.print("*")
////                    }
			 for (int j = -(n-Math.abs(i)); j <=(n-Math.abs(i)); j++) {

				 System.out.print("*");
			 }



			 System.out.println();
		 }
		 System.out.println("--------------------------------------------------");
		 //打印空心菱形（输入n,打印2n+1行的实心菱形）
		 //空格= Math.abs(i)
		 //*=(n-Math.abs(i))*2+1

		 for (int i = -n; i <= n; i++) {//控制行

			 for (int j =0; j < Math.abs(i); j++) {//控制列
				 System.out.print(" ");
			 }
//			 for (int j = 0; j <(n-Math.abs(i))*2+1; j++) {
////
////					System.out.print("*")
////                    }
			 for (int j = -(n-Math.abs(i)); j <=(n-Math.abs(i)); j++) {
				 if (i == -n || i == n || j ==-(n-Math.abs(i)) || j == (n-Math.abs(i))){
					 System.out.print("*");
				 }else{
					 System.out.print(" ");
				 }

			 }



			 System.out.println();
		 }


		 System.out.println("-------------------------------------");



		 //实心六边形
		 for (int i = -n; i <= n; i++) {//控制行
             if (i==0){
  	                continue;//跳出本次循环
             }
			 for (int j =0; j < Math.abs(i); j++) {//控制列
				 System.out.print(" ");
			 }
//			 for (int j = 0; j <(n-Math.abs(i))*2+1; j++) {
////
////					System.out.print("*")
////                    }
			 for (int j = -(n-Math.abs(i)); j <=(n-Math.abs(i)); j++) {

				 System.out.print("*");
			 }



			 System.out.println();
		 }
	 }
}