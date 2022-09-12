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
        if(head==null) {
            return new int[0];
        }
        LinkedList<Integer> ll = new LinkedList<>();

        while (head.next!=null ){
            int val = head.val;
            ll.add(0,val);
            head = head.next;
        }
        // 注意这里将List<Integer>转为了int[]
        return ll.stream().mapToInt(Integer::valueOf).toArray();
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





    }
}
