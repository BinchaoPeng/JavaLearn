package generic;

public class GenericClazz<K, V> {
    private K kType;
    private V vType;

    public GenericClazz() {

    }

    public GenericClazz(K k, V v) {
        this.kType = k;
        this.vType = v;
    }

    /**
     * 泛型方法  在返回类型前 标注  参数 是 泛型
     * 静态泛型方法是没有办法使用类上声明的泛型的。只能使用自己声明的 <E>
     * @param inputArray
     * @param <E>
     */
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static <K> Object staticFunc() {

        return "";
    }

    public V genericFunV() {
        System.out.println("关于V这个类型的参数的泛型方法");
        return this.getvType();
    }

    public K getK() {
        return kType;
    }

    public void setK(K k) {
        kType = k;
    }

    public V getvType() {
        return vType;
    }

    public void setvType(V vType) {
        this.vType = vType;
    }
}
