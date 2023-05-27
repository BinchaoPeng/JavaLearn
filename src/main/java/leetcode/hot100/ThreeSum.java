package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 0, 2, 2};
        nums = new int[]{-4, -1, -1, 0, 1, 2,};
        List<List<Integer>> lists = ThreeSum(nums);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    public static List<List<Integer>> ThreeSum(int[] nums) {
        // 双指针法
        // 定位k和y，移动i，找到了就移动y
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int k = 0; k < n - 2; k++) {
            if(nums[k]>0) break;
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
//            System.out.println("coming " + k + " " + nums[k]);
            if (nums[k] <= 0) {
                int i = k + 1;
                int j = n - 1;
                while (i < j) {
                    // 也要考虑i和j移动过程中的重复问题，不能先去重，否则回跳过正确答案
//                    System.out.println(nums[k] + ", " + nums[i] + ", " + nums[j]);
                    if (nums[k] + nums[i] + nums[j] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[k]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        lists.add(list);
                        while (i < j && nums[i] == nums[++i]) ;//不能丢了i++，否则会有i下标的重复
                        while (i < j && nums[j] == nums[--j]) ;
                    } else if (nums[k] + nums[i] + nums[j] < 0) {
                        while (i < j && nums[i] == nums[++i]) ;
                    } else {
                        // >0时不符合了,要j--
                        while (i < j && nums[j] == nums[--j]) ;
                    }
                }
            }
        }
        return lists;
    }
}
