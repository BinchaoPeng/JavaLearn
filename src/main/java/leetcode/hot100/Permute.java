package leetcode.hot100;

import java.util.*;

public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Permute().permute(nums);
        System.out.println(Arrays.toString(permute.toArray()));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        backTrace(new ArrayList<Integer>(), nums, re, new int[nums.length]);
        return re;
    }


    public void backTrace(List<Integer> curList, int[] nums, List<List<Integer>> re, int[] visited) {
        /**
         * 这里使用visited做访问标记
         * 很好的避免了list的拷贝问题，和遍历时因为回溯的增删问题
         */
        // 遍历rest 直到rest为空 就添加
        System.out.println(Arrays.toString(curList.toArray()) + " " + Arrays.toString(visited) + " " + Arrays.toString(re.toArray()));
        if (curList.size() == nums.length) {
            re.add(new ArrayList<>(curList)); //注意这里要深拷贝
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            curList.add(nums[i]);
            backTrace(curList, nums, re, visited);
            visited[i] = 0;
            curList.remove(curList.size() - 1);
        }
    }
}
