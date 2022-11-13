package designPatterns.singleton;

/**
 * 单例模式
 * 就是一个类全局只有一个实例，不可继承，也不可实例化
 * 唯一的访问形式：使用静态方法访问
 */
public class SingletonPatterns3 {
    /**
     * 双检锁/双重校验锁（DCL，即 double-checked locking）
     * 是否 Lazy 初始化：是
     * 是否多线程安全：是
     */

    private volatile static SingletonPatterns3 singleton;  // 这里需要设置 volatile static

    private SingletonPatterns3() {
        System.out.println("private construction");
    }


    public static SingletonPatterns3 getInstance() {
        if (singleton == null) {
            synchronized (SingletonPatterns3.class) {
                if (singleton == null) {
                    singleton = new SingletonPatterns3();
                }
            }
        }
        return singleton;
    }

    public void fun(String msg) {
        System.out.println("your msg: " + msg);
    }


}
