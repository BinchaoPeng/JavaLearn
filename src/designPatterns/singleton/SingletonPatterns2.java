package designPatterns.singleton;

/**
 * 单例模式
 * 就是一个类全局只有一个实例，不可继承，也不可实例化
 * 唯一的访问形式：使用静态方法访问
 */
public class SingletonPatterns2 {
    /**
     * 饿汉式
     * 类加载后就创建好了单例，直接拿就行，但该方法容易产生垃圾
     * 也是线程安全的，因为类加载的机制
     */

    private static SingletonPatterns2 singleton = new SingletonPatterns2();  // 这里需要设置 static

    private SingletonPatterns2() {
        System.out.println("private construction");
    }


    public static SingletonPatterns2 getInstance() {
        // 在类加载的时候，就已经是加载好了
        return singleton;
    }

    public void fun(String msg) {
        System.out.println("your msg: " + msg);
    }


}
