package org.example.A13DynamicProgramming.DpOnGrid;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/description/

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
