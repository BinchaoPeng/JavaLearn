package jingdongPrac;

import java.util.*;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        int[] temp = new int[nums[n - 1] + 1];
        int re = division(n, nums, temp);
        System.out.println(re);
    }

    private static int division(int n, int[] nums, int[] temp) {
        temp[1] = 0;
        temp[2] = 1;
        temp[3] = 2;
        temp[4] = 3;
        temp[5] = 4;
        int max = nums[n - 1];
        for (int i = 6; i <= max; i++) {
            // 1, x-1
            int ans = 1 + temp[i - 1];
            // x = a * b
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    // 可以 axb
                    ans = Math.min(ans, 1 + temp[j] + temp[i / j]);
                }
            }
            // store
            temp[i] = ans;
        }
        System.out.println("temp: " + Arrays.toString(temp));
        int sum = 0;
        for (int val : nums) {
            sum += temp[val];
        }
        return sum;
    }
}
