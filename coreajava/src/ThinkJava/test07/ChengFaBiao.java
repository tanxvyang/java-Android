package ThinkJava.test07;

import java.util.concurrent.ForkJoinPool;

public class ChengFaBiao {
    public static void main(String[] args) {
        for (int j = 1; j < 10; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print(i+"*"+j+"="+ i*j +"  ");

            }
            System.out.println();
        }

    }
}
