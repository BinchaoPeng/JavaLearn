package string;

public class Intern {
    public static void main(String[] args) {
        System.out.println("intern方法");
        // 在堆中创建字符串对象”Java“
        // 将字符串对象”Java“的引用保存在字符串常量池中
        String s1 = "Java";
        // 直接返回字符串常量池中字符串对象”Java“对应的引用
        String s2 = s1.intern();
        // 会在堆中在单独创建一个字符串对象
        String s3 = new String("Java");
        // 直接返回字符串常量池中字符串对象”Java“对应的引用
        String s4 = s3.intern();
        // 124地址一样，指的是常量池的字符串引用，
        // 3 指的是 String对象
        // s1 和 s2 指向的是堆中的同一个对象
        System.out.println(s1 == s2); // true
        // s3 和 s4 指向的是堆中不同的对象
        System.out.println(s3 == s4); // false
        // s1 和 s4 指向的是堆中的同一个对象
        System.out.println(s1 == s4); //true
        System.out.println("字符串常量相加");
        // 对于编译期可以确定值的字符串，也就是常量字符串 ，jvm 会将其存入字符串常量池。
        String str1 = "str";
        String str2 = "ing";
        // 字符串相加 就是StringBuilder的append方法，再toString方法返回一个新的String对象
        // 字符串常量拼接得到的字符串常量在 编译阶段 就已经被存放字符串常量池
        // 在程序编译期就可以确定值的 常量，会直接使用字面值替换，这叫常量折叠。引用不能确定，所以不可以这样优化。
        String str3 = "str" + "ing";  // 可以常量折叠，等价于 String str3 = "string"
        // 引用的值在程序编译期是无法确定的，编译器无法对其进行优化。当使用final修饰时，那就是常量了，就可以确定值，然后被优化
        String str4 = str1 + str2;
        String str5 = "string";
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false

    }
}
