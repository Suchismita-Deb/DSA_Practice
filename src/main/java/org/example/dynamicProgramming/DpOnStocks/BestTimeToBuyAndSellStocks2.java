package org.example.dynamicProgramming.DpOnStocks;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

// More than one transaction and can hold only one stock at a time.
// If buy one time then first sell then buy another one.

public class BestTimeToBuyAndSellStocks2 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp[][] = new int[n][2];
            // 2 as the value can be either 0 or 1.
            // If 0 then cannot buy and already holding one.
            // If 1 then can buy.
            for (int row[] : dp) {
                Arrays.fill(row, -1);
            }
            return maxProfitValue(prices, 0, dp, 1);
        }

        int maxProfitValue(int prices[], int ind, int dp[][], int option) {
            // Base case. Reached the end still holding somevalue.
            if (ind == prices.length)
                return 0;
            if (dp[ind][option] != -1)
                return dp[ind][option];
            int profit = 0;
            // Option to buy the stocks.
            if (option == 1) { // Buy.
                profit = Math.max(-prices[ind] + maxProfitValue(prices, ind + 1, dp, 0),
                        maxProfitValue(prices, ind + 1, dp, 1));
                // 2 options like can buy and want to explore the option to buy and not to buy.
                // First part pick meaning cant buy so option is 0 and other part can buy so
                // option is 1.
                // Buy meaning the value is invested. Say buy at 5 and sell at 7 meaning 7-5.
            } else {
                profit = Math.max(prices[ind] + maxProfitValue(prices, ind + 1, dp, 1),
                        maxProfitValue(prices, ind + 1, dp, 0)); // First part sell so now I can again buy and other part
                // not sell so cannt buy as it is holding.
            }
            return dp[ind][option] = profit;
        }
    }
}
