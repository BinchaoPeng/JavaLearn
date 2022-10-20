package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class String_ {
    public static void main(String[] args) {
        String str = "3";
        String str1 = new String("3");
        String str5 = new String("3");
        String str2 = new String("3") + new String("3");
        String str3 = "33";
        String str4 = "3";

        System.out.println(str == str1);  //todo 为啥false？？？？
        System.out.println(str.equals(str1));
        System.out.println(str2 == str3);
        System.out.println(str2.equals(str3));
        System.out.println(str == str4); //todo 为啥true？？？？
        System.out.println(str1 == str4);
        System.out.println(str.hashCode());
        System.out.println(str1.hashCode());
        System.out.println(str4.hashCode());
        System.out.println(new String("3").hashCode());
        System.out.println(new String("3").hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str1 == str5); // false

        Integer i = 1;



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
