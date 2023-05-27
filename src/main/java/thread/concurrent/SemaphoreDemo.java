package thread.concurrent;

import java.util.UUID;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    // 任意时刻仅允许最多3个线程获取许可:
    final Semaphore semaphore = new Semaphore(3);

    public String access() {

        try {
            // 如果超过了许可数量,其他线程将在此等待:
            semaphore.acquire();
            // TODO:
            Thread.sleep(1000);
            String s = UUID.randomUUID().toString();
            System.out.println(s + " " + semaphore.availablePermits()+" ");
            return s;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreDemo demo = new SemaphoreDemo();
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            new Thread() {
                @Override
                public void run() {
                    demo.access();
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    demo.access();
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    demo.access();
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    demo.access();
                }
            }.start();
        }

    }
}
