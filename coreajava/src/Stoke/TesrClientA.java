package Stoke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TesrClientA {
    public static void main(String[] args) {
        System.out.println("客户端");
        Socket s=null;
        InputStream in=null;

        BufferedReader br=null; //接收流读一行
        try {
            //和服务器连接
            s=new Socket("127.0.0.1",12345);
            in=s.getInputStream();
            br=new BufferedReader(
                      new InputStreamReader(in));
            String message=br.readLine();//读取传回消息，使当前线程阻塞  当数据读完了，回到就绪状态
            System.out.println(message);

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (s!=null){
                if (br!=null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in!=null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
