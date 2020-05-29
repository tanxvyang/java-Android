package java_android.app18;

abstract class Printable2 {
    void print(String message) {
    }
}

public class AnonymousInnerClassDemo2 {
    public static void main(String[] args) {
        Printable2 printer = new Printable2() {
            @Override
            void print(String message) {
                System.out.println(message);
            }
        };
        printer.print("abstract test");
    }
}
