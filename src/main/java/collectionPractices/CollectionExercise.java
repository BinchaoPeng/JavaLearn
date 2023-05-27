package collectionPractices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 请编写程序CollectionExercise.java
 * 1.创建3个Dog {name, age}对象，放入到 ArrayList中，赋给List 引用
 * 2.用迭代器和增强for循环两种方式来遍历
 * 3.重写Dog的toString方法，输出name和age
 */
public class CollectionExercise {
    public static void main(String[] args) {
        List list = new ArrayList<Dog>();
        list.add(new Dog("dog1", 1));
        list.add(new Dog("dog2", 2));
        list.add(new Dog("dog3", 3));
        // 迭代器遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        //foreach
        for (Object d : list) {
            System.out.println(d);
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}