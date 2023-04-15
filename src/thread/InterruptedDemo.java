package thread;

class MyThread extends Thread {
    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println(this.getClass() + " is running");
        }
    }
}

public class InterruptedDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Class.class + " start!");

        Thread t = new MyThread();
        t.start();
        Thread.sleep(10);
        t.interrupt(); //中断
        t.join();   //等t执行完，Waits for this thread to die.
        System.out.println(Class.class + " end!");
    }
}
