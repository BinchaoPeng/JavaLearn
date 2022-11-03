package AlgorithmPractice;

import java.util.Arrays;

/**
 * 归并排序
 * 采用分支思想
 * 先对半拆成一个一个数组，最后变成一个一个只有一个数字的数组   这里，O(logn)
 * 再双指针法，有序合并两个数组  这里，O(n)
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 5, 4};
        int[] re = new MergeSort().getSort(nums);
        System.out.println(Arrays.toString(re));
    }

    public int[] getSort(int[] nums) {
        // 空间换时间的做法
        // temp 用来存排好序的数组，不要在递归里面写，因为创建对象很消耗性能
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        System.out.println(Arrays.toString(temp));
        return nums;
    }

    public void mergeSort(int[] nums, int start, int end, int[] temp) {
        System.out.println(start + "," + end);
        // 主要是这种代码思路不好写出来
        // 递归结束条件，或者说，异常检测
        if (start >= end) return;
        //先做拆分,这样递归下去，就是对半拆分，到了最后就是两个相邻的数（数组形式）
        mergeSort(nums, start, (start + end) / 2, temp);
        mergeSort(nums, (start + end) / 2 + 1, end, temp);
        //再用双指针合并拆分的两个相邻数组
        merge(nums, start, end, temp);
    }


    public void merge(int[] nums, int start, int end, int[] temp) {
        int leftIdx = start;
        int middle = (start + end) / 2;
        int rightIdx = middle + 1;
        int tempIdx = start; // 这里不是0，不然每次都是从0开始了
        while (leftIdx <= middle && rightIdx <= end) {
            // 双指针遍历
            if (nums[leftIdx] < nums[rightIdx]) {
                temp[tempIdx++] = nums[leftIdx++];
            } else {
                temp[tempIdx++] = nums[rightIdx++];
            }
        }
        while (leftIdx <= middle) {
            temp[tempIdx++] = nums[leftIdx++];
        }
        while (rightIdx <= end) {
            temp[tempIdx++] = nums[rightIdx++];
        }
        // 把结果复原到nums数组上
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }

}
