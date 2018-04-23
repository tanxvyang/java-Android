package day04;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = (int) (Math.random() * (1000 - 0 + 1) + 10);
        System.out.println("猜数字游戏开始啦！请输入一个数字：");
//        for (int i=0;i<10;i++){
//        if(x<sc.nextInt()){
//            System.out.println("太小了，再大一点");
//        }
//        if(x>sc.nextInt()){
//            System.out.println("太大了，小一点");
//        }
//        if (x==sc.nextInt()){
//            System.out.println("太棒了，猜对了");
//        }

        //}
        //System.out.println(x);
        int i = 0;
        do {
            System.out.println("猜数字游戏开始啦！请输入一个数字：" + "还有" + (10 - i) + "次机会");
            int guessNumber = sc.nextInt();
            if (guessNumber < x) {
                System.out.println("太小了，再大一点");
            }
            if (guessNumber > x) {
                System.out.println("太大了，小一点");
            }
            if (guessNumber == x) {
                System.out.println("太棒了，猜对了");
                System.out.println("游戏结束！");
                //break;
                System.exit(0);  //虚拟机退出
                //return;

            }
            i++;
        } while (i < 10);
      if (i>=10){
          System.out.println("你就是个垃圾，下次再来吧！");
      }

    }

}


