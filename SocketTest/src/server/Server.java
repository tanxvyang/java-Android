package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		Socket socket = null;
		ServerSocket serverSocket = new ServerSocket(7777);
		
		while(true){
			System.out.println("服务器正在监听");
			socket = serverSocket.accept();
			BufferedReader bufr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			String str = bufr.readLine();
			System.out.println(str);
			String txcode = str.substring(0, 4);
			System.out.println(txcode);
			String path = txcode+".txt";
			File file = new File(path);
			Scanner sc = new Scanner(file);
			StringBuffer strb = new StringBuffer();
			while(sc.hasNext()){
				strb.append(sc.nextLine());
			}
			System.out.println(strb);
			printWriter.println(strb);
			printWriter.flush();
		}
		
	}
}
