package day10.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {
    public static void main(String[] args) throws ParseException {
        String startStr = "2017/08/08 00:00:00";
        String endStr = "2017/08/15 00:00:00";


        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // string ->date
        Date startDate = format.parse(startStr);
        Date endDate = format.parse(endStr);
        //date -> Calender
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);


        //当开始日期在结束日期之前循环
        while (startCalendar.before(endCalendar)) {
            //calender ->date
            Date date = startCalendar.getTime();
            //date -> string
            String s = format.format(date);
            System.out.println(s);
            //将startCalender 加一天
            startCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
