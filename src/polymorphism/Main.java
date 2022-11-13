package polymorphism;

/**
 * 多态
 * 通过继承或者实现
 */
public class Main extends Parents implements Interface_ {


    @Override
    public int func(int val) {
        // 接口 一定要 实现
        System.out.println("it is myself according implement!");
        return 0;
    }
//
//    @Override
//    public void p() {
//        System.out.println("it is myself according extend!");
//    }

    public static void main(String[] args) {
        Main m = new Main();
        m.func(1);
        m.p();

        // 继承 父类引用
        // 不能调用 接口 的 func()方法
        Parents parents = new Main();
        parents.p();


        // 实现 接口引用
        // 不能调用 父类 的 p()方法
        Interface_ interface_ = new Main();
        interface_.func(1);
    }
}
