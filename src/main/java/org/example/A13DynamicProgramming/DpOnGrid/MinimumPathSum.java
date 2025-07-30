package org.example.A13DynamicProgramming.DpOnGrid;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-path-sum/description/
// Starting from the first corner block and ending in the last corner block.
// Starting fixed and Ending Fixed.
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return minPath(grid, n - 1, m - 1, dp);
    }

    int minPath(int[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == 0 && j == 0) return dp[i][j] = grid[i][j];
        if (dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = grid[i][j] + Math.min(minPath(grid, i - 1, j, dp), minPath(grid, i, j - 1, dp));
    }
}
