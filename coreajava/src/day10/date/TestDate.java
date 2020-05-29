package day10.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws Exception {
        long time = 0;

//long Date Calender String
        //long ->Date
        // 1
        //  Date date = new Date(time);
        //2
        //Date date =new Date();
        //date.setTime(time);  //long转date
        //System.out.println(date);


        //Date ->long
        // Date date1 =new Date();

        //  long time1=date1.getTime();  //date转long
        //  System.out.println(time1);
        //  System.out.println(System.currentTimeMillis());


        //Date ->String        //dataformat
        // DateFormat format= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E");
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        //        String s=format.format(date);
        //        System.out.println(s);

        //String ->>Date

        String s = "2017/08/08 15:23:40";
        Date date1 = format.parse(s);  //将字符串传入,字符串转日期
        System.out.println(date1);


        // Date ->> Calender

        Calendar cal = Calendar.getInstance();//获得当前时间
        cal.setTime(date1);
        System.out.println(cal);


        // Calender ->> Date

        Calendar cal1 = Calendar.getInstance();
        Date date = cal1.getTime();  //获得时间
        System.out.println(date);
    }
}
