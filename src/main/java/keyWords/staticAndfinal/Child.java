package keyWords.staticAndfinal;

import controlVisit.P;

/**
 * Java虚拟机会在你初始化子类的时候默认的初始化子类的父类
 * 因为继承的时候，共享父类所有属性和方法
 * 不初始化父类，就不能调用父类的字段了
 * 父类的构造方法是不会被子类继承，但子类初始化时会调用父类构造方法。
 * 但为了方便，子类构造方法中会有一个隐式的super()来调用父类中的无参数构造方法。
 * 如果父类有多个构造方法，子类默认还是调用父类无参构造方法。
 * 如果子类调用了父类的有参构造方法，就不会再有隐式调用父类的无参构造方法，必须[显式调用]。
 * ref：<a href="https://blog.csdn.net/qq_41638851/article/details/105103250">java中，子类初始化时一定要调用父类的构造方法，不调用行吗？</a>
 */
public class Child extends Parent {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Child() {
        /**
         * 默认隐式调用父类无参构造方法
         * 就是super这个属性
         * 如果显式调用指定构造器，就不会默认调用父类无参构造器
         */
        System.out.println("子类无参构造器");
    }

    public Child(String name) {
        this.name = name;
        this.setVal(100);//这里也能说明，父类得到了初始化

        System.out.println("子类 name参数构造器");
    }

    public Child(String name, int val) {
        super(val); //显示调用
        this.name = name;

        System.out.println("子类 name,val参数构造器[super显式调用父类构造器]");
    }

    static {
        System.out.println("子类静态块-1");
    }

    {
        System.out.println("子类普通代码块");
    }

    static {
        System.out.println("子类静态块-2");
    }

    static final int sfChild() {
        System.out.println("子类 static final 方法");
        return 1;
    }

    public static void main(String[] args) {
        Child child = new Child("dog",18);
        System.out.println();
        /**
         * （静态）代码块，只会在第一次初始化的时候，执行
         * 后面再次创建对象时，代码块不会再运行
         */
        Child child1= new Child("dog");

    }
}
