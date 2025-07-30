package org.example.A13DynamicProgramming.FibonacciNumbers;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/description/
//[1,2,3,1]
// 4(3+1)
public class HouseRobbers {
    class TakeNotTake {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, -1);
            return maxValue(nums, nums.length - 1, dp);
        }

        int maxValue(int[] nums, int i, int[] dp) {
            if (i < 0) return 0;
            if (dp[i] != -1) return dp[i];
            int op1 = 0;
            int op2 = 0;
            // take the value.
            op1 += nums[i];
            op1 += maxValue(nums, i - 2, dp);
            // to not take.
            op2 += maxValue(nums, i - 1, dp);
            return dp[i] = Math.max(op1, op2);
        }
    }
    class Iterative {
        public int rob(int[] nums) {
            int dp[] = new int[nums.length+1];
            dp[0] = 0;
            dp[1] = nums[0];
            for(int i=2;i<=nums.length;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
            }
            return dp[nums.length];
        }
    }
}
