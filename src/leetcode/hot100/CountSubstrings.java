package leetcode.hot100;


// 求字符串中回文串的个数
public class CountSubstrings {
    public static void main(String[] args) {
        int a = new CountSubstrings().countSubstrings("a");
        System.out.println(a);
    }

    public int countSubstrings(String s) {
        // 动态规划法
        // 转移方程 和 计算顺序（两层循环，先遍历确定end，再根据end遍历start）
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        System.out.println(dp[0][0]);
        return ans;
    }

    public int count(String s) {
        // 中心扩展法
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // left和right指针和中心点的关系是？
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // 大致的关系出来了，可以选择带两个特殊例子进去看看是否满足。
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

}
