package abstractAndInterface;

@SuppressWarnings("all")
public interface Interface_ {

    //都是常量，等价于 public static final
    // 可以 Interface.var
    String str = null;
    static String s = "11";

    public String getStr(String str);

    public abstract String getStr(String str, int a);


}
