package ThinkJava.test6.tets6_4;

import sun.security.tools.keytool.Main;

public class Multadd {
    public Multadd(double a, double b) {

    }

    public static double multadd(double a, double b, double c){
        return a*b+c;
    }

    public  double Multadd(double a,double b) {
        return  Math.sin (a) + (Math.cos(b))/2;

    }

    public static void main(String[] args) {
        double a=Math.PI/4;
        double b=Math.PI/4;
        Multadd multadd = new Multadd(a,b);
        double out = multadd(1,2,5);
        System.out.println(out);
        System.out.println(multadd.multadd(1,2,3));
        System.out.println("==============");
        System.out.println(multadd.Multadd(a,b));


        Multadd multadd1 = new Multadd(a,b){

        };

    }
}
