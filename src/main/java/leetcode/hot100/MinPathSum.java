package leetcode.hot100;

import java.util.Arrays;

public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        new MinPathSum().minPathSum(grid);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] reTemp = new int[m][n];
        reTemp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            // 最上边的数
            reTemp[i][0] = reTemp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            // 最左边的数
            reTemp[0][j] = reTemp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                reTemp[i][j] = Math.min(reTemp[i - 1][j], reTemp[i][j - 1]) + grid[i][j];
            }
        }

        for (int[] r : reTemp) {
            System.out.println(Arrays.toString(r));
        }

        return reTemp[m - 1][n - 1];
    }
}
