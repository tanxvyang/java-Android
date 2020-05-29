package jdbc.testJDBC_1128;

public class TestTheadB {
    public static void main(String[] args) {

        //main方法是程序的主线程
        MyRunable r1 = new MyRunable();
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r1);
        t2.start();


        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main" + i);
        }

    }
}

class MyRunable implements Runnable {
    private int n = 1;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run" + i);
        }
        n++;
        System.out.println("n=" + n);
    }
}
