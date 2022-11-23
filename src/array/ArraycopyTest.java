package array;

import java.util.Arrays;

public class ArraycopyTest {

    public static void main(String[] args) {

        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.out.println(Arrays.toString(a));
        /**
         * 不能越界
         * 如果源对象和目标对象是同一个，那就是 自我复制，可以用来做 插入操作
         * 属于深拷贝，如果复制的目的对象是个新数组
         */
        System.out.println("自我复制：");
        System.arraycopy(a, 2, a, 3, 3);
        System.out.println(Arrays.toString(a));
        a[2] = 99;
        System.out.println(Arrays.toString(a));
        System.out.println("复制到一个新的数组中：");
        int[] b = new int[20];
        System.out.println("a: " + Arrays.toString(a));
        System.arraycopy(a, 0, b, 5, a.length);
        System.out.println("b copied from a: " + Arrays.toString(b));
        a[0] = 100;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

}
