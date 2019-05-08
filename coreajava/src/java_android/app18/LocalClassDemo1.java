package java_android.app18;
//局部内部类实例
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


interface Logger{
    public void log(String message);
}

public class LocalClassDemo1 {
    //获取当前时间
    String appStartTime = LocalDateTime.now().format(
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

    public Logger getLogger(){
        //LoggerImpl 局部类,位于 getLogger方法中
        class  LoggerImpl implements Logger{
            public void log(String message) {
                System.out.println(appStartTime + " : " + message);
            }
        }
        return new LoggerImpl();//返回一个Logger的接口的一个接口实现
    }

    public static void main(String[] args) {
        LocalClassDemo1 test = new LocalClassDemo1();
        Logger logger = test.getLogger();
        logger.log("Local class example");
    }

}
