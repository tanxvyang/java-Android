package com.xxx.corejava.day02; //package 表示包  提供java类的分类，相当于目录
                 // import day02.*;
 import day02.Test02;  //同包或者java.lang包里的类可以不用import
                   //通过 import 可以不用 加包名。类名    可以有多行，可以使用通配符*
public class Hello{ //类名一定要和文件名相同，包括大小写。
	public static void main(java.lang.String[] args){
		System.out.println("Hellow , World!");
		int i=1;
		System.out.println(i);
		System.out.println(Test.i);
		System.out.println(day02.Test02.i);//不同目录 ，包下的话，要把包名加进去
		System.out.println(Test02.i);
		System.out.println(Test02.i);
		System.out.println(Test02.i);
		System.out.println(Test02.i);
		System.out.println(Math.PI);
		}
}

