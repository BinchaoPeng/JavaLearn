package leetcode.hot100;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 7, 5, 4, 3, 2, 2, 1};
        System.out.println(Arrays.toString(nums));
        new NextPermutation().nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        // 逆序遍历
        int index = -1, target = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            // 找到 可以序列变换的
            if (nums[i] > nums[i - 1]) {
                index = i;
                target = nums[index - 1];
                System.out.println("t: " + target);
                break;
            }
        }

        // 如果没有找到target，说明整段是降序的
        if (index == -1) {
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            return;
        }
        // step2 找到 比 target 大的最小值, 而且数字相同时应该靠右
        // 相当于找last
        // 从 nums[index: ] 这一段找， 可以用二分法
        // nums[index: ] 一定是 降序

        int start = index, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            System.out.println("s: " + start + ", e: " + end + ", mid: " + mid);
            if (nums[mid] > target) {
                start = mid;
            } else if (nums[mid] < target) {
                end = mid;
            } else {
                end = mid;
            }

        }
        System.out.println("s: " + start + ", e: " + end);
        boolean findFlag = true;
        if (nums[end] > target) {
            // 和 target 替换
            nums[index - 1] = nums[end];
            nums[end] = target;
            findFlag = false;
        }

        if (findFlag && nums[start] > target) {
            // 和 target 替换
            nums[index - 1] = nums[start];
            nums[start] = target;
        }
        System.out.println(Arrays.toString(nums));
        // 逆序 nums[index:]
        // 首尾对换就行
        start = index;
        end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(nums));
    }
}
