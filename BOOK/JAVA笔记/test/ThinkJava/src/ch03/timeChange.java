package ch03;

import java.util.Scanner;

public class timeChange {
    public static void main(String[] args){
        int second, houres,minutes,seconds;
        final int conver=60;
        Scanner in= new Scanner(System.in);
        System.out.println("Pleass input Second:");
        second=in.nextInt();
        seconds=second%conver;
        minutes=(second/conver)%conver;
        houres=second/(conver*conver);
        System.out.printf("%d second = %d hours,%d minutes,%d seconds\n",second,houres,minutes,seconds);
    }
}
