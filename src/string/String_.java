package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class String_ {
    public static void main(String[] args) {
        strOperations();
        System.out.print("a ");
        System.out.print("b ");
        System.out.print("c \n");

    }

    private static void strOperations() {
        String s = "str";
        String substring = s.substring(0, 2);
        System.out.println(substring);
        s.toUpperCase();
        System.out.println(s);
        int abc = s.compareTo("ABC");
        System.out.println(abc);
        char[] chars = s.toCharArray();
        System.out.println(chars);
        System.out.println(Arrays.toString(chars));
    }

    public static void strBufferOperations() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("aaaa");
        stringBuffer.append(1);
        stringBuffer.append(1.2);
        stringBuffer.append('c');
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.capacity() + ", " + stringBuffer.length());
        stringBuffer.insert(1, "123");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.reverse());


    }

    public static void strEquals() {
        String str = "3";
        String str1 = new String("3");
        String str5 = new String("3");
        String str2 = new String("3") + new String("3");
        String str3 = "33";
        String str4 = "3";

        System.out.println(str == str1);  //false 一个指向常量池，一个指向对象实例，这个放在堆里面
        System.out.println(str.equals(str1));
        System.out.println(str2 == str3);
        System.out.println(str2.equals(str3));
        System.out.println(str == str4); //true  都指向常量池的那个字符串常量
        System.out.println(str1 == str4);
        System.out.println(str.hashCode());
        System.out.println(str1.hashCode());
        System.out.println(str4.hashCode());
        System.out.println(new String("3").hashCode());
        System.out.println(new String("3").hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str1 == str5); // false
    }

    public static void test1() {
        String a = "AAAAAABBBBBA";
        System.out.println(a.indexOf("c"));
        System.out.println(a.substring(0, 2));
        String number = "4.";
        // contains() 不用'\\'转义'.'
        // splits() 用'\\'转义'.'
        System.out.println(number.contains("."));
        String[] sp = number.split("\\.");
        for (String s : sp) {
            System.out.println(s);
        }
        System.out.println(sp.length);
        System.out.println(number.substring(3));
    }
}
