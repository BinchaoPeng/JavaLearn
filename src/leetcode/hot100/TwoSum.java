package leetcode.hot100;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] re = twoSum(new int[]{1, 2, 4, -1, -5}, 5);
        System.out.println(Arrays.toString(re));
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] re = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                re[0] = nums[i];
                re[1] = target - nums[i];
            }
            map.put(nums[i], target - nums[i]);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> e : entrySet) {
            Integer key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + ", " + value);
        }
        return re;
    }
}
