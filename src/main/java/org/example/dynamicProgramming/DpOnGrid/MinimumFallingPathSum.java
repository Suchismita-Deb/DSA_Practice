package org.example.dynamicProgramming.DpOnGrid;

// https://leetcode.com/problems/minimum-falling-path-sum/description/

// Variable Start and Variable End.
// Starting from the first row and ending in last column.
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        // Following the base case of the method.
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int left = matrix[i][j];
                if (j < 1) left += (int) 1e8;
                else {
                    left += dp[i - 1][j - 1];
                }
                int right = matrix[i][j];
                if (j >= matrix[0].length - 1)
                    // need to do j+1 so have to check that j+1 should not go out of the m.
                    right += (int) 1e8;
                else right += dp[i - 1][j + 1];
                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }
        int min = (int) 1e8;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }
}
