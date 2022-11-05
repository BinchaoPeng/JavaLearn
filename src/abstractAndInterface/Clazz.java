package abstractAndInterface;

public class Clazz extends AbsrtractClazz implements Interface_ {
    @Override
    public String strFunc(String s) {
        return null;
    }

    @Override
    protected String strFunc1(String s) {
        return null;
    }

    @Override
    String strFunc2(String s) {
        return null;
    }


    @Override
    public String strFunc(String s, int a) {
        return super.strFunc(s, a);
    }

    @Override
    public String getStr(String str) {
        return null;
    }

    @Override
    public String getStr(String str, int a) {

        return null;

    }

    @Override
    public String getStr2(String str, int a) {
        return null;
    }

    @Override
    public String defFun() {
        return Interface_.super.defFun();
    }

    public static void main(String[] args) {
        System.out.println("main");
        String str1 = Interface_.str;
        AbsrtractClazz.staticFunc();

        // a和b只会反复指向1和2的地址
        Integer a = 1;
        a = 2;
        Integer b = 2;
        b = 1;
        a = 1;
        System.out.println(a);

    }

}
