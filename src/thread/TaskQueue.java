package thread;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * task：想在有任务的时候，get task
 * 实际上，会因为锁的存在，导致只有一个方法始终被调用，而另一个只能等他释放锁后再运行
 * 由此，产生了 wait，notify两个方法，用于使线程进入等待状态和被唤醒
 */
public class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        System.out.println("taskQueue added s");
        System.out.println(Arrays.toString(queue.toArray()));
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {

        }
        System.out.println("taskQueue removed first!");
        return queue.remove();
    }

    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue();
        Thread threadGet = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            taskQueue.getTask();
        }
        );
        Thread threadAdd = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String s = String.valueOf((int) (Math.random() * 100));
                taskQueue.addTask(s);
            }
        });
        threadAdd.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadGet.start();

    }
}
