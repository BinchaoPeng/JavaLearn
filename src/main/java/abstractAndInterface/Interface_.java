package abstractAndInterface;

@SuppressWarnings("all")
public interface Interface_ {

    //都是常量，等价于 public static final
    // 可以 Interface.var
    String str = null;
    static String s = "11";


    public String getStr(String str);

    public abstract String getStr(String str, int a);
    abstract String getStr2(String str, int a); // 默认public


    /**
     * 接口具体方法，访问域，只允许到
     */
//    private String strPriFunc(String s) { // 不可以的
//        // 不能被覆盖，仅子类可见
//        return "Private func";
//    }
    // 由于接口中的方法可以省略public，默认设置是public，所以default要显示声明
    default String defFun() {
        return "defFun";
    }
//    protected String protectedFunc(){  // 不可以
//        return "protectedFunc";
//    }

//    public String pubFun() {
//        return "pubFun";
//    }


    public static void staticFunc() {
        System.out.println("static function in abstractClazz !");
    }
}
