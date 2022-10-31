package Test;

public class Test {
    public static void main(String[] args) {
        Integer_();

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
