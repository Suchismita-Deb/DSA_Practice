package org.example.B4DynamicProgramming.UnboundedKnapsack;

// https://leetcode.com/problems/coin-change/

// [1,3,4,5] |Target = 7. Output - 2(3,4). We have infinite supply of the coin.
// it is not greedy then we sort and get the max like (5,1,1) and output - 3.

import java.util.Arrays;

// Brute Force then some backtrack. In the array we have 4 options like take 1,3,4,5 then val =
public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // Filling the array for the amount values.
            // [1,3,4,5] Amount = 7. Output = 2(4,3)
            // dp[0] = 0.
            // dp[1] = 1. (One already present in the coins.)
            // dp[2] = 1 + dp[1].
            // dp[3] = 1 + dp[2] (taking one 1 value coin and remaining amount 3-1 = 2)
            //       = 1 (taking one 3 value coin.)
            // dp[4] = 1 + dp[3] (taking one 1 value coin and remaining amount 4-1 = 3)
            //       = 1 + dp[1] (taking one 3 value coin and remaining amount 4-3 = 1)
            //       = 1 (taking one 4 value coin) considering the min of all the option.
            // dp[5] = Math.min(1+dp[4], 1+dp[2], 1+dp[4], 1)
            // dp[6] = Math.min(1+dp[5], 1+dp[3], 1+dp[2], 1+dp[1])
            // dp[7] = Math.min(1+dp[6], 1+dp[4], 1+dp[3], 1+dp[2])
            if (coins.length == 0 || amount < 0)
                return 0;
            int dp[] = new int[amount + 1];
            Arrays.fill(dp, amount + 1); // Filling the array with max value or any value that is not possible.
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                        // Checking for all the value in coins and checking the min and storing it in dp[i];
                    }
                }
            }
            return dp[amount] != amount + 1 ? dp[amount] : -1;
        }
    }
}
