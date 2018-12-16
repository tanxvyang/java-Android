package ch03;

import java.util.Scanner;

public class DegreesToFahrenheit {
    public static void main(String[] args){
        double C;
        double F;
        final double feet=9.0/5.0;
        final int add=32;
        Scanner in= new Scanner(System.in);
        System.out.println("Pleass input degrees:");
        C=in.nextDouble();
        F=(double)((C*feet)+add);
        System.out.printf("%.1f C = %.1f F\n",C,F);
    }
}
