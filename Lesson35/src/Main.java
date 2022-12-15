import java.util.Random;

public class Main{
    public static void main(String[] args) {

        /*MyThread myThread = new MyThread();
        MyThread1 myThread1 = new MyThread1(1000);
        //myThread1.setDaemon(true);
        myThread1.start();
        //myThread.setDaemon(true);
        myThread.start();
        //myThread.setPriority(Thread.MIN_PRIORITY);

        int i = 1000;
        while (i > 0) {
            System.out.print('-');
            i--;
        }*/

        int o = (new Random()).nextInt(10);
        MyThread1 myThread1 = new MyThread1(o);

        int u = (new Random()).nextInt(10);
        MyThread1 myThread2 = new MyThread1(u);

        myThread1.start();
        myThread2.start();

        while (true) {
            try {
                myThread2.join(10000);

            } catch (InterruptedException e) {

            }
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.print('+');
        }
    }
}

class MyThread1 extends Thread{
    private int value;

    public MyThread1(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        while (value >= 0){
            System.out.println("The thread " + Thread.currentThread().getName() + " started whith " + this.value);
            while (this.value >= 0){
                System.out.println("From " + Thread.currentThread().getName() + " value = " + value);
                value -= 1;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("The thread " + Thread.currentThread().getName() + " has finished");
    }
class MyThread3 implements Runnable{

    @Override
    public void run() {

    }
}
}
