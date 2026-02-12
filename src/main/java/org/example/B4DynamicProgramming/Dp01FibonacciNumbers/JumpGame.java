package org.example.B4DynamicProgramming.Dp01FibonacciNumbers;

import java.util.Arrays;

// https://leetcode.com/problems/jump-game/description/
// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position. Return true if you can reach the last index, or false otherwise.
// nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            // From a particular point I can jump to i+1 to the num[i] value.
            // Check for all possible ways as if we only go by greedy then it will go to the cvalue 0 where I will be stuck.
            // If going by all steps is not coming to the end index then return false;
            int dp[] = new int[nums.length+1];
            Arrays.fill(dp,-1);
            return stepsPossible(nums,0,dp);
        }
        boolean stepsPossible(int nums[], int ind, int dp[]){
            if(ind==nums.length-1) return true;
            if(nums[ind]==0) return false;
            if(dp[ind]!=-1) return dp[ind]==1?true:false;

            int maxReach = ind+nums[ind];
            for(int i=ind+1;i<=maxReach;i++){
                if(i<nums.length && stepsPossible(nums,i,dp)){
                    dp[ind]=1;
                    return true;
                }
            }
            dp[ind] = 0;
            return false;
        }
    }

    class Greedy{
        public boolean canJump(int[] nums) {
            int goal = nums.length-1;
            for(int i=nums.length-2;i>=0;i--){
                if(nums[i]+i>=goal){
                    goal = i;
                }
            }
            return goal==0;
        }
    }
}
