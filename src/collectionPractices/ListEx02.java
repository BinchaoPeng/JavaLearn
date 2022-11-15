package collectionPractices;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用List的实现类添加三本图书，并遍历，打印如下效果名称:xXX
 * 价格:xX    名称:xX   作者:xx
 * 价格:xX    名称:xX   作者:xx
 * 价格:xX    名称:xX   作者:xx
 * 要求
 * 1)按价格排序,从低到高(使用冒泡法)
 * 2)要求使用ArrayList、LinkedList 和Vector三种集合实现
 */
public class ListEx02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book(3.2, "java", "pbc"));
        list.add(new Book(1.5, "python", "pbc"));
        list.add(new Book(4.3, "r", "pbc"));
        list.add(new Book(1.4, "c", "pbc"));
        list.add(new Book(0.3, "r", "pbc"));
        list.add(new Book(0.4, "c", "pbc"));
        for (Object o :
                list) {
            System.out.println(o);
        }

        // sort
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (((Book) list.get(j)).getPrice() > ((Book) list.get(j + 1)).getPrice()) {
                    Object t = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, t);
                }
            }
        }
        for (Object o :
                list) {
            System.out.println(o);
        }

    }

    public static void main() {

    }
}


class Book {
    private double price;
    private String name;
    private String author;

    public Book(double price, String name, String author) {
        this.price = price;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "价格：" + price + "\t\t名称：" + name + "\t\t作者：" + author;


    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
