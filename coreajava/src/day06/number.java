package day06;


import java.io.IOException;

public class number {

    public static void main(String args[]) throws IOException {
        char ch;
        System.out.println("按1/2/3数字可得大奖");
        System.out.println("按空格后回车可退出循环操作。");
//            Scanner sc =new Scanner(System.in);
//                   int read =sc.nextInt();
        // System.out.println(read);
        // ch=(char) read;
        while ((ch = (char) System.in.read()) != ' ') {
            System.in.skip(2);
            switch (ch) {
                case '1':
                    System.out.println("恭喜你得大奖，一辆汽车！");
                    break;
                case '2':
                    System.out.println("二等奖");
                    break;
                case '3':
                    System.out.println("三等奖");
                    break;
                default:
                    System.out.println("谢谢参与");
                    break;
            }
        }

    }
}


