package designPatterns.observer;


public class O3 extends Observer implements ObserverInterface {
    public O3(Subject subject) {
        subject.addObservers(this);
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println(this.getClass() + "," + this.subject.getName());
    }
}
