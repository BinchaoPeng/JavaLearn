package leetcode.hot100;

/*
33. 搜索旋转排序数组
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 1};
        int idx = new Search().search(nums, 3);
        System.out.println(idx);
    }

    /**
     * 采用二分法模板
     * 和最后一个数比较，判断在哪段
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        // 判断是否反转
        boolean flag = nums[start] > nums[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            System.out.println("start:" + start + " ,end:" + end);
            if (!flag) {
                if (nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
                continue;
            }
            // 先判断在哪大段
            if (nums[mid] < nums[end]) {
                // 表示 mid 在 后半段
                // 通过target 判断 移动start 还是 移动end
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (nums[mid] > nums[end]) {
                // 表示 mid 在 前半段
                if (target <= nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                return mid;
            }
        }
        System.out.println("start:" + start + " ,end:" + end);
        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
