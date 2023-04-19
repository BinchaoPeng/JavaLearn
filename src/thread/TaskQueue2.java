package thread;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * task：想在有任务的时候，get task
 * 实际上，会因为锁的存在，导致只有一个方法始终被调用，而另一个只能等他释放锁后再运行
 * 由此，产生了 wait，notify两个方法，用于使线程进入等待状态和被唤醒
 */
public class TaskQueue2 {
    /**
     * wait和notify用于多线程协调运行：
     * 在synchronized内部可以调用wait()使线程进入等待状态；
     * 必须在已获得的锁对象上调用wait()方法；
     * 在synchronized内部可以调用notify()或notifyAll()唤醒其他等待线程；
     * 必须在已获得的锁对象上调用notify()或notifyAll()方法；
     * ！！！已唤醒的线程还需要[重新获得锁后]才能继续执行。
     */
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        System.out.println("[add] taskQueue added s");
        System.out.println("[add] "+Arrays.toString(queue.toArray()));
        // 使用notifyAll()将唤醒所有当前正在this锁等待的线程，而notify()只会唤醒其中一个（具体哪个依赖操作系统，有一定的随机性）。
        // 而且，唤醒不代表就会执行，要等上一个正在执行的释放了锁才可以执行
        this.notify();
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
            try {
                System.out.println("[get] getTask is waiting!");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("[get] taskQueue removed first!");
        return queue.remove();
    }

    public static void main(String[] args) {
        TaskQueue2 taskQueue = new TaskQueue2();
        Thread threadGet = new Thread(() -> {
            while (true){ // 这里也需要while，不然只会执行一次就结束了
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                taskQueue.getTask();
            }
        }
        );
        Thread threadAdd = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String s = String.valueOf((int) (Math.random() * 100));
                taskQueue.addTask(s);
            }
        });
        threadGet.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadAdd.start();

    }
}
