package abstractAndInterface;


@SuppressWarnings("all")
public abstract class AbsrtractClazz {
    private int val;

    static {
        System.out.println("static code block in AbstractClazz !");
    }

    public abstract String strFunc(String s);

    protected abstract String strFunc1(String s);

    abstract String strFunc2(String s);

    /*
     * 抽象类， 具体方法， 所有修饰符都可以
     */
    private String strPriFunc(String s) {
        // 不能被覆盖，仅子类可见
        return "Private func";
    }

    public String strFunc(String s, int a) {
        this.strPriFunc(s);
        return "strFunc";
    }
    String defFun() {
        return "defFun";
    }
    public String pubFun() {
        return "pubFun";
    }
    protected String protectedFunc(){  // 不可以
        return "protectedFunc";
    }

    public static void staticFunc() {
        System.out.println("static function in abstractClazz !");
    }
}
