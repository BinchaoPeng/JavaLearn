package leetcode.hot100;

public class Trap {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = new Trap().trap(height);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        // 在 i 位置可以装的水 等于 min(maxLeft, maxRight) > height[i]
        // maxLeft 可以通过 max(maxLeft, height[i - 1]) 更新
        // 如果 maxLeft < maxRight，那么结果re根据maxLeft和height[i]就可以确定
        // 反之一样，是个对称的==[具有对称特征]==
        // 因此，采用双指针的思路：左右指针，两边向中间走，
        // 对于left位置，其maxLeft是确定的
        // 对于right位置，其maxRight是确定的
        // left的maxLeft和right的maxRight，总有一方大一方小，就总可以向中间移动其中的一个来推进求解
        // 而我们只要取 较小的 那个max，这样 在较小那边位置 就可以确定他的装水数量

        int sum = 0;
        int maxLeft = height[0], maxRight = height[height.length - 1];  //不能初始化为0，不然有一边会没更新
        int left = 1, right = height.length - 2; // 边界两个不需要，肯定装不了水
        for (int i = 1; i < height.length - 1; i++) {
            System.out.printf("left: %s, right: %s, max(%d, %d) sum: %d\n", left, right, maxLeft, maxRight, sum);
            if (maxLeft < maxRight) {
                // 可以确定left位置 的 蓄水量
                // 先更新max，再移动
                if (maxLeft > height[left]) {
                    // 表示边界的短板 比 当前位置 高
                    // 可以装水
                    sum += (maxLeft - height[left]);
                }
                left++;
                // 否则说明 当前位置更高
                // 在 left+1 的位置的时候，maxLeft就要更新了
                maxLeft = Math.max(maxLeft, height[left - 1]);
            } else {
                // 确定 right位置 的 蓄水量
                if (maxRight > height[right]) {
                    sum += (maxRight - height[right]);
                }
                right--;
                maxRight = Math.max(maxRight, height[right + 1]);
            }
        }
        return sum;
    }
}
