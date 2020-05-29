package day07.Complete;


public class Complex {
    private double a;
    private double b;
    //public static final  修饰静态常量
    public static final char I = 'i';

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }


    public static Complex add(Complex c1, Complex c2) {
        return new Complex(c1.a + c2.a, c1.b + c2.b);

    }

    public Complex add(Complex c) {
        return add(this, c);

    }


    @Override
    public String toString() {
        return a + "+" + b + I;
    }


    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public static char getI() {
        return I;
    }

    public void setB(double b) {
        this.b = b;
    }
}
