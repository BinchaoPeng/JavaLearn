package collectionPractices;

import java.util.*;

public class List_ {

    public static void main(String[] args) {
        System.out.println("arrayList");
        arrayList();
        System.out.println("\narrayListT");
        arrayListT();
        System.out.println("\nlinkedList");
        linkedList();
        System.out.println("\nlinkedList2Queue");
        linkedList2Queue();
        System.out.println("\nlinkedList2Deque");
        linkedList2Deque();
        System.out.println("\nlinkedList2Stack");
        linkedList2Stack();

    }

    public static void arrayList() {
        List l1 = new ArrayList(Arrays.asList(1, "hello"));  // 初始化时添加元素

        List list = new ArrayList(l1);
        list.add(1);
        list.add("str");
        list.add('c');
        System.out.println(Arrays.toString(list.toArray()));
        l1 = new ArrayList(Arrays.asList(1, list, "hello"));  // 初始化时添加元素
        list.addAll(l1);
        for (Object l : list) {
            System.out.println(l + ", " + l.getClass());
        }
    }

    public static void arrayListT() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("str");
        list.add("c");
        List<String> l = new ArrayList<>();
        l.add("l1");
        l.add("l1");
        l.add("l1");
        list.addAll(l);
        System.out.println(Arrays.toString(list.toArray()));
        for (Object o : list) {
            System.out.println(o + ", " + o.getClass());
        }
    }

    public static void linkedList() {
        // 用于表示 栈、队列、双端队列
        // 栈：Stack也表示栈，但是过时了，直接用 双端队列Deque实现
        // 队列：Queue
        // 双端队列：Deque

        // 当list使用
        List list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(Arrays.toString(list.toArray()));
        list.remove("1");
        list.remove(0);
        System.out.println(Arrays.toString(list.toArray()));

    }

    public static void linkedList2Queue() {
        // 当list使用
        List list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(Arrays.toString(list.toArray()));
        // 转成 Queue
        Queue queue = (Queue) list;
        // 队列 先进先出
        Object peek = queue.peek();// 获得头部元素
        System.out.println(peek);
        queue.poll();  // 出队操作 poll 轮询
        queue.add("2");

        System.out.println(Arrays.toString(queue.toArray()));
    }

    public static void linkedList2Deque() {
        // 当list使用
        List list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(Arrays.toString(list.toArray()));
        // 转成 双端队列
        Deque deque = (Deque) list;
        // add 和 remove 默认先进先出原则
        deque.add("9"); // 默认加在队尾
        deque.addLast("8");
        deque.addFirst("0");
        System.out.println(Arrays.toString(deque.toArray()));
        deque.remove(); // 默认出队首， 即 removeFirst()
        deque.remove("9");
        System.out.println(Arrays.toString(deque.toArray()));
    }

    public static void linkedList2Stack() {
        // 当list使用
        List list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(Arrays.toString(list.toArray()));

        // 表示栈的用法
        Deque deque = (Deque) list;
        // 先进后出
        deque.push("push");
        deque.push("push");
        deque.push("push");
        Object pop = deque.pop();
        System.out.println(Arrays.toString(deque.toArray()));
    }


}
