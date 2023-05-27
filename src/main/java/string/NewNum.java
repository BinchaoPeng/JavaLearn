package string;

/**
 * 测试 字符串 创建
 */
public class NewNum {
    public static void main(String[] args) {
        // 字符串常量池 存的是 字符串引用， 该引用指向堆的 字符串实例
        // 原理：new的时候，会先检查 字符串常量池，看有没有字符串“abc”的引用
        //      若有引用，返回引用，就只需要创建一个String对象
        //      若没有，就创建 2个 对象，一个是String对象，一个是字符串“abc”对象
        String s = new String("abc");
        String s1 = new String("abc");
        System.out.println(s == s1); //false
        String s2 = "abc";
        System.out.println("abc" == s2); //true
    }

}
