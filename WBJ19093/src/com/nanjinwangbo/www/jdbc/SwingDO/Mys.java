// package jdbc.util;
//
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
//
//
// public class Mys {
// 	JFrame jf;
// 	JTextField inputSQL;
// 	JButton execute;
// 	JButton empty;
// 	JTextArea text;
// 	threadtest thread;
//
// 	public void init(){
// 		 jf = new JFrame();
// 		 inputSQL = new JTextField();
// 		 execute = new JButton("执行");
// 		 empty= new JButton("清空");
// 		 text = new JTextArea();
// 		 thread = new threadtest();
//
// 	}
// 	public void bulid(){
// 		Font font =new Font("Diaog",Font.PLAIN , 30);
// 		inputSQL.setBounds(20,50,400, 100);
// 		inputSQL.setFont(font);
//
// 		execute.setBounds(20, 150, 100, 50);
// 		execute.setFont(font);
//
// 		empty.setBounds(340, 150, 100, 50);
// 		empty.setFont(font);
// 		text.setBounds(20, 200, 300, 300);
//
// 		jf.add(inputSQL);
// 		jf.add(execute);
// 		jf.add(empty);
// 		jf.add(text);
// 		jf.setSize(500, 800);
// 		jf.setLocation(500, 100);
// 		jf.setLayout(null);
// 		jf.setTitle("txySql");
// 		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// 		jf.setVisible(true);
// 	}
// 	public void addAction(){
//
// 		execute.addActionListener(new ActionListener() {
//
// 			public void actionPerformed(ActionEvent e) {
//
// 				startThread();
// 				//thread.sql = inputSQL.getText();
//
//
// 			}
// 		});
//
//
//
// 		 empty.addActionListener(new ActionListener() {
//
// 			public void actionPerformed(ActionEvent e) {
// 				overThread();
// 			}
// 		});
// 	}
//
// 	public void  startWindows(){
// 		init();
// 		bulid();
// 		addAction();
// 	}
//
//
//
// 	public  void startThread(){
// 		// thread.stopped = false;
// 		// thread.start();
// 		//
// 		thread.start();
// 		thread.text = text;
// 		thread.inputSQL = inputSQL;
// 	}
// 	public void overThread(){
//
// 			// thread.stopped = true;
//
//
// 	}
//
// 		public static void main(String[] args) {
// 			Mys my = new Mys();
//
// 			my.startWindows();
// 			//threadtest threadtest = new threadtest();
// 			//threadtest.start();
//
//
// 		}
//
//
//
//
// 	}
//
//
