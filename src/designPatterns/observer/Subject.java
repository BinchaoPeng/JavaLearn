package designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 */
public class Subject {
    private String name;
    private List<Observer> list = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
        // 这里改变了， 通知所有观察者
        notifyAllObservers();
    }

    public String getName() {
        return this.name;
    }

    private void notifyAllObservers() {
        for (Observer o : list) {
            o.update();
        }
    }

    public void addObservers(Observer observer){
        list.add(observer);
    }
}
