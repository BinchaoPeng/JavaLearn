package designPatterns.observer;

/**
 * 观察者 父类
 * 提供 观察方法
 */
abstract class Observer {
    Subject subject;

    public abstract void update();
}
