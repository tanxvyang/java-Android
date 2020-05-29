package day08.Poker;

import day08.Poker.Poker;

import java.util.Arrays;

public class Poker_test {
    public static void main(String[] args) {
        Poker poker = new Poker();

        System.out.println(Arrays.toString(poker.getP()));

        poker.xipai();
        System.out.println(Arrays.toString(poker.getP())); //重新输出
        poker.fapai();
        System.out.println(Arrays.toString(poker.getP()));

    }
}
