package thread.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 和synchronized不同的是，ReentrantLock可以尝试获取锁，超过等待时间后，可以做别的处理
 * 使用ReentrantLock比直接使用synchronized更安全，线程在tryLock()失败的时候不会导致死锁。
 *
 * 使用Condition对象来实现wait和notify的功能。condition.signalAll()以及condition.await();
 * Condition提供的await()、signal()、signalAll()原理和synchronized锁对象的wait()、notify()、notifyAll()是一致的，并且其行为也是一样的
 * await()可以在等待指定时间后，如果还没有被其他线程通过signal()或signalAll()唤醒，可以自己醒来（即做别的逻辑）
 * Condition对象必须从Lock对象获取。
 */
public class ReentrantLockDemo {
    static class Counter {
        private final Lock lock = new ReentrantLock();
        private int count;

        public void add(int n) {
            lock.lock();
            try {
                count += n;
            } finally {
                lock.unlock();
            }
        }

    }
}
