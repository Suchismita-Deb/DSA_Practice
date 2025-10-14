package org.example.B4DynamicProgramming.Dp04StringLongestIncreasingSubsequence;

// https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2.
Input: nums = [0,1,0,3,2,3]
Output: 4.

Example 3.
Input: nums = [7,7,7,7,7,7,7]
Output: 1.
*/
public class Dp01LongestIncreasingSubsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int dp[][] = new int[nums.length][nums.length + 1];
            for (int row[] : dp) {
                Arrays.fill(row, -1);
            }
            return longestLen(nums, dp, 0, -1);
        }

        int longestLen(int nums[], int dp[][], int ind, int prev_ind) {
            if (ind == nums.length) {
                return 0;
            }
            if (dp[ind][prev_ind + 1] != -1) {
                return dp[ind][prev_ind + 1];
            }
            int len = 0 + longestLen(nums, dp, ind + 1, prev_ind); // Not take.

            if (prev_ind == -1 || nums[prev_ind] < nums[ind]) {
                len = Math.max(len, 1 + longestLen(nums, dp, ind + 1, ind));
            }
            return dp[ind][prev_ind + 1] = len;
        }
    }


    class Solution1 {
        // Using Collections.binarySearch().
        public int lengthOfLIS(int[] nums) {
            ArrayList<Integer> arr = new ArrayList<>();

            arr.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (arr.get(arr.size() - 1) < nums[i]) {
                    arr.add(nums[i]);
                } else {
                    int ind = Collections.binarySearch(arr, nums[i]); // Explanation in the image.
                    if (ind < 0) {
                        ind = -ind - 1;
                    }
                    arr.set(ind, nums[i]);
                }
            }
            return arr.size();
        }
    }

    class Solution2 {
        // Using the Binary Search o(NlogN).
        public int lengthOfLIS(int[] nums) {
            ArrayList<Integer> arr = new ArrayList<>();

            arr.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (arr.get(arr.size() - 1) < nums[i]) {
                    arr.add(nums[i]);
                } else {
                    int pos = binarySearch(arr, nums[i]);
                    arr.set(pos, nums[i]);
                }
            }
            return arr.size();
        }

        int binarySearch(ArrayList<Integer> arr, int val) {
            int n = arr.size();
            int i = 0;
            int j = n - 1;
            while (i <= j) {
                int mid = (i + j) / 2;
                if (arr.get(mid) < val) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            return i;
        }

    }
}
