package day07.IntStaic;

public class test {
    public static void main(String[] args) {
        intStack s1=new intStack(3);
        s1.push(1);

        s1.push(2);
        s1.push(3);
       // s1.push(4);
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
    }
}
