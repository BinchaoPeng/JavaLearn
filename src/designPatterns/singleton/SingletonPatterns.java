package designPatterns.singleton;

/**
 * 单例模式
 * 就是一个类全局只有一个实例，不可继承，也不可实例化
 * 唯一的访问形式：使用静态方法访问
 */
public class SingletonPatterns {
    /**
     * 懒汉式，线程不安全
     * 就是实现了延迟加载（lazy loading），不浪费
     * 最基本的实现方式，
     * 不支持多线程，也就是，线程不安全
     * 没有加同步锁 synchronized
     */

    private static SingletonPatterns singleton;

    private SingletonPatterns() {
        System.out.println("private construction");
    }


    public static SingletonPatterns getInstance() {
        if (singleton == null) {
            singleton = new SingletonPatterns();
        }
        return singleton;
    }

    public void fun(String msg) {
        System.out.println("your msg: " + msg);

    }


}
