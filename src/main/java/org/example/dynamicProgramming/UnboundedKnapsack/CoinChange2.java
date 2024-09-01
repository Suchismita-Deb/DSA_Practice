package org.example.dynamicProgramming.UnboundedKnapsack;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change-ii/description/

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1]; // weight, amount all for the exact number so extra.
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return numOfWays(amount, coins, dp, coins.length - 1);
    }

    int numOfWays(int amount, int[] coins, int[][] dp, int ind) {
        if (ind == 0) {
            if (amount % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[ind][amount] != -1) return dp[ind][amount];
        int notTake = numOfWays(amount, coins, dp, ind - 1);
        int take = 0; // initilaize the ways of taking the number as 0.
        if (coins[ind] <= amount) {
            // not adding the coin value only changing the amount.
            take = numOfWays(amount - coins[ind], coins, dp, ind);
        }
        return dp[ind][amount] = take + notTake;
    }
}