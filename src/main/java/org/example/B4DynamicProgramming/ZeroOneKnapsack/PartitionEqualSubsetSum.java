package org.example.B4DynamicProgramming.ZeroOneKnapsack;

import java.util.Arrays;

// https://leetcode.com/problems/partition-equal-subset-sum/description/

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % 2 != 0) return false;
        int n = nums.length;
        int[][] dp = new int[n][(total / 2) + 1]; // k th value need one extra.
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return subsetSumK(nums, total / 2, n - 1, dp);
    }
// Same for the Subset Sum. Here the target is the total/2.
    boolean subsetSumK(int[] nums, int target, int i, int[][] dp) {
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
