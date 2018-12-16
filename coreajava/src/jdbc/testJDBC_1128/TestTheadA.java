package jdbc.testJDBC_1128;

public class TestTheadA {
    public static void main(String[] args) {

        //main方法是程序的主线程
        MyThread t1=new MyThread();
        //t1是一个线程

      //  t1.run();     //只是调用,不是启动线程,所有只有一个main方法的主线程
        t1.start();     //启动线程

//        MyThread t2=new MyThread();      //启动多个线程,重新new一个方法
//        t2.start();


        for (int i=0;i<100;i++){
            System.out.println("main"+i);
        }
    }

}
class MyThread extends Thread{

    private int n=1;
    @Override
    public void run() {
        for (int i =0;i<100;i++){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run"+i);
        }
        n++;
        System.out.println("n="+n);
    }

    class MyThread2 extends Thread{
        @Override
        public void run() {
            for (int i =0;i<100;i++){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("MyThread2 run"+i);
            }

            }
    }
}
