package assertTest;

import java.util.Scanner;

public class AssertTest {
    public static void main(String[] args) {
        /**
         * 为什么assert语句不起作用？
         * 这是因为JVM默认关闭断言指令，即遇到assert语句就自动忽略了，不执行。
         * 要执行assert语句，必须给Java虚拟机传递-enableassertions（可简写为-ea）参数启用断言
         */
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x = scanner.nextInt();
            System.out.println(x);
            assert x > 0 : x + " AssertError!";
            System.out.println("passed!");
        }
    }
}
