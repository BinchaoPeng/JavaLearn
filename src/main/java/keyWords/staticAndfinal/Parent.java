package keyWords.staticAndfinal;

import controlVisit.C;

public class Parent {
    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Parent(){
        System.out.println("父类无参构造器");
    }

    public Parent(int val) {
        this.val = val;
        System.out.println("父类 val参数构造器");
    }

    static {
        System.out.println("父类静态块-1");
    }

    {
        System.out.println("父类普通代码块");
    }

    static {
        System.out.println("父类静态块-2");
    }

    static final int sf() {
        System.out.println("父类 static final 方法");
        return 1;
    }
    public static void main(String[] args) {
        Child child = new Child();

    }
}
