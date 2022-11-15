package num;

public class Test {
    public static void main(String[] args) {
        equal_();
    }

    static void equal_() {
        System.out.println(41.1 == 41.01);
        System.out.println(41 == 41.0);
        System.out.println(41 == 41.00);
        float a = 41.2f;
        float b = 41.2f;
        System.out.println(a==b);
        System.out.println(4.2 == 4.2);
    }

    static void boxing() {
        Integer i1 = 40;  // 自动装箱，用的缓存
        Integer i2 = new Integer(40); // new了一个
        System.out.println(i1 == i2);

//        Integer i = 10 等价于 Integer i = Integer.valueOf(10)
//        int n = i 等价于 int n = i.intValue();
        Integer i = 10;  //装箱，引用用的包装类型
        int n = i;   //拆箱，引用用的基本类型
    }

    public static void Integer_() {
        // range [-128, 127]
        // 看源代码就知道
        Integer integer = Integer.valueOf(1);
        int i = 0177; // 八进制
        System.out.println(Integer.toBinaryString(i));
        int i1 = 177;
        System.out.println(Integer.toBinaryString(i1));
        int i2 = 1;
        int i3 = -1;
        System.out.println(Integer.toBinaryString(i2));
        System.out.println(Integer.toBinaryString(i3));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(186));
    }
}
