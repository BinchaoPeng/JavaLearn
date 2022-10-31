package leetcode.hot100;

public class Palindromic {
    public static void main(String[] args) {
        String s = "iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz";
        System.out.println(palindromic(s));
    }

    public static String palindromic(String s) {
        /**
         *  使用动态规划
         *  step1，确定状态，问题分割：
         *      当前子串 + 两边相同的字符
         *      s[i:j] = s[i+1:j-1] + s[i]==s[j]
         *      因此需要二维数组来保存状态结果，构建二维数组 is_palindromic[l][l]
         *  step2, 转移方程
         *      is_palindromic[i:j] = is_palindromic[i+1:j-1] && s[i]==s[j]
         *  step3，初始条件和边界
         *  step3.1，初始条件(初始化)
         *      因为，[i+1:j-1]，所以状态转移方程至少是得2个字符才可以+1-1
         *      因此，要额外考虑，空字符、一个字符，即：
         *          if s==“”, return ""
         *          s[i][i] = ture
         *
         *      is_palindromic[i][i+1] 或者，
         *      is_palindromic[i][i-1]，理解为空
         *  step3.2，边界
         *        i，j的边界
         *        i [0,l-1]
         *        j [i, l-1]
         *
         * step4 计算顺序（看转移方程）
         *       i，j 由 i+1，j-1的来，
         *       所以 i 从大到小
         *           j 从小到大
         * final 区间型，使用 start 和 length 记录结果
         *
         */
        if (s == null || "".equals(s)) {
            return "";
        }
        int n = s.length();
        boolean re[][] = new boolean[n][n];

        int start = 0, length = 1;
        // 初始化一个字符的
        for (int i = 0; i < n; i++) {
            re[i][i] = true;
        }
        // 初始化两个字符的,这里要考虑计算顺序
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                re[i][i + 1] = true;
                start = i;
                length = 2;
            }
        }
        // 一般情况，转移方程
        for (int i = n - 3; i >= 0; i--) { // 最多到倒数第三个元素
            for (int j = i + 2; j < n; j++) {

                if (re[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    re[i][j] = true;
                    if (j - i + 1 > length) {
                        start = i;
                        length = j - i + 1;
                    }
                }
                System.out.println("(" + i + ", " + j + ") " + re[i][j]);
            }
        }
        return s.substring(start, start + length);

    }
}
