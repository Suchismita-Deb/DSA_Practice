package org.example.dynamicProgramming.UnboundedKnapsack;

import java.util.Arrays;

public class KnapSackUnbound {
    static int knapsackUnbound(int[] weight, int[] value, int n, int maxWeight) {
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
            op1 = value[ind] + maxSum(weight, value, maxWeight - weight[ind], ind, dp); // After taking will not reduce the index. We can take more than one time. Imp for Unbound.
        }
        // To not pick the item.
        int op2 = maxSum(weight, value, maxWeight, ind - 1, dp);
        return dp[ind][maxWeight] = Math.max(op1, op2);
    }
}
