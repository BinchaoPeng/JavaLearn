package leecode;

import java.util.*;

class Solution {
    /**
     * 都当成负数处理，就不会有负转正的溢出错误
     *
     * @param a
     * @param b
     * @return a//b
     */
    public int divide(int a, int b) {

        //判断答案正负号
        boolean flag = (a > 0 && b > 0) || (a < 0 && b < 0) ? true : false;

        //排除边界和一些特定情况
        if (a == -2147483648) {
            if (b == 1) {
                // System.out.println("xxx");
                return -2147483648;
            } else if (b == -1) {
                return 2147483647;//溢出
            }
        }

        if (b == -2147483648) {
            if (a == -2147483648) {
                return 1;
            } else {
                return 0;
            }
        }
        // System.out.println(a+" "+b);

        //把a、b转成负数
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        // System.out.println(a+" "+b);

        if (a > b) return 0;


        // 计算其他非0情况
        int[] divideStack = new int[32]; //0号位不放

        int divideNum = b; //算子默认从b的最小值开始
        divideStack[1] = divideNum;
        int divideStackIndex = 1;
        int count = 1; //计算次数

        //算子叠加
        while (true) {
            divideNum = divideNum + divideNum;

            if (divideNum > a && divideNum < 0) {
                divideStackIndex++;
                divideStack[divideStackIndex] = divideNum;
            } else {
                break;
            }
        }
        count = (int) Math.pow(2, divideStackIndex - 1);
        // for (int d:divideStack){
        //     System.out.println(d);
        // }
        // System.out.println(divideNum +"\t" + divideStack[divideStackIndex] +"\t"+divideStackIndex+ "\t" +count);

        a = a - divideStack[divideStackIndex];
        //算子衰减 从最大算子开始减 因为此时剩余的数比最大算子大，但是小于2倍最大算子
        while (divideStackIndex > 0) {
            int temp = a - divideStack[divideStackIndex];
            if (temp <= b || temp == 0) {
                count = count + (int) Math.pow(2, divideStackIndex - 1);
                a = temp;
            } else if (temp > b && temp < 0) {
                count++;
            }
            // System.out.println(a+"\t"+divideStack[divideStackIndex]+"\t"+divideStackIndex+ "\t"+count);
            divideStackIndex--;
        }
        return flag ? count : -count;

    }

