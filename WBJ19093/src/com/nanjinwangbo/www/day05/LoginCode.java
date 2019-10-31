package com.nanjinwangbo.www.day05;

import java.util.Random;
import java.util.Scanner;

public class LoginCode {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc =new Scanner(System.in);
		String output=new String();
		int num;
			String str = "abcdefjhigklmnopqrstuvwxyzBCDEFJHIJKLMNOPQRSTUVWXYZ0123456789";
			for (int i = 0; i <4; i++) {
				 num = r.nextInt(62);
				System.out.print(str.charAt(num)+"\t");
				// output concat(str.charAt(num));
				output.concat(String.valueOf(str.charAt(num)));
			}
	System.out.println(output.length());
			
	}
}
