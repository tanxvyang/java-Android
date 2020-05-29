package day10.date;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimePowerOff {
    public static void main(String[] args) throws ParseException, InterruptedException, IOException {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("请输入关机时间:yyyy/MM/dd HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        String regex = "\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}";


      /*  String targetStr = sc.nextLine();
        while (!targetStr.matches(regex)){
            System.out.println("时间格式不正确:yyyy/MM/dd HH:mm:ss,请重新输入");
         targetStr = sc.nextLine();
        }


//定义格式
        DateFormat format =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       //转化时间
        Date targetDate = format.parse(targetStr);
        Date now =new Date();
        while (now.after(targetDate)){
            //重新输入格式可能又不正确
            System.out.println("关机时间要在当前时间之后,请重新输入");
            targetStr = sc.nextLine();
        }*/

        String targetStr;

        Date targetDate;
        Date now;
        do {
            do {
                System.out.println("输入关机时间");
                targetStr = sc.nextLine();
            } while (!targetStr.matches(regex));//比较格式
            //转化时间
            targetDate = format.parse(targetStr);
            now = new Date();
        } while (targetDate.before(now));//比较日期

        Thread.sleep(targetDate.getTime() - now.getTime());
//调用命令
        Runtime.getRuntime().exec("shutdown -s -t 0");
    }
}
