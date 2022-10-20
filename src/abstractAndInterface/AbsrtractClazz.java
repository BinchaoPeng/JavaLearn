package abstractAndInterface;


@SuppressWarnings("all")
public abstract class AbsrtractClazz {
    private int val;

    static {
        System.out.println("static code block in AbstractClazz !");
    }

    public abstract String strFunc(String s);

    private String strPriFunc(String s) {
        // 不能被覆盖，仅子类可见
        return "Private func";
    }

    public String strFunc(String s, int a) {
        this.strPriFunc(s);
        return "strFunc";
    }

    public static void staticFunc(){
        System.out.println("static function in abstractClazz !");
    }
}
