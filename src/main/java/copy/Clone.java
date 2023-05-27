package copy;

import controlVisit.C;

import java.util.ArrayList;
import java.util.Arrays;

public class Clone implements Cloneable {
    private int age;
    private String name;

    public Clone(String name, int age) {
        this.age = age;
        this.name = name;

    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Clone clone() {
        /*
        浅克隆
        复制引用，指向同一个实例
         */
        Clone c = null;
        try {
            c = (Clone) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public static void main(String[] args) {
        Clone clone = new Clone("pbc", 25);
        Clone clone1 = clone.clone();
        // 引用的地址 不一样
        System.out.println(clone);
        System.out.println(clone1);
        // 查看对象内容
        System.out.println(clone.name);
        System.out.println(clone1.name);
        clone.setName("PBC");
        System.out.println(clone.name);
        System.out.println(clone1.name);
    }
}
