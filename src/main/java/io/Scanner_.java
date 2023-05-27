package io;

import java.util.Scanner;

public class Scanner_ {
    /***
     * nextLine()方法返回的是Enter键之前的所有字符，它是可以得到带空格的字符串的。
     *  换句话说，有时需要 使用一个 nextLine()方法 来吸收上一行的回车
     * next()会自动消去有效字符前的空格，只返回输入的字符，不能得到带空格的字符串。
     * @param args
     */
    public static void main(String[] args) {
        /**
         * demo1:
         * 1 2.3 hello world !
         * hkahfdk hakfdhja
         *
         * 1 2.3 hello world !
         * 1
         * 2.3
         *  hello world !
         * hkahfdk hakfdhja
         * hkahfdk
         */
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);
        double v = scanner.nextDouble();
        System.out.println(v);
        // 上面的都是接收数字，根据空格截断，会自动忽略数字前的回车（来自上一行的）
        // nextLine() 收到了上一行留下的回车
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.println(s);
        String next = scanner.next();
        System.out.println(next);

    }
}
