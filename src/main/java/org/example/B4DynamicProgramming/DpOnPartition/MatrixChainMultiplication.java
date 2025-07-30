package org.example.B4DynamicProgramming.DpOnPartition;

import java.util.Arrays;

public class MatrixChainMultiplication {
    class Solution {
        public static int matrixMultiplication(int[] arr, int N) {
            // 0, 1, 2, 3, 4
            // 10,20,30,40,50
            //     i        j
            // i from 1 to j (n-1)
            // Changing variable are i and j and value can go at max to (0 to N-1) and dp[N][N].
            int[][] dp = new int[N][N];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return matrix(1, N - 1, arr, dp);
        }

        static int matrix(int i, int j, int[] arr, int[][] dp) {
            if (i == j) return 0;
            if (dp[i][j] != -1) return -1;
            int minStep = (int) 1e9;
            for (int k = i; k < j; k++) {
                int steps = (arr[i - 1] * arr[k] * arr[j]) + matrix(i, k, arr, dp) + matrix(k + 1, j, arr, dp);
                if (steps < minStep) minStep = steps;
            }
            return dp[i][j] = minStep;
        }
    }
}
