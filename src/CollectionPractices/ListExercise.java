package CollectionPractices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ListExercise.java
 * 添加10个以上的元素(比如String "hello")，
 * 在2号位插入一个元素"韩顺平教育"，
 * 获得第5个元素，
 * 删除第6个元素，
 * 修改第7个元素，
 * 在使用迭代器遍历集合,
 * 要求:使用List的实现类ArrayList完成。
 */
public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add(2,"pbc");
        System.out.println(list.get(4));
        list.remove(5);
        System.out.println(list);
        list.set(6,"jjjj");
        System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
