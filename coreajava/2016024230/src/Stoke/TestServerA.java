package Stoke;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerA {
    public static void main(String[] args) {
        System.out.println("服务器端");

        ServerSocket ss=null;
      //  ServerSocket ss2=null;
        try {
            ss=new ServerSocket(9999);//尽量大于8000,8000以下可能被占用

            int i=1;
            while (true){


                Socket s=null;
                PrintWriter pw=null;
                OutputStream out =null;
                try {
                    System.out.println("111");
                    s=ss.accept();//使线程处于阻塞状态，等待客户端连接   当有客户端连接时，回到就绪状态

                    System.out.println("222");
                    System.out.println(s.getInetAddress().getHostAddress());//打印访问IP
                    out=s.getOutputStream();
                    pw=new PrintWriter(out);
                    pw.println("你是第"+i+"个访问者，你的IP是"+s.getInetAddress());//发送数据
                    pw.flush();

                    i++;
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (pw!=null){
                        pw.close();
                    }
                    if (out!=null){
                        out.close();//习惯上用完就关掉服务,实际上谁开谁关
                    }
                    if (s!=null){
                        s.close();
                    }
                }


            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (ss!=null){
                try{
                    ss.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
