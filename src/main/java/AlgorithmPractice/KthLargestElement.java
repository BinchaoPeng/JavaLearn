package AlgorithmPractice;

import java.util.Arrays;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 4, 3, 6, 0};
        int re = new KthLargestElement().getKthLargestElement(nums, 4);
        System.out.println(re);
        System.out.println(Arrays.toString(nums));
    }

    public int getKthLargestElement(int[] nums, int k) {
        int reIdx = nums.length - k;
        quickSelect(nums, 0, nums.length - 1, reIdx);
        return nums[reIdx];
    }

    private void quickSelect(int[] nums, int start, int end, int reIdx) {
        // 相当于快排，然后根据k判断，处理左半部分还是处理右半部分
        if (start > reIdx || start >= end) return;
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            // swap
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (start <= reIdx && reIdx <= right) {
            quickSelect(nums, start, right, reIdx);
        }
        if (left <= reIdx && reIdx <= end) {
            quickSelect(nums, left, end, reIdx);
        }
    }
}
