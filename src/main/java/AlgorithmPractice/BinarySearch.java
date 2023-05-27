package AlgorithmPractice;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 3, 3, 5, 8, 11, 16};
        int reIdx = new BinarySearch().binarySearch(A, 3);
        System.out.println(reIdx);
    }

    public int binarySearch(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            System.out.println("s:("+start+", "+A[start]+") e:("+end+", "+A[end]+") m:("+mid+", "+A[mid]+")");
            if (A[mid] == target) {
//                // 找 first
//                end = mid;
                // 找 last
                start = mid;

            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        // 循环结束，结果可能在start中，也可能在end中，看找first还是last
        System.out.println("s:("+start+", "+A[start]+") e:("+end+", "+A[end]+")");
        if (A[end] == target) {
            return end;
        }
        if (A[start] == target) {
            return start;

        }

        return -1;
    }


}


class BSTemplete {
    public int binarySearch(int[] nums, int target) {
        if (nums == null && nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        // 用start + 1 < end而不是start < end的目的是为了避免死循环
        // 在first position of target的情况下不会出现死循环
        // 但是在 last position of target的情况下会出现死循环
        // 样例:nums=[1,1] target = 1  会一直start=end，但不移动
        // 为了统一模板，我们就都采用start + 1 < end，就保证不会出现死循环
        while (start + 1 < end) {
            // python没有_overflow的问题,直接/2就可以了2
            // java和C++最好写成mid-start+(end-start)/2
            // 防止在 start=2^31-1,end=2^31-1的情况下出现 加法 overflow
            int mid = start + (end - start) / 2;
            // > , =,<的逻辑先分开写，然后在看看=的情况是否能合并到其他分支里
            if (nums[mid] < target) {
                /*
                注意：最好不写 +1 或者 -1，因为在找比target大的最小数时，这样会报错，此时nums中可能不含target！！！
                 */
                // 写作start = mid + 1也是正确的
                // 只是可以偷懒不写，因为不写也没问题，不会影响时间复杂度
                // 不写的好处是,万一你不小心写成了mid - 1你就错了
                start = mid;
            } else if (nums[mid] == target) {
                // 二选一
                end = mid; // 用于找 first position
                start = mid; // 用于找 last position
            } else {
                // 写作end = mid - 1也是正确的
                // 只是可以偷懒不写，因为不写也没问题，不会影响时间复杂度
                // 不写的好处是，万一你不小心写成了mid +1你就错了
                end = mid;

            }
        }
        // 因为上面的循环退出条件是start +1 < end
        // 因此这里循环结束的时候，start和end 的关系是【相邻关系】（1和2，3和4这种)
        // 因此需要再单独判断start和end这两个数谁是我们要的答案
        // 如果是找 first position of target就先看start，否则就先看end
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}