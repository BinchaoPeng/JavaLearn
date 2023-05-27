package mutiThread;

import java.util.concurrent.Callable;

public class Runable_ implements Runnable {

    public static void main(String[] args) {
//        new Runnable(){
//            @Override
//            public void run() {
//                return;
//            }
//        };
        Thread thread1 = new Thread(new Runable_());
        Thread thread2 = new Thread(new Runable_());
        Thread thread3 = new Thread(new Runable_());
        thread1.start();
        thread2.start();
        thread3.start();

    }

    public void get() {
        Thread thread = Thread.currentThread();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " RUNing!");
    }
}


class Callable_ implements Callable {
    static {}
    static {}
    static {}
    public static void main(String[] args) {
        Callable_ callable = new Callable_();
        Thread thread = new Thread();
        thread.start();
    }

    public void get() {
        Thread thread = Thread.currentThread();
    }

    @Override
    public Object call() throws Exception {
        System.out.println("call");
        return null;
    }
}

class Thread_ extends Thread {
    public static volatile int shareValue = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread_ thread_1 = new Thread_("T1");
        Thread_ thread_2 = new Thread_("T2");
        Thread_ thread_3 = new Thread_("T3");
        Thread_ thread_4 = new Thread_("T4");
        System.out.println(thread_1.getState().name());

        thread_1.start();


        thread_2.start();
        thread_3.start();
        thread_4.start();
        thread_1.interrupt();

        System.out.println(thread_1.getState().name());
        thread_1.notify();
        System.out.println(thread_1.getState().name());
    }

    public Thread_() {
        super();
    }

    public Thread_(String name) {
        super(name);
    }

    public void get() {
        this.getId();
    }


    @Override
    public synchronized void start() {
        super.start();
        System.out.println("1-start[" + this.getId() + "-" + this.getName() + "-" + this.getClass() + "]-(" + this.getState().name() + ")!");
        System.out.println("1.1-start[" + this.getId() + "-" + shareValue + "]");
    }

    @Override
    public void run() {
        super.run();
        shareValue++;
        System.out.println("2-run[" + this.getId() + "-" + this.getName() + "-" + this.getClass() + "]-(" + this.getState().name() + ")!");
        System.out.println("2.1-run[" + this.getId() + "-" + shareValue + "]");
    }
}