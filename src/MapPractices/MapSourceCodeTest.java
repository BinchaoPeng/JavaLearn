package MapPractices;

public class MapSourceCodeTest {
    public static void main(String[] args) {
        binary();
        hashXor();
    }

    static void binary(){
        System.out.println("binary represent");
        System.out.println(Integer.toBinaryString(1));//输出的是补码
        System.out.println(Integer.toBinaryString(1).length());
        System.out.println(Integer.toBinaryString(-1));//输出的是补码
        System.out.println(Integer.toBinaryString(-1).length());
    }

    static void hashXor() {
        System.out.println("HashMap的hash计算");
        String s = "abc";
        int i = s.hashCode();
        System.out.println("hashcode value");
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println("无符号右移16位");
        int i1 = i >>> 16;
        System.out.println(i1);
        System.out.println(Integer.toBinaryString(i1));
        System.out.println("xor result");
        int i2 = i ^ i1;
        System.out.println(i2);
        System.out.println(Integer.toBinaryString(i2));

    }
}
