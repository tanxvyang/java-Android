package day07.Person;

import java.sql.SQLOutput;

public class Plain extends Transport {
    @Override
    public void move() {
        System.out.println("飞机飞");
    }
}
