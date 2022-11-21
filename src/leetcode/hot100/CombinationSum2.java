package leetcode.hot100;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {3, 1, 3, 5, 1, 1, 5, 3, 3};
        int target = 8;

        List<List<Integer>> re = new CombinationSum2().combinationSum2(candidates, target);
        System.out.println(Arrays.toString(re.toArray()));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> re = new ArrayList<>();
        List<List<Integer>> reTemp = new ArrayList<>();
        backTrace(new ArrayList<Integer>(), re, reTemp, candidates, 0, 0, target);
//        Set<List<Integer>> set = new HashSet<>(re);
//        return new ArrayList<List<Integer>>(set);
        return re;
    }

    public void backTrace(ArrayList<Integer> listCur, List<List<Integer>> re, List<List<Integer>> reTemp, int[] candidates, int start, int targetCur, int target) {

        System.out.println(Arrays.toString(listCur.toArray()) + " " + start + " " + targetCur + " " + target + " " + Arrays.toString(reTemp.toArray()) + " " + Arrays.toString(re.toArray()));
        if (targetCur == target && !re.contains(listCur)) {
            re.add(new ArrayList<>(listCur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 要在listCur为空的时候，去重
            if (i > 0 && listCur.size() == 0 && candidates[i] == candidates[i - 1]) continue;
            targetCur += candidates[i];
            if (targetCur <= target) {
                listCur.add(candidates[i]);
                System.out.println(i + " " + Arrays.toString(listCur.toArray()));
                if (!reTemp.contains(listCur)) { // 中间段去重
                    System.out.println("包含：" + Arrays.toString(listCur.toArray()));
                    reTemp.add(new ArrayList<>(listCur));
                    backTrace(listCur, re, reTemp, candidates, i + 1, targetCur, target);
                }
                listCur.remove(listCur.size() - 1);
                targetCur -= candidates[i];

            }
        }

    }

}
