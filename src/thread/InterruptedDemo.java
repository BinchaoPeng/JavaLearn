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
        t.interrupt(); //中断，这里只是通知中断，并不一定立即中断
        t.join();   //等t执行完，Waits for this thread to die.位于等待状态的线程要求中断就会抛出异常
        System.out.println(Class.class + " end!");
    }
}
