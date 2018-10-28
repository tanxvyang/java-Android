package Stoke;//多线程

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerC {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端");
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(9999);

            while (true) {
                System.out.println("111");
                Socket s = null;
                try {
                    s = ss.accept();
                    new SocketThread(s).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("222");

            }

    }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (ss!=null){
                try {
                    ss.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
        }
}


class SocketThread extends Thread{
private Socket s;
public SocketThread(Socket s){
    super();
    this.s=s;
}

    @Override
    public void run() {
         BufferedReader br=null;
         PrintWriter pw=null;
        try {

            br=new BufferedReader(
                    new InputStreamReader(
                            s.getInputStream()));//获得输入流
            String name =br.readLine();
            System.out.println(name);

            pw=new PrintWriter(
                    s.getOutputStream()
            );
            if ("aaa".equals(name)){//让aaa等待
                Thread.sleep(10000000);
            }
            pw.println("hello  "+name);
            pw.flush();

        } catch (Exception e) {
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

