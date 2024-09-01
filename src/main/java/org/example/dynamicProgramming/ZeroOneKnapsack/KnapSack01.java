package org.example.dynamicProgramming.ZeroOneKnapsack;

import java.util.Arrays;

// wt - 1 2 4 5
// val -5 4 8 6
// maxWeight - 5
// Output - 13
public class KnapSack01 {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxSum(weight, value, maxWeight, n - 1, dp);
    }

    static int maxSum(int[] weight, int[] value, int maxWeight, int ind, int[][] dp) {
        if (ind < 0) return 0;
        if (ind == 0) return (weight[0] <= maxWeight) ? value[0] : 0;
        if (dp[ind][maxWeight] != -1) return dp[ind][maxWeight];
        // Option to take.
        int op1 = 0;
        if (weight[ind] <= maxWeight) {
            op1 = value[ind] + maxSum(weight, value, maxWeight - weight[ind], ind - 1, dp);
        }
        // To not pick the item.
        int op2 = maxSum(weight, value, maxWeight, ind - 1, dp);
        return dp[ind][maxWeight] = Math.max(op1, op2);
    }
}