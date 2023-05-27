package designPatterns.singleton;

/**
 * 单例模式
 * 就是一个类全局只有一个实例，不可继承，也不可实例化
 * 唯一的访问形式：使用静态方法访问
 */
public class SingletonPatterns1 {
    /**
     * 懒汉式，线程安全
     * 最基本的实现方式，
     * Lazy 初始化：在判断条件成立的时候再进行加工，这样不浪费性能
     * 缺点：因为加了锁，效率低，
     * 优点：第一次用的时候，才会初始化
     */

    private static SingletonPatterns1 singleton;  // 这里需要设置 static

    private SingletonPatterns1() {
        System.out.println("private construction");
    }


    public synchronized static SingletonPatterns1 getInstance() {
        if (singleton == null) {
            // 这样就会只有在需要的时候，才调用
            singleton = new SingletonPatterns1();
        }
        return singleton;
    }

    public void fun(String msg) {
        System.out.println("your msg: " + msg);
    }


}
