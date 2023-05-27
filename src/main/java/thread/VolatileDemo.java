package thread;

// 放在 public class VolatileDemo 内部 就不能在 main方法 中 new
// 用到了 匿名类、静态内部类 的知识点
// 一个依附外部类，生成对象时首先需要一个外部类实例
// 一个属于是独立的类，可以独立创建实例，而且可以访问外部类的静态字段和方法
class HelloThread extends Thread {
    // 定义线程间共享变量
    /**
     * 因此，volatile关键字的目的是告诉虚拟机：
     * 每次访问变量时，总是获取主内存的最新值；
     * 每次修改变量后，立刻回写到主内存。
     * volatile关键字解决的是可见性问题：当一个线程修改了某个共享变量的值，其他线程能够立刻看到修改后的值。
     */
    public volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getClass() + " hello!");
        }
        System.out.println("volatile running comes " + running);
    }
}

public class VolatileDemo {


    public static void main(String[] args) {
        Thread helloThread = new HelloThread();
        helloThread.start();
        try {
            Thread.sleep(10);
            ((HelloThread) helloThread).running = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
