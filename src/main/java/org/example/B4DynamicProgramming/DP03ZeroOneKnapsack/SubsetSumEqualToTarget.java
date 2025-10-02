package org.example.B4DynamicProgramming.DP03ZeroOneKnapsack;

import java.util.Arrays;

// 4 5
// 4 3 2 1
// Output - true.
// 5 4
// 2 5 1 6 7
// Output - false.
// https://www.naukri.com/code360/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0&leftPanelTabValue=PROBLEM
// Same is used in partition subset sum.
public class SubsetSumEqualToTarget {
    class Solution {
        public static boolean subsetSumToK(int n, int k, int[] arr) {
            // Write your code here.
            int[][] dp = new int[n][k + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return subsetSumK(arr, k, n - 1, dp);
        }

        static boolean subsetSumK(int[] nums, int target, int i, int[][] dp) {
            if (target == 0) return true;

            if (i == 0) return nums[0] == target;
            if (dp[i][target] != -1)
                return dp[i][target] != 0; // cannot directly retirn dp[i][target] as return type is boolean
            // so adding the condition.

            // dp should be of int as it is like visited array so need to check for the
            // condition and it cannot be as false.
            boolean op1, op2 = false; // initially value as false;
            op1 = subsetSumK(nums, target, i - 1, dp);// not take
            if (nums[i] <= target)
                op2 = subsetSumK(nums, target - nums[i], i - 1, dp); // take. function return type boolean so cant add any
            // value will reduce the target.
            dp[i][target] = op1 || op2 ? 1 : 0;// adding the value.
            return op1 || op2; // any of the condition is true.
        }
    }
}
