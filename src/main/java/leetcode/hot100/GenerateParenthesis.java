package leetcode.hot100;

import java.util.*;

public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> l = new GenerateParenthesis().generateParenthesis(3);
        System.out.println(Arrays.toString(l.toArray()));
        System.out.println(l.size());

    }

    /**
     * dfs 方法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        // 先写出没有限制条件的dfs
        // 增加条件，把不符合的提前删除，也就是剪枝
        List<String> l = new ArrayList<>();

        dfs("", n, l, n, n);
        System.out.println(Arrays.toString(l.toArray()));
        return l;
    }

    public void dfs(String s, int n, List<String> list, int pop, int push) {
        if (s.length() == 2 * n) {
            // 表示遍历完了
            list.add(s);
            return;
        }
        // 正常操作，要么左括号，要么右括号
        // 进栈，只有还有进栈机会时才可以进栈
        if (push > 0) {
            dfs(s + "(", n, list, pop, push - 1);
        }
        // 出栈，只有还有出栈机会，且pop > push
        if (pop > 0 && push < pop) {
            dfs(s + ")", n, list, pop - 1, push);
        }
    }

    /**
     * 自己想的，类似枚举
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis_my(int n) {
        // n代表一共有几次入栈机会
        // 也代表可以走多少步

        List<String> l = new ArrayList<>();
        if (n < 1) {
            return l;
        }
        Map<String, int[]> re = new HashMap<>();

        re.put("(", new int[]{n - 1, n});
        Map<String, int[]> reT = new HashMap<>();
        boolean flag = true;
        while (flag) {
            flag = false; // 假设所有的都进栈完了
            for (Object o : re.entrySet()) {
                Map.Entry en = (Map.Entry) o;
                String key = (String) en.getKey();
                int[] val = (int[]) en.getValue();
                int curPop = val[0], curPush = val[1];
                // 两种可能性，出栈或者进栈
                if (curPop > 0) {
                    reT.put(key + '(', new int[]{curPop - 1, curPush});
                    if (curPop - 1 > 0) {
                        // 说明还有进栈机会
                        flag = true;
                    }
                }
                if (curPop < curPush) {
                    // 出栈
                    reT.put(key + ")", new int[]{curPop, curPush - 1});
                    if (curPop > 0) {
                        // 说明还有进栈机会
                        flag = true;
                    }
                }
            }
            re = reT;
            reT = new HashMap<>();
        }


        //取出答案
        for (Object o : re.entrySet()) {

            Map.Entry en = (Map.Entry) o;
            String key = (String) en.getKey();
            int[] val = (int[]) en.getValue();
            int curPop = val[0], curPush = val[1];
            if (curPop == 0 && curPush > 0) {
                // 如果没有了进栈机会，则此时应该补全答案，全数出栈
                for (int i = 0; i < curPush; i++) {
                    key += ")";
                }
//                val[1] = 0;
            }
//            System.out.println(key + "," + Arrays.toString(val));
            l.add(key);
        }

        return l;

    }
}
