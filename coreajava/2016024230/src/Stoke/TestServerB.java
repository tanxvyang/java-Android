package Stoke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerB {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端");
        ServerSocket ss=null;
        try {
            ss = new ServerSocket(9999);

            while (true) {
                Socket s = null;

                    BufferedReader br=null;
                PrintWriter pw=null;
                    try {
                        s=ss.accept();
                        br=new BufferedReader(
                                new InputStreamReader(
                                        s.getInputStream()));//获得输入流
                        String name =br.readLine();
                        System.out.println(name);

                        pw=new PrintWriter(
                                s.getOutputStream()
                        );
                        pw.println("hello  "+name);
                        pw.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (s != null) {
                        s.close();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
