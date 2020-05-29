package java_android.app18;

//静态嵌套类
class Outer1 {
    private static int value = 9;

    static class Nested1 {
        int value = 10;   //如果在嵌套类中声明一个成员,和外围类中有相同名称时,将覆盖

        int calculate() {
            System.out.println(Outer1.value);//通过OuterClassName.membername
            return value;
        }

        int getOuterValue() {
            return Outer1.value;//通过OuterClassName.membername可以在外围类中引用

        }
    }
}

public class StaticNestedDemo1 {
    public static void main(String[] args) {
        Outer1.Nested1 nested = new Outer1.Nested1();//采用 OuterClassName.InnerClassName来引用一个嵌套类
        System.out.println(nested.calculate());
        System.out.println(nested.getOuterValue());
    }
}