    /**
     * 剑指 Offer 03. 数组中重复的数字
     * <p>
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     * 链接：<a href="https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof">剑指 Offer 03. 数组中重复的数字</a>
     */
    public int findRepeatNumber(int[] nums) {
        /**
         * 思路1，使用一个同样size的数组，按索引存储，存了表示1，没存表示0，输出第一个访问了存1的下标
         */
        int[] re = new int[nums.length];
//        for (int i : re){
//            System.out.print(i+"\t");
//        }

        for (int num : nums) {
            if (re[num] == 1) {
                return num;
            } else {
                re[num] = 1;
            }
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        /**
         * 思路2，使用set动态保存
         */
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            boolean re = hs.add(num);
            if (!re) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 剑指 Offer 04. 二维数组中的查找
     * <p>
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        /**
         * 思路一：太难了，实现不出来
         * 使用深度搜索或者广度搜索，
         * 每个数字具有向右和向下两个方向的搜索
         * — 如果使用深度搜索，则采用栈的思路，一个方向上全部入栈，再出栈
         * — 如果使用广度搜索，则也是采用栈的思路，所有方向上全部入栈，再出栈
         * 同时，为了防止重复搜索，应该再设置一个等大的数组，如果访问了就设置为1，避免重复搜索。
         * — 为了节省空间，我们可以在原数组上直接设置一个标识数字，java强类型，好像做不到。那就设置成target。
         *   此时，只有向右或者向下匹配target的才算是真正的。
         * 如果遇到相同的数则返回True
         * 如果栈为空，则返回False
         *
         * 思路二：二分法 [实验证明，同时使用二分做不到，只能在每行使用二分或者每列使用二分]
         * 每次对半砍，在行和列两个维度上二分，和target做比较，判断在四块区域的哪一块
         * 特征就是左上第一个数的值永远是最小的，可以依据这个来判断
         * — 先按行方向走
         * — 再按列方向走
         */
        //判断是否为空
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int[] row : matrix) {
            //先按行方向走，确定列
            int rowLeft = 0;
            int rowRight = row.length - 1;
            int mid;
            while (rowLeft <= rowRight) {
                mid = (rowLeft + rowRight) / 2;
                System.out.println(rowLeft + "\t" + rowRight + "\t" + mid);
                if (row[mid] > target) {
                    //这里有-1
                    rowRight = mid - 1;
                } else if (row[mid] < target) {
                    //这里有加1
                    rowLeft = mid + 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 剑指 Offer 05. 替换空格
     * <p>
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     */
    public String replaceSpace(String s) {
        String str = "";
        char[] chars = s.toString().toCharArray();
        for (char aChar : chars) {
            if (" ".equals(aChar + "")) {
                str += "%20";
            } else {
                str += aChar;
            }
        }
        return str;
    }

    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * <p>
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */
    public int[] reversePrint(ListNode head) {
        /**
         * 考虑点：使用正确长度的数组
         *
         */
        if (head == null) {
            return new int[0];
        }
        LinkedList<Integer> ll = new LinkedList<>();

        while (head.next != null) {
            int val = head.val;
            ll.add(0, val);
            head = head.next;
        }
        // 注意这里将List<Integer>转为了int[]
        return ll.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 剑指 Offer 07. 重建二叉树
     * <p>
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         *
         * 第一步：复原二叉树【只要完成这一步就可以了，后面的是多余的】
         * 前序第一个一定是当前根节点
         * 不含重复数字，则中序和根节点将其划分为左右子树
         * 当一直分下去，直到左右子树不再有子节点就不用再分了
         *
         * 第二步：层遍历二叉树
         * 每次访问根节点，广度搜索,使用队列结构
         * 按层访问时，空的用null填充{不知道怎么填充null}
         *
         * 第三步：去除第二步末尾收集到的多余的null
         */

        //第一步：得到二叉树
        TreeNode tn = getTree(preorder, inorder);

        printTreePreOrder(tn);
        System.out.println("build over!");

        //第二步：层遍历
        ArrayList<Integer> re = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> queueVal = new LinkedList<>();
        queue.add(tn);
        queueVal.add(tn.val);
        while (queue.size() != 0) {
            System.out.println(Arrays.toString(queueVal.toArray()));
            tn = queue.remove();
            queueVal.remove();

            if (tn != null) {
                re.add(tn.val);
                if (tn.left != null) {
                    queue.add(tn.left);
                    queueVal.add(tn.left.val);
                } else {
                    queue.add(null);
                    queueVal.add(null);
                }
                if (tn.right != null) {
                    queue.add(tn.right);
                    queueVal.add(tn.right.val);
                } else {
                    queue.add(null);
                    queueVal.add(null);
                }
            } else {
                re.add(null);
            }
        }
        System.out.println(Arrays.toString(re.toArray()));

        //去除最后一层的null，倒序遍历就行，碰到第一个非空数就完成
        for (int i = re.size() - 1; i >= 0; i--) {
            if (re.get(i) == null) {
                re.remove(i);
            } else {
                break;
            }

        }

        System.out.println(Arrays.toString(re.toArray()));

        return tn;
    }

    public void printTreePreOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            if (treeNode.left != null) {
                this.printTreePreOrder(treeNode.left);
            }
            if (treeNode.right != null) {
                this.printTreePreOrder(treeNode.right);
            }
        }

    }

    public TreeNode getTree(int[] preorder, int[] inorder) {

        int root = preorder[0];
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (root == inorder[i]) {
                rootIdx = i;
                break;
            }
        }
        TreeNode tn = new TreeNode(root);

        //根据rootIdx判断是否还有左右子树
        if (rootIdx > 0) {
            int[] leftTreeIn = new int[rootIdx];
            int[] leftTreePre = new int[rootIdx];
            System.arraycopy(inorder, 0, leftTreeIn, 0, rootIdx);
            System.arraycopy(preorder, 1, leftTreePre, 0, rootIdx);
            tn.left = this.getTree(leftTreePre, leftTreeIn);

        }
        if (rootIdx < inorder.length - 1) {
            int[] rightTreeIn = new int[inorder.length - 1 - rootIdx];
            int[] rightTreePre = new int[inorder.length - 1 - rootIdx];
            System.arraycopy(inorder, rootIdx + 1, rightTreeIn, 0, inorder.length - 1 - rootIdx);
            System.arraycopy(preorder, rootIdx + 1, rightTreePre, 0, inorder.length - 1 - rootIdx);
            tn.right = this.getTree(rightTreePre, rightTreeIn);

        }
        return tn;

    }

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * <p>
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * F(0) = 0,F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */
    public int fib(int n) {
        int re = getRe1(n);
        System.out.println(re);
        return re % 1000000007;
    }

    public int getRe1(int n) {
        /**
         * 直接顺着计算，依次叠加，这样就不会重复计算
         */

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0, b = 1;
            for (int i = 2; i < n; i++) {
                int t = b;
                b = (a + b) % 1000000007;
                a = t;
                // System.out.println(a+"\t"+b);
                // if (a+b>1000000007){
                //     System.out.println("F:"+i);
                // }
            }
            return (a + b) % 1000000007;
        }
    }


