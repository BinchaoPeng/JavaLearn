package leetcode.hot100;

import controlVisit.P;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = new ProductExceptSelf().productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 左乘一遍
     * 右乘一遍
     * 该位置的re = 左部分 * 右部分
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] re = new int[nums.length];
        int temp = 1;
        re[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            temp *= nums[i - 1];
            re[i] = temp;
        }
        temp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            re[i] *= temp;
        }
        return re;
    }
}
