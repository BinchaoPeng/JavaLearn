package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 需要去重
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = new Subsets().subsets(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(nums, new ArrayList<Integer>(), 0, res);
        res.add(new ArrayList<>());
        return res;
    }

    private void backTrace(int[] nums, ArrayList<Integer> curList, int start, List<List<Integer>> res) {
        if (curList.size() == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            if (!res.contains(curList)) {
                res.add(new ArrayList<Integer>(curList));
            }
            backTrace(nums, curList, i + 1, res);
            curList.remove(curList.size() - 1);
        }
    }
}
