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
		//newһ���ɱ䳤�ַ���
		StringBuffer filetext = new StringBuffer();
		//����̨�������
		Scanner sc = new Scanner(System.in);
		System.out.println("�����뽻���룺");
		//������̨������ʱ��ִ��whileѭ��
		while(sc.hasNext()){
			String str = sc.next();
			int i = str.length();
			System.out.println("�����ַ����ĳ���Ϊ:"+i);
			Boolean result = str.matches("[0-9]+");
	      if (i!=4 || result != true){
	    	  System.out.println("�����������������������4Ϊ��������");
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
				System.out.println("�յ����������ر���Ϊ��"+readText);
				
				prw.close();
				bur.close();
				sck.close();
			}else{
				System.out.println("û���ҵ��ļ�");
			}
		       }
			
		}
	}
}
