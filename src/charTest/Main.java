package charTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * 1
         */
        String s = "hello";
        String t = s;  // todo 指向了s的内存地址，而不是指向s，是指向他的地址
        s = "world";
        System.out.println(t); // t是"hello"还是"world"?

        /**
         * 2
         */
        int a = 72;
        int b = 105;
        int c = 65281;
        // FIXME:
        String s1 = ""+(char)a+(char)b+(char)c;
        System.out.println(s1);

        /**
         * 3
         */
        String[] names = {"ABC", "XYZ", "zoo"};
        String ss = names[1];
        names[1] = "cat";
        System.out.println(ss); // s是"XYZ"还是"cat"?

        /**
         * 4
         * 输入上次考试成绩（int）和本次考试成绩（int），
         * 然后输出成绩提高的百分比，
         * 保留两位小数位（例如，21.75%）
         */
        Scanner scanner = new Scanner(System.in);
        int past = scanner.nextInt();
        int now = scanner.nextInt();
        System.out.printf("%.2f",1.0*now/past-1);
    }
}
