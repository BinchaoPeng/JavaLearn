package Test;

import java.util.Arrays;

public class Test {
    int m;

    public static void main(String[] args) {
        StringSum();
    }

    public static void StringSum(){
        String a = "1";
        for (int i = 0; i < 3; i++){
            a += "j";
        }
        System.out.println(a);
    }
    public static void break_() {
        /*
        符合条件的话，直接跳出循环！！！
         */
        int i = 10;
        while (i > 0) {
            i--;
            if (i < 3) {
                System.out.println("if.");
                if (i < 3) {
                    break;
                }
                System.out.println("IF..");
            }
            System.out.println("going...");
        }
    }

    public void base(int n) {
        n = 2;
        m = 3;
    }


    public static void sumSum() {
        /**
         * 1、while(++i）是先执行i+1，再进行判断，再执行循环体；
         * 2、while(i++)是先判断，再执行循环体，再+1
         * 循环结束后：while（++i）执行完后，i=0; while（i++）执行完后，i=1;
         */
        int[] nums = new int[]{0, 1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        /**
         * i=0; nums[0] ?> 2; i+1; num[1] ?> 2; i+1; num[2] ?> 2, no; i+1;
         */
        int a;
        int i = 0;
        while ((a = nums[i++]) < 2) {
            System.out.println("i=" + i + ",a=" + a);
        }
        System.out.println(i);
        /**
         * i=0; i+1; nums[1] ?> 2; i+1; nums[2] ?> 2, no;
         */
        i = 0;
        while ((a = nums[++i]) < 2) {
            System.out.println("i=" + i + ",a=" + a);
        }
        System.out.println(i);
        /**
         * i=0; nums[0] ?> 2; i+1; num[1] ?> 2; i+1; num[2] ?> 2, no;
         */
        i = 0;
        while ((a = nums[i]) < 2) {
            i++;
            System.out.println("i=" + i + ",a=" + a);
        }
        System.out.println(i);

        System.out.println();

        int j = 4;
        while ((a = nums[j--]) > 2) {
            System.out.println("j=" + j + ",a=" + a);
        }
        System.out.println(j);
        j = 4;
        while ((a = nums[--j]) > 2) {
            System.out.println("j=" + j + ",a=" + a);
        }
        System.out.println(j);
        j = 4;
        while ((a = nums[j]) > 2) {
            j--;
            System.out.println("j=" + j + ",a=" + a);
        }
        System.out.println(j);
    }

    public static void Integer_() {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        Integer i3 = 1;
        Integer i4 = 1;
        int i5 = 1;
        System.out.println(i1 == i2);  // false
        System.out.println(i1.equals(i2)); //ture
        System.out.println();
        System.out.println(i3 == i4); // true
        System.out.println(i3.equals(i4)); // true
        System.out.println();
        /**
         * 非new生成的Integer变量指向的是java常量池中的对象，
         * 而new Integer()生成的变量指向堆中新建的对象，
         * 两者在内存中的地址不同
         */
        System.out.println(i1 == i3);  // todo false
        System.out.println(i1.equals(i3)); // ture
        System.out.println();
        /***
         * 包装类Integer和基本数据类型int比较时，
         * java会自动拆包装为int，
         * 然后进行比较，实际上就变为两个int变量的比较
         */
        System.out.println(i1 == i5); // todo ture
        System.out.println(i1.equals(i5)); // ture
        System.out.println(i3 == i5); // ture
        System.out.println(i3.equals(i5)); // ture

    }

    public static void sumsum() {
        int i = 0;
        // 先赋值再相加
        i = i++;
//        i++;
        int j = 0;
        // 先相加再赋值
        j = ++j;
//        ++j;
        System.out.println(i);
        System.out.println(j);
    }


    /*
            int a = getValue(0);
        System.out.println(a);
     */
    public static int getValue(int i) {

        try {
            throw new Exception("try");
        } catch (Exception e) {
            System.out.println("catch");
            i++;
            return i;
        } finally {
            System.out.println("finally");
            ++i;
        }

    }
}
