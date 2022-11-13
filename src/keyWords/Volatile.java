package keyWords;

public class Volatile {
    // 防止字分裂
    //      字分裂就是：比如long、double都是64位，在32位计算机上，就要分两次更新一个值，可能在中途由于上下文的切换，就导致读值错误
    // 可见性
    //      阻止变量被编译器优化，也就是不会被缓存。变量值发生改变，就会直接写入主存，读的时候也只从主存里面拿
    // 阻止 happens before
    //      java会对指令进行重排序来优化性能，这种重排序就叫 happens before ，先行发生保证
    // volatile操作，也叫 内存栅栏 memory barrier，该操作之前的读写等操作不会被重排序到volatile操作之后，对应其后面的操作也不会排到前面
    // 先行发生保证，会把一些其他非volatile变量也刷新到主存，隐式把这些非volatile变量变成了volatile变量
    // 不建议使用volatile，使用Atomic变量

    public volatile long val;

    public Volatile(long val) {
        this.val = val;
    }

    public void sumsum() {
        for (int i = 0; i < 5; i++) {
            // 自增操作不是一个原子操作
            System.out.println(val++);
        }
    }

    public static void main(String[] args) {
        Volatile aVolatile = new Volatile(0);
        aVolatile.sumsum();

    }
}
