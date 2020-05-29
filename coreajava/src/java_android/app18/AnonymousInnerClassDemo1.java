package java_android.app18;

import javax.xml.transform.Source;

interface Printable {
    void print(String message);
}

public class AnonymousInnerClassDemo1 {
    public static void main(String[] args) {
        Printable printer = new Printable() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        }; //语句结束,加;
        printer.print("Beach Music");
    }
}
