package Stoke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TestClientB {
    public static void main(String[] args) {
        System.out.println("客户端");
        Scanner sc=new Scanner(System.in);
        Socket s=null;

        PrintWriter pw=null;
        BufferedReader br=null;
        try {


                s=new Socket("127.0.0.1",9999);//192.168.124.1
            System.out.println("输入姓名:");
            String name=sc.nextLine();//输入一行

            pw=new PrintWriter(
                    s.getOutputStream());//输出流
            pw.println(name);
            pw.flush();
            br=new BufferedReader(
                    new InputStreamReader(
                            s.getInputStream()
                    )
            );
            String messager =br.readLine();
            System.out.println(messager);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (s!=null){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

