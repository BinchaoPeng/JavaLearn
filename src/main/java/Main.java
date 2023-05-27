package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int a1 = 1;
        final double PI = Math.PI;
        Scanner in = new Scanner(System.in);
//        in.next();
        int[] ar = {1, 2, 3,};
        System.out.println(Arrays.toString(ar));
        System.out.println(ar[1]);
        boolean[] a = new boolean[3];
        for (boolean item :
                a) {
            System.out.println(item);
        }
    }
}