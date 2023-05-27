package leetcode.hot100;

public class MaxArea {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int s = new MaxArea().maxArea(height);
        System.out.println(s);
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int s = 0;
        while (i < j) {
            int sTemp = (j - i) * Math.min(height[i], height[j]);
            System.out.println(i + "," + j + "," + sTemp);
            if (sTemp > s) {
                s = sTemp;
            }
            // next step
            if (height[i] == height[j]) {
                i++;
                j--;
            } else if (height[i] > height[j]) {
                while (i < j && height[j] > height[--j]) ;
            } else {
                while (i < j && height[i] > height[++i]) ;
            }
        }
        return s;
    }
}
