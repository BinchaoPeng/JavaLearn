package AlgorithmPractice;

import java.util.Arrays;

/**
 * 快排算法
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 2, 5, 1, 0};
        int[] re = new QuickSort().getSort(nums);
        System.out.println(Arrays.toString(re));
    }

    public int[] getSort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        quickSort(nums, 0, nums.length - 1, 0, "root");
        return nums;
    }

    public void quickSort(int[] nums, int start, int end, int deep, String flag) {
        // step 0 防止end < start
        if (start >= end){
            return;
        }
        // step1, left,right, pivot
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        System.out.println("deep=" + deep + "-" + flag + " (" + left + "," + right + ")");
        // step2, change
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            } // 找到大于等于标杆值的数的下标 left
            while (left <= right && nums[right] > pivot) {
                right--;
            } // 找到小于等于标杆值的数的下标 right
            // change
            if (left <= right) {
                System.out.println("changed:" + " (" + left + "," + right + ")");
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                // changed then cross
                left++;
                right--;
            }
        }
        deep++;
        quickSort(nums, start, right, deep, "left");
        quickSort(nums, left, end, deep, "right");
    }
}
