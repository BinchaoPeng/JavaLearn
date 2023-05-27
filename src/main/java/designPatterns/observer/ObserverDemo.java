package designPatterns.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        // 创建 被观察者
        Subject subject = new Subject();

        // 创建观察者
        new O1(subject);
        new O2(subject);
        new O3(subject);
        // 修改状态
        subject.setName("dog");
        subject.setName("dog1");
    }
}