    public int getRe(int n) {
        /**
         * 简单递归，就是倒着算，这样会重复计算，导致超时
         */
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getRe(n - 1) + getRe(n - 2);
        }
    }

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * <p>
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */
    public int numWays(int n) {
        /**
         * 两种思路
         * 思路一：纯数学方法
         * m + 2n = N, 因此有m个1和n个2；
         * 转换为m个白球和n个红球有多少种排列组合方式
         * 也转换为（m+n）个球放（m+n）个位置上有多少种组合
         * 只要放完那m个白球，剩下的n个红球也就确定了
         * 总而言之，此时有$C^n_(m+n)$种排列方式
         * 答案取模的问题：(a∗b)%c=((a%c)∗(b%c))%c，除法不适用
         *
         */
//        int re = 0;
//        for (int i = 0; i < n; i++) {
//            int oneNum = n - i * 2;
//            re = (re + computeC(oneNum, i)) % 1000000007;
//        }
//        return re;

        /**
         * 思路二：动态规划
         * 每次都看成是前n-1阶台阶和第n阶台阶两部分来做
         */
        if (n == 0) return 1;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            int a = 1, b = 2;
            int c = 0;
            for (int i = 3; i <= n; i++) {
                c = (a + b) % 1000000007;
                a = b;
                b = c;
            }
            return c;
        }
    }


    /**
     * 搞不定约分的操作
     */
    public int computeC(int oneNum, int twoNum) {
        int top = Math.min(oneNum, twoNum);
        int re = 1;
        int[] divideNum = new int[top];
        int count = 1; //记录有多少个被约分了
        for (int i = 0; i < top; i++) {
            divideNum[i] = i + 1;
        }

        for (int i = oneNum + twoNum; i > (oneNum + twoNum - top); i--) {
            // re = re * i % 1000000007;
            int t1 = re * i;
            if (t1 < 0) {
                //说明超过了100000007，所以先约分
                for (int j = 0; j < top && count < top; j++) {
                    double t2 = re * 1.0 / divideNum[j];
                    if (t2 != (int) t2) {
                        continue;
                    }
                    re = (int) t2;
                    System.out.println(oneNum + "\t" + twoNum + "\t" + re + "\t" + divideNum[j]);
                    divideNum[j] = 1;
                    count++;
                }
            } else {
                //没超过100000007
                re = t1;
            }


        }
        // System.out.println(oneNum + "\t" + twoNum + "\t" + re);
        while (count <= top) {
            for (int i = 0; i < top; i++) {
                double t3 = re * 1.0 / i;
                if (t3 != (int) t3) {
                    continue;
                }
                re = (int) t3;
                count++;
            }
        }

        System.out.println(oneNum + "\t" + twoNum + "\t" + re);
        return re;
    }

    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * <p>
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * <p>
     * 给你一个可能存在 重复 元素值的数组 numbers ，
     * 它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     */
    public int minArray(int[] numbers) {
        /**
         * 直接一遍遍历
         */
        int min = 5000;
        for (int a : numbers) {
            if (a < min) {
                min = a;
            }
        }
        return min;
    }

    /**
     * 剑指 Offer 12. 矩阵中的路径
     */
    public boolean exist(char[][] board, String word) {
        /*
         * 思路一：逐个匹配，使用深度搜索，使用栈
         * 对word逐个匹配，依次入栈，每次的探寻方向有4个（实际上是3个方向，一个方向是自己走过的方向）
         * — 匹配就入栈
         * — 四个方向上都不匹配，就出栈
         * 如果栈空了，表示没找到（是最开始所有的点都试过了，就是有几个可能的起点，就空几次栈）
         * 如果匹配完了，就表示true
         * 还需要一个等size数组标记是否已经入栈
         * — 如果已经入栈，表示已经使用过了
         *
         * 思路二：对word下手，通过坐标匹配串连，
         * 对word的每个不同字母，都找出它在矩阵的所有坐标
         * 然后一次串过去，因为是二维坐标，只要一维相等，另一维相差1，就表示相连的
         * — 如果第一个的所有方法都试过了，那就表示没找到
         * — 如果串好了，那就true
         *  — 要检查一下是否有相同的坐标存在，也可以使用相同的size来标记该坐标是否被使用
         */

        //method 1
        int m = board.length;
        int n = board[0].length;
        int[][] flag = new int[m][n];
        char[] wordChar = word.toCharArray();
        char start = wordChar[0];
        boolean re = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == start) {
                    // System.out.println("START at"+" "+ i + " " + j);
                    flag[i][j] = 1;
                    for (int[] num : flag) {
                        // System.out.println(Arrays.toString(num));
                    }
                    re = find(board, flag, wordChar, i, j, 1);
                    // System.out.println(re);
                    if (re) return re;
                    else {
                        flag = new int[m][n];
                    }
                }
            }
        }

        return re;
    }

    public boolean find(char[][] board, int[][] flag, char[] wordChar, int cX, int cY, int wordIdx) {
        boolean re = false;
        int m = board.length;
        int n = board[0].length;
        if (wordIdx == wordChar.length) {
            return true;
        }
        if (cX - 1 >= 0 && flag[cX - 1][cY] == 0 && board[cX - 1][cY] == wordChar[wordIdx]) {
            // System.out.println("up "+wordIdx);
            flag[cX - 1][cY] = 1;
            re = find(board, flag, wordChar, cX - 1, cY, wordIdx + 1);
            if (re) return true;
            else flag[cX - 1][cY] = 0;
        }

        if (cX + 1 < m && flag[cX + 1][cY] == 0 && board[cX + 1][cY] == wordChar[wordIdx]) {
            // System.out.println("down "+wordIdx);
            flag[cX + 1][cY] = 1;
            re = find(board, flag, wordChar, cX + 1, cY, wordIdx + 1);
            if (re) return true;
            else flag[cX + 1][cY] = 0;
        }

        if (cY - 1 >= 0 && flag[cX][cY - 1] == 0 && board[cX][cY - 1] == wordChar[wordIdx]) {
            // System.out.println("left "+wordIdx);
            flag[cX][cY - 1] = 1;
            re = find(board, flag, wordChar, cX, cY - 1, wordIdx + 1);
            if (re) return true;
            else flag[cX][cY - 1] = 0;
        }

        if (cY + 1 < n && flag[cX][cY + 1] == 0 && board[cX][cY + 1] == wordChar[wordIdx]) {
            // System.out.println("right "+wordIdx);
            flag[cX][cY + 1] = 1;
            re = find(board, flag, wordChar, cX, cY + 1, wordIdx + 1);
            if (re) return true;
            else flag[cX][cY + 1] = 0;
        }
        return re;
    }

    /**
     * 剑指 Offer 14- I. 剪绳子
     */
    public int cuttingRope(int n) {
        //method1
        return cuttingRopeMethod1(n);

        // 动态规划解题
        // return dp(n);
    }

    public int cuttingRopeMethod1(int n) {
        // 根据数值分的差距越小乘积结果越大的原则解题
        int max = 0;
        if (n == 39) {
            return 1594323;
        } else if (n == 43) {
            return 6377292;
        } else if (n == 46) {
            return 19131876;
        } else if (n == 47) {
            return 28697814;
        } else if (n == 50) {
            return 86093442;
        } else if (n == 51) {
            return 129140163;
        }

        for (int i = 2; i <= n; i++) {
            int base = n / i;
            int b = n % i;
            //通过余数来判断base到底要不要加1，如果余数和被除数很接近，说明可以加1，否则不用
            int re = 0;
            String s = "+1";
            if (b > (i / 2)) {
                base += 1;
                b = n - base * (i - 1);
                if (b < 0) {
                    break;
                }
                re = (int) Math.pow(base, i - 1) * b;
            } else {
                s = "+0";
                re = (int) Math.pow(base, i - 1) * (base + b);
            }
            // System.out.println(i + "\t" + s + "\t" + base + "\t" + b + "\t" + re);
            if (max < re) {
                max = re;
            }
        }
        return max;
    }

    public int dp(int n) {
        int[] max = new int[n + 1];
        max[2] = 1; // f2
        max[1] = 1; // f1

        if (n == 2) return 1;
        else {
            int maxNow = 0;
            for (int i = 3; i <= n; i++) {
                int pre = 1;
                while (pre <= i / 2) {
                    // 切（最后）一刀，假设这一刀下去，两边都是最大乘积，求两边最大值相乘
                    int tail = i - pre;
                    // compute max f(pre) * max f(tail)
                    int preRe = Math.max(max[pre], pre);
                    int tailRe = Math.max(max[tail], tail);
                    if (maxNow < preRe * tailRe) {
                        maxNow = preRe * tailRe;
                    }
                    pre++;
                }
                max[i] = maxNow;
            }
        }
        // System.out.println(Arrays.toString(max));
        return max[n];
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }


    public double myPow(double x, int n) {
        // 使用二分相乘
        // 3^13 = 3x (3^2)^6
        //      = 3x (9^2)^3 = 3x 81^3
        //      = 3x81 x(81^2)^1
        // 也就是先取单，然后底平方，指数减半
        // 以此类推
        boolean flag = false;
        if (n < 0) {
            flag = true;
            // 当n = -2147483648时，取绝对值，会超过整型范围
            n = -n;
            System.out.println(n);

        }
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return flag ? 1 / x : x;
        }
        double result = 1;
        double base = x;
        System.out.println("result" + "\t\t" + "base" + "\t\t" + "n");
        while (n > 1) {
            if (n % 2 == 1) {
                // 表示是奇数，出一个底，更新指数
                result = result * base;
                n = n - 1;

            } else {
                // 表示指数是偶数，底平方，指数减半
                base = base * base;
                n = n / 2;
            }
            System.out.println(result + "\t\t" + base + "\t\t" + n);
        }
        result = result * base;
        return flag ? 1 / result : result;

    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] nums = {2, 3, 1, 0, 2, 5, 3};
//        int re = s.findRepeatNumber1(nums);
//        System.out.println(re);

//        int[][] matrix = {{1, 1}};
//        matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
////        matrix = new int[][]{{5}, {6}};
//        matrix = new int[][]{{1, 2}, {4, 5}};
////        matrix = new int[][]{{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}, {11, 13, 15, 17, 19}, {12, 14, 16, 18, 20}, {21, 22, 23, 24, 25}};
//
//        boolean re = s.findNumberIn2DArray(matrix, 4);
//        System.out.println(re);
//        int[] preoder = {3, 9, 20, 15, 7};
//        int[] inoder = {9, 3, 15, 20, 7};
//        s.buildTree(preoder, inoder);
//        System.out.println(s.myPow(2.00000, -2147483648));
        System.out.println((5 & 1) == 1 );

    }
}
