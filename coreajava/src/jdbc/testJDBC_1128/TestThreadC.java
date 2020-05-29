package jdbc.testJDBC_1128;

public class TestThreadC {
    public static void main(String[] args) {

        new Thread() {
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
            }
        }.start();
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
