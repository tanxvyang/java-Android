package day07.Complete;

import java.awt.*;

public class test01 {
    public static void main(String[] args) {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(2, 3);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.add(c2));


        System.out.println(Complex.add(c1, c2));

    }
}
