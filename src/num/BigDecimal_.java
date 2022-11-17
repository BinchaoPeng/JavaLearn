package num;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimal_ {
    public static void main(String[] args) {
        scaleQuestion();
        newObject();
        operations();
        covertType();
    }

    private static void scaleQuestion() {
        System.out.println("精度相关问题，以double为参数的BigDecimal构造器会有精度问题");
        double d = 1.235;
        BigDecimal bigDecimal = new BigDecimal(d); //禁止使用
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(d));
        System.out.println(d);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal1);
    }

    public static void covertType() {
        System.out.println("类型转换：");
        BigDecimal bigDecimal = new BigDecimal("1.35252");
        BigDecimal bigDecimal1 = new BigDecimal(1.35252); //精度失真
        float v = bigDecimal.floatValue();
        double v1 = bigDecimal.doubleValue();
        byte b = bigDecimal.byteValue();
        long l = bigDecimal.longValue();
        int i = bigDecimal.intValue();
        System.out.println(bigDecimal);//1.35252
        System.out.println(bigDecimal1);//1.3525199999999999445066123371361754834651947021484375
        System.out.println(v); // 1.35252
        System.out.println(v1);  // 1.35252
        System.out.println(b);
        System.out.println(l);
        System.out.println(i);
    }

    private static void operations() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        System.out.println(a.add(b));// 1.9
        System.out.println(a.subtract(b));// 0.1
        System.out.println(a.multiply(b));// 0.90
        /**
         * 关于除法操作
         * 尽量使用 3 个参数版本，并且RoundingMode 不要选择 UNNECESSARY，
         * 否则很可能会遇到 ArithmeticException（无法除尽出现无限循环小数的时候），
         * 其中 scale 表示要保留几位小数，roundingMode 代表保留规则。
         */
//        System.out.println(a.divide(b));// 无法除尽，抛出 ArithmeticException 异常
        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));// 1.11

        /**
         * 数字比较
         * 不要用 equals方法，不光比较值，还比较他们的保留位数（精度scale），精度不相等也是false
         * 推荐使用compare方法，，会忽略精度scale的比较，只比较值
         */
        System.out.println(a.compareTo(b));// 1
        double v = a.max(b).doubleValue();
        double v1 = a.min(b).doubleValue();

    }

    public static void newObject() {
        // 推荐使用
        // BigDecimal(String val)
        // BigDecimal.valueOf(double val)
        BigDecimal bigDecimal = new BigDecimal("123.654789");
        BigDecimal bigDecimal1 = BigDecimal.valueOf(1.25634875662);
        // 这个构造方法不要用，会精度失真
        // 1.3653999999999999470645661858725361526012420654296875
        BigDecimal bigDecimal2 = new BigDecimal(1.3654);
        System.out.println(bigDecimal2);
    }
}
