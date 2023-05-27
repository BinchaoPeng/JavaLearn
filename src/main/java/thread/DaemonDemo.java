package thread;

/**
 * 守护线程是指为其他线程服务的线程。
 * 在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。
 * ！！！守护线程不能持有任何需要关闭的资源，例如打开文件等，因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失。
 */
public class DaemonDemo {
    static class HelloThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("我在做定时任务，每100ms执行一次！");
            }
        }
    }

    static class TaskThread extends Thread {
        public volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("我在做某个特定任务，每50ms执行一次！");
            }
            System.out.println("我做完了某个特定任务！");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new HelloThread());
        thread.setDaemon(true); // 设置为了守护进程，没有非守护进程时，jvm就退出了
        thread.start();
        Thread thread1 = new TaskThread();

        thread1.start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // t1线程结束后，由于定时任务那个线程t被设置为守护进程，当ti执行结束后不再存在非守护进程了，JVM就进程就结束了
        ((TaskThread) thread1).running = false;

    }
}
