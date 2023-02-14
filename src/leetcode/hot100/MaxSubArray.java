package leetcode.hot100;

import java.util.Arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = new MaxSubArray().maxSubArray(nums);
        System.out.println(i);
    }

    /**
     * 版本 0 O(n^2),O(n^2)
     * 最初版本，超出内存限制
     * 改进思路，由二维变成一维，每次都替代前边的结果就行
     *
     * @param nums
     * @return
     */
    public int maxSubArray0(int[] nums) {
        int re = Integer.MIN_VALUE;
        int n = nums.length;
        int[][] reTemp = new int[n][n];
        for (int i = 0; i < n; i++) {
            reTemp[i][i] = nums[i];
            if (reTemp[i][i] > re) {
                re = reTemp[i][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                reTemp[i][j] = reTemp[i][j - 1] + nums[j];
                if (reTemp[i][j] > re) {
                    re = reTemp[i][j];
                }
            }
        }
        for (int[] r : reTemp) {
            System.out.println(Arrays.toString(r));
        }
        return re;
    }

    /**
     * 版本 1 O(n^2),O(n)
     * 从 版本0 改进后，超时了。。。。
     * 再次改进，改进思路：
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int re = Integer.MIN_VALUE;
        int n = nums.length;
        // 表示以当前坐标为起始点，到 下标i 的 和
        int[] reTemp = new int[n];
//        // 初始化
//        for (int i = 0; i < n; i++) {
//            reTemp[i] = nums[i];
//            if (reTemp[i] > re) {
//                re = reTemp[i];
//            }
//        }
        System.out.println(Arrays.toString(reTemp));
        // 计算下标i 到 起始点的 距离
        for (int i = 0; i < n; i++) { // end
            for (int j = 0; j <= i; j++) { // start
                reTemp[j] += nums[i];
                if (reTemp[j] > re) {
                    re = reTemp[j];
                }
            }
            System.out.println(Arrays.toString(reTemp));
        }

        return re;
    }

    /**
     * 版本3 O(n) O(1)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int re = Integer.MIN_VALUE;
        int reTemp = 0;
        // 最大结果可以理解为，上一阶段的最大值 + val
        // 如果 val 是正数， 说明有 增益效果
        // 如果 val 是负数， 说明有 减益效果
        // 然后把 上一阶段 看成 一个整体， 如果 和 是 负数， 那就丢弃就行了

        for (int i = 0; i < nums.length; i++) {
            reTemp += nums[i];
            if (reTemp > re) {
                re = reTemp;
            }
            if (reTemp < 0) {
                reTemp = 0;
            }
        }
        return re;
    }
}