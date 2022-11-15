package leetcode.hot100;

import java.util.*;

public class CombinationSum {
    class Note {
        public List<Integer> resTemp;
        public Integer curSum;

        public Note() {
        }

        public Note(List<Integer> resTemp, Integer curSum) {
            this.resTemp = resTemp;
            this.curSum = curSum;
        }

        public String toString() {
            return "(" + Arrays.toString(resTemp.toArray()) + ", " + curSum + ")";
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = new CombinationSum().combinationSum(nums, target);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Queue<Note> queue = new LinkedList<>();

        List<Integer> listTem = null;

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            listTem = new ArrayList<>();
            listTem.add(candidates[i]);
            if (candidates[i] == target) {
                res.add(listTem);
                continue;
            }

            Note note = new Note(listTem, candidates[i]);
            queue.add(note);
        }
        System.out.println(Arrays.toString(queue.toArray()));

        while (!queue.isEmpty()) {
            Note element = queue.poll();
            listTem = element.resTemp;

            for (int i = 0; i < candidates.length; i++) {
                if (candidates[i] + element.curSum > target) {
                    break;
                }
                List<Integer> list = new ArrayList<>();
                list.addAll(listTem);
                System.out.println(list);
                list.add(candidates[i]);
                if (candidates[i] + element.curSum == target) {
                    // store
                    Collections.sort(list);
                    if (!res.contains(list)) {
                        res.add(list);
                    }
                    continue;
                }

                queue.add(new Note(list, element.curSum + candidates[i]));

                System.out.println(Arrays.toString(queue.toArray()));
            }

        }

        // 去重
//        Collections.set
        return res;


    }

    public void dfs(int[] candidates, int target, List<List<Integer>> res) {


    }
}
