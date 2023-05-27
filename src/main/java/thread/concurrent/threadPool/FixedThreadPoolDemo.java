package thread.concurrent.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        // 线程池固定包含3个线程
        ExecutorService service = Executors.newFixedThreadPool(3);


        for (int i = 0; i < 10; i++) {
            service.submit(new Task(i));
        }
        service.shutdown(); // 关闭线程池
    }


    private static class Task implements Runnable {
        private String name;

        public Task(int i) {
            this.name = "" + i;
        }

        @Override
        public void run() {
            try {
                long time = (long) (Math.random() * 3000 + 1000);
                Thread.sleep(time);
                System.out.println("Task_" + this.name + " " + time + "ms");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
