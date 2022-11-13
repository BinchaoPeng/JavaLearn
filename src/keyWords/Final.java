package keyWords;

import java.util.Arrays;

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
