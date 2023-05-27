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
        System.out.println(Arrays.toString(nums));
        int counterfeit = counterfeit(nums, n);
        System.out.println(counterfeit);


    }

    static int counterfeit(int[] nums, int n) {
        if (n == 1) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }
}
