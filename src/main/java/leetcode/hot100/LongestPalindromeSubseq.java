package leetcode.hot100;

// 找出最长回文子串，可删除某些字符
public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        String s = "aaaaaabbbb";
        int i = new LongestPalindromeSubseq().longestPalindromeSubseq(s);
        System.out.println(i);
    }

    public int longestPalindromeSubseq(String s) {
        // 动态规划，找到所有回文子串
        // 打擂台
        int re = 0;
        int l = s.length();
        boolean dp[][] = new boolean[l][l];
        for (int j = 0; j < l; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
//                    System.out.println(i + "," + j);
                    re = Math.max(re, j - i + 1);
                }
            }
        }
        return re;
    }
}
