package leetcode.hot100;

import controlVisit.C;

import java.util.Arrays;

public class CanJump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        new CanJump().canJump(nums);
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] reTemp = new boolean[n];
        reTemp[0] = true;
//        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (reTemp[i]) {
                for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
                    reTemp[j] = true;
                }
            }

        }
        System.out.println(Arrays.toString(reTemp));
        return reTemp[n - 1];
    }
}
