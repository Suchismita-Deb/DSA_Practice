package org.example.dynamicProgramming.ZeroOneKnapsack;

import java.util.Arrays;

// https://leetcode.com/problems/target-sum/description/
public class TargetSum {

    // You are given an integer array nums and an integer target. You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
    // For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1". Return the number of different expressions that you can build, which evaluates to target.
    // Input: nums = [1,1,1,1,1], target = 3
    // Output: 5
    // Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
    // -1 + 1 + 1 + 1 + 1 = 3
    // +1 - 1 + 1 + 1 + 1 = 3
    // +1 + 1 - 1 + 1 + 1 = 3
    // +1 + 1 + 1 - 1 + 1 = 3
    // +1 + 1 + 1 + 1 - 1 = 3

    // Attempted.
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int dp[][] = new int[nums.length][1001];
            // Only target is needed as it is not unbound and in all the cases the ind will change.
            for(int row[]:dp)
                Arrays.fill(row, -1);
            return targetSum(nums, target, nums.length - 1, dp);
        }

        int targetSum(int nums[], int target, int ind, int dp[][]) {
            if (ind == 0) {
                return (target - nums[0] == 0 || target + nums[0] == 0)==true?1:0; // say the first index is 1 and target is 3.
            }
            if(dp[ind][target]!=-1) return dp[ind][target];
            // Adding the negative number.
            int op1 = targetSum(nums, target - nums[ind], ind - 1, dp);
            // Adding the positive value.
            int op2 = targetSum(nums, target + nums[ind], ind - 1, dp);
            return dp[ind][target] = op1 + op2;
        }
    }
}
