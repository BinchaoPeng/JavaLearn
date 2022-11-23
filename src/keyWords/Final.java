package keyWords;

import java.util.Arrays;

/**
 * https://blog.csdn.net/qq_41613281/article/details/123920846
 * 1. final修饰变量
 * 修饰基本数据类型（short\int\long\byte\double\float\char\boolean）时，表示这个变量值不可变；
 * 修饰引用数据类型时，表示这个变量引用不可变，但引用的对象具体内容是可以改变的（比如对象的某个属性值是可变的）
 *
 * 2. final修饰方法
 * 表示此方法不可被重写，保证了方案安全性。
 *
 * 3. final修饰类
 * 表示此类不可以被继承
 *
 * 4. final修饰形参
 * 参数在函数内部不可被修改，主要用户保证数据安全性，避免无意中改动数据带来的问题。
 */
public class Final {
    final int f = 1;
    static final int sf = 1;
    int a = 1;

    static final int[] nums = new int[10];
    // 这一段，是否需要static，取决于是否需要生成实例
    {
        nums[0] = 0;
        nums[1] = 1;
    }

    public int getF() {
        return f;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nums));
        Final fin = new Final();
        for (int i = 0; i < 3; i++) {
            System.out.println(fin.f);
            System.out.println(Final.sf);
        }
        System.out.println(Arrays.toString(nums));
    }
}
