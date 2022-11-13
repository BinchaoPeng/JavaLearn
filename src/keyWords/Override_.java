package keyWords;

class Parent {
    public static final int VAL = 1;

    private int priFunc() {
        return 1;
    }

    static String staFunc() {
        return "staFunc";
    }

    final void finFunc() {
    }

    public void pubFunc() {

    }

    protected void proFunc() {

    }

    void deauFunc() {

    }

}


public class Override_ extends Parent {
    /**
     * 访问修饰符，子类只能更大范围
     * 返回类型（返回的是引用类型） 和 异常， 不能超过父类范围
     * private、final、static方法，不给继承
     * 具体的：
     *      如果方法的返回类型是 void 和基本数据类型，则返回值重写时不可修改。
     *      但是如果方法的返回值是引用类型，重写时是可以返回该引用类型的子类的
     */
    @Override
    public void pubFunc() {
        super.pubFunc();
    }

    @java.lang.Override
    protected void proFunc() {
        super.proFunc();
    }

    @java.lang.Override
    public void deauFunc() {
        super.deauFunc();
    }
}
