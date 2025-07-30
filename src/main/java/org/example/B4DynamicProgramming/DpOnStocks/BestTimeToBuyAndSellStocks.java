package org.example.B4DynamicProgramming.DpOnStocks;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class BestTimeToBuyAndSellStocks {
    // Getting the prefix to get the min value as we need to first buy and then sell.
    // First get the min value and then for the entire array get the max difference.
    class Solution {
        public int maxProfit(int[] prices) {
            int prefix[] = new int[prices.length];
            prefix[0] = 100000;
            for(int i=1;i<prices.length;i++){
                prefix[i] = Math.min(prefix[i-1],prices[i-1]);
            }
            System.out.println(Arrays.toString(prefix));
            int max = 0;
            for(int i=prices.length-1;i>=0;i--){
                max = Math.max(max,prices[i]-prefix[i]);
            }
            return max;
        }
    }
}
