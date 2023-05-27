package io.serialization;

public class SerialObject {
    // 静态变量不属于任何对象， 不会被序列化
    private static String staticStr;
    // 被 transient关键字 修饰的变量， 不被序列化
    private transient int transVal;
    private boolean bool;

    public SerialObject(int transVal, boolean bool) {
        this.transVal = transVal;
        this.bool = bool;
    }

    public static String getStaticStr() {
        return staticStr;
    }

    public static void setStaticStr(String staticStr) {
        SerialObject.staticStr = staticStr;
    }

    public int getTransVal() {
        return transVal;
    }

    public void setTransVal(int transVal) {
        this.transVal = transVal;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public static void main(String[] args) {

    }
}
