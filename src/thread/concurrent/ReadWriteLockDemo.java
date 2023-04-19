package thread.concurrent;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用ReadWriteLock可以提高读取效率：
 * ReadWriteLock只允许一个线程写入；
 * ReadWriteLock允许多个线程在没有写入时同时读取；
 * ReadWriteLock适合读多写少的场景。
 *
 * 即读的过程中不允许写，这是一种悲观的读锁。
 */
public class ReadWriteLockDemo {
    // 只允许一个线程写，但在没有写入时允许多个线程读
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    int idx = (int) (Math.random() * 10);
                    System.out.println(getName() + " index:" + idx);
                    readWriteLockDemo.inc(idx);
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(getName() + " " + Arrays.toString(readWriteLockDemo.get()));
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(getName() + " " + Arrays.toString(readWriteLockDemo.get()));
                }
            }
        }.start();
    }
}
