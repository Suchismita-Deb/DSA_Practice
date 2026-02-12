package org.example.B4DynamicProgramming.Dp02DpOnGrid;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/description/

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28
*/
public class GridUniquePath {
    class Solution {
        public int uniquePaths(int m, int n) {
            // Unique ways the robot can reach to the bottom from the starting point.

            int[][] dp = new int[m][n];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return path(m - 1, n - 1, dp);
        }

        int path(int i, int j, int[][] dp) {
            // When the return type is int then the base condition should return 1 or 0.
            if (i < 0 || j < 0) return 0;
            // Base case it is able to reach starting point.
            if (i == 0 && j == 0) {
                return 1;
            }
            if (dp[i][j] != -1) return dp[i][j];
            // Count the total ways so adding the number of ways from the left and the top.
            return dp[i][j] = path(i - 1, j, dp) + path(i, j - 1, dp);
        }
    }

    class Tabulation {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int[] i : dp)
                Arrays.fill(i, 1);
            if (m == 1 && n == 1) return 1;
            // dp[0][0] = 1;
            // dp[1][0] = 1;
            // dp[0][1] = 1;
            for (int i = 1; i < m; i++)
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            return dp[m - 1][n - 1];
        }
    }
}
