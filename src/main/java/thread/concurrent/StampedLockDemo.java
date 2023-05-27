package thread.concurrent;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock和ReadWriteLock相比，改进之处在于：读的过程中也允许获取写锁后写入！
 * 这样一来，我们读的数据就可能不一致，所以，需要一点额外的代码来判断读的过程中是否有写入，这种读锁是一种[乐观锁]。
 * <p>
 * 乐观锁的意思就是乐观地估计读的过程中大概率不会有写入，因此被称为乐观锁。
 * 反过来，悲观锁则是读的过程中拒绝有写入，也就是写入必须等待。
 * 显然乐观锁的并发效率更高，但一旦有小概率的写入导致读取的数据不一致，需要能检测出来，再读一遍就行。
 * <p>
 * StampedLock提供了乐观读锁，可取代ReadWriteLock以进一步提升并发性能；
 * StampedLock是不可重入锁。
 */
public class StampedLockDemo {
    // 首先我们通过tryOptimisticRead()获取一个乐观读锁，并返回版本号。
    // 接着进行读取，读取完成后，我们通过validate()去验证版本号，
    // 如果在读取过程中没有写入，版本号不变，验证成功，我们就可以放心地继续后续操作。
    // 如果在读取过程中有写入，版本号会发生变化，验证将失败。在失败的时候，我们再通过获取悲观读锁再次读取。
    // 由于写入的概率不高，程序在绝大部分情况下可以通过乐观读锁获取数据，极少数情况下使用悲观读锁获取数据。

    // 别人的总结：StampedLock每次读写会记录时间戳，
    // 尝试乐观读tryOptimisticRead后，通过validate确认是否有更新的写操作时间戳，有则加读锁重读。
    // 而ReadWriteLock 相比StampedLock，少了一个尝试读的过程和记录、比较时间戳的操作

    // 一：乐观锁其实【不上锁】，只【检查版本号】，它的目的是把read-write-lock的read加读锁这一步给去了，因为绝大多数情况下没有写，不需要加读锁。
    // 二：乐观锁其实只是保证从 tryOptimisticRead 到 validate 之间的代码执行的逻辑完整性，也就是我这一次get取到的数据是一个线程中的数据。没有被其他线程污染的。

    // 锁的作用是保证读的数据逻辑正确，不会读到一部分写入前的数据一部分写入后的数据。
    // 使用纠结读到的是不是上一时刻的旧数据，而是保证数据的逻辑正确，没有混合新旧数据

    //假设系统有个共享的int x, int y记录鼠标位置，数据变化：
    //(100, 200), (110, 205), (120, 209), (130, 212)...
    //你读的时候锁能保证读的x, y是一致的，不会出现(t1时刻的x, t2时刻的y)
    //至于你读了之后(x, y)也在继续变化，但你不用关心了因为啥也干不了，总不能一直读不return吧？鼠标位置永远在变化中，要等到什么时候？
    //读了还要处理呢，比如判断x, y是不是在按钮方框内，在就要高亮显示，处理的时候x,y还在继续变化，但那是下一次读-处理的循环要干的事情，跟你这次读的数据无关。
    //锁只保证逻辑一致性，释放锁以后的后续更新跟这次读的结果已经无关了。
    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        // 这个锁是来自 StampedLock stampedLock 这个对象的
        long stamp = stampedLock.writeLock(); // 获取写锁
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp); // 释放写锁
        }
    }

    public double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead(); // 获得一个乐观读锁，【其实就是一个版本号】
        // 注意下面两行代码不是原子操作
        // 假设x,y = (100,200)
        double currentX = x;
        // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
        double currentY = y;
        // 此处已读取到y，如果没有写入，读取是正确的(100,200)
        // 如果有写入，读取是错误的(100,400)
        if (!stampedLock.validate(stamp)) { // 检查乐观读锁后是否有其他写锁发生
            stamp = stampedLock.readLock(); // 获取一个悲观读锁，【就是为了获取同一时刻的数据，以免新旧数据混淆】
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp); // 释放悲观读锁
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
