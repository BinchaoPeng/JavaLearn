package generic;

public interface GenericInterface<T> {
    public static void main(String[] args) {

    }

    default T genericFuncT() {
        return null;
    }

    // 运行会报错，不允许
//    private String strFunc() {
//        return "";
//    }

    T interfaceFunc(T t);

    T func();


}
