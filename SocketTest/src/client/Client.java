package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		//new一个可变长字符串
		StringBuffer filetext = new StringBuffer();
		//控制台输入语句
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入交易码：");
		//当控制台有输入时，执行while循环
		while(sc.hasNext()){
			String str = sc.next();
			int i = str.length();
			System.out.println("输入字符串的长度为:"+i);
			Boolean result = str.matches("[0-9]+");
	      if (i!=4 || result != true){
	    	  System.out.println("交易码输入错误，请重新输入4为正整数：");
	       }else{
			String path = str+".txt";
			File file = new File(path);
			if(file.isFile()){
				Scanner scanner = new Scanner(file);
				filetext.append(str);
				while(scanner.hasNext()){
					filetext.append(scanner.nextLine()+"\t");
				}
				scanner.close();
				Socket sck = new Socket("127.0.0.1",7777);
				System.out.println(filetext);
				BufferedReader bur = new BufferedReader(new InputStreamReader(sck.getInputStream()));
				PrintWriter prw = new PrintWriter(sck.getOutputStream());
				prw.println(filetext);
				prw.flush();
				
				String readText = bur.readLine();
				System.out.println("收到服务器返回报文为："+readText);
				
				prw.close();
				bur.close();
				sck.close();
			}else{
				System.out.println("没有找到文件");
			}
		       }
			
		}
	}
}
