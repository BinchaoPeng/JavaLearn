package params;

import controlVisit.P;

import java.util.Arrays;

public class Params {
    /**
     * 可变长参数
     * `type... varName`，只能放在最后
     * 编译后转换成一个数组
     * 重载时，优先匹配固定参数个数的方法
     */
    void func(int num, String... strings) {
        System.out.println(num);
        System.out.println(strings.getClass());
        System.out.println(Arrays.toString(strings));
        System.out.println(strings[0]);
    }


    public static void main(String[] args) {
        new Params().func(5, "hello", "word", "!");
    }
}
