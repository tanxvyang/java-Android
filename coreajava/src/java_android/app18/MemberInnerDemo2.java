package java_android.app18;
/*
import com.sun.javafx.print.PrinterImpl;

interface Printer{
    void print(String message);
}
class PrintImpl implements Printer{  //implements 实现类,a实现了b

    @Override
    public void print(String message) {     //构造方法
        System.out.println(message);
    }
}
class SecretPrinterImpl{
    private class Inner implements Printer{
        @Override
        public void print(String message) {
            System.out.println("Inner:"+message);
        }
    }
    public Printer getPrinter(){
        return  new Inner();
    }
}
public class MemberInnerDemo2 {
    public static void main(String[] args) {
        Printer printer = new PrintImpl();
        printer.print("oh");  //传入字符串到 PrinterImpl,向下强制转换
       //      PrinterImpl impl = (PrinterImpl) printer;
        Printer hiddenPrinter =
                (new SecretPrinterImpl()).getPrinter();
        hiddenPrinter.print("oh");
    }
}
*/
interface Printer {
    void print(String message);
}
class PrinterImpl implements Printer {
    public void print(String message) {
        System.out.println(message);
    }
}
class SecretPrinterImpl {
    private class Inner implements Printer {
        public void print(String message) {
            System.out.println("Inner:" + message);
        }
    }
    public Printer getPrinter() {
        return new Inner();
    }
}
public class MemberInnerDemo2 {
    public static void main(String[] args) {
        Printer printer = new PrinterImpl();

        printer.print("oh");
        // downcast to PrinterImpl
        PrinterImpl impl = (PrinterImpl) printer;
        impl.print("hi");

        Printer hiddenPrinter =
                (new SecretPrinterImpl()).getPrinter();
        hiddenPrinter.print("hidden_oh");
        // cannot downcast hiddenPrinter to Outer.Inner
        // because Inner is private
    }
}