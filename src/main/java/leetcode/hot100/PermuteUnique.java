package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = new PermuteUnique().permuteUnique(nums);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(nums, new ArrayList<Integer>(), new int[nums.length], res);

        return res;
    }

    private void backTrace(int[] nums, ArrayList<Integer> curList, int[] visited, List<List<Integer>> res) {
        if (curList.size() == nums.length && !res.contains(curList)) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            curList.add(nums[i]);
            backTrace(nums, curList, visited, res);
            curList.remove(curList.size() - 1);
            visited[i] = 0;
        }

    }
}
