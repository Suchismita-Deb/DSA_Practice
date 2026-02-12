package org.example.B4DynamicProgramming.Dp02DpOnGrid;

// https://leetcode.com/problems/minimum-falling-path-sum/description/

// Variable Start and Variable End.
// Starting from the first row and ending in last column.

/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]

Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
*/
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
