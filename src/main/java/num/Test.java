package num;

public class Test {
    public static void main(String[] args) {
        IntObj1();
    }


    static void IntObj() {
        Integer integer = Integer.valueOf(1);
        Integer integer1 = new Integer(1);
        int integer2 = 1;
        Integer integer3 = 1;
        System.out.println(integer == integer1); // false
        System.out.println(integer == integer2); // true
        System.out.println(integer == integer3); // true
        System.out.println(integer1 == integer2);// true
        System.out.println(integer1 == integer3);// false
        System.out.println(integer2 == integer3); // true
    }

    static void IntObj1() {
        Integer integer = Integer.valueOf(130);
        Integer integer1 = new Integer(130);
        int integer2 = 130;
        Integer integer3 = 130;
        System.out.println(integer == integer1); // false
        System.out.println(integer == integer2); // true
        System.out.println(integer == integer3); // true --> false 超过缓存范围，所以new一个
        System.out.println(integer1 == integer2);// true
        System.out.println(integer1 == integer3);// false
        System.out.println(integer2 == integer3);// true
    }


    static void floatEqual() {
        /**
         * 浮点数之间的等值判断，基本数据类型不能用 == 来比较，包装数据类型不能用 equals 来判断。
         * 解决办法：
         *      采用和 误差范围 作比较
         *      使用BigDecimal类
         */
        System.out.println(41.1 == 41.01); //false
        System.out.println(41.00000000001d == 41.00000000001d);  //true
        System.out.println(41 == 41.00); // true
        float a = 41.2f;
        float b = 41.2f;
        System.out.println(a == b); //true
        System.out.println(4.2 == 4.2); //true
        /**
         * 浮点数运算是不准确的
         * 会有精度丢失的风险
         */
        float m = 5.2f;
        float n = 5.1f;
        double re = m - n;
        System.out.println(re); // 0.09999990463256836
        System.out.println(re == 0.1);// false!!!
        System.out.println((0.3 - 0.2) == (0.4 - 0.3)); // false

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
