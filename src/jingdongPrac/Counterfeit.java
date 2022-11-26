package jingdongPrac;

import service.StuService;

import java.util.Arrays;
import java.util.Scanner;

public class Counterfeit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        String l = scanner.nextLine();
        System.out.println(l);
        System.out.println(Arrays.toString(nums));
        counterfeit(nums, n);


    }

    static int counterfeit(int[] nums, int n) {
        return 0;
    }
}
