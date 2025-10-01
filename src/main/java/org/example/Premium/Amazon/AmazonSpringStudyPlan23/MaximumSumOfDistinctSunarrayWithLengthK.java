package org.example.Premium.Amazon.AmazonSpringStudyPlan23;

// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

import java.util.HashSet;
import java.util.Set;

// You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
// The length of the subarray is k, and
// All the elements of the subarray are distinct.
// Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
// A subarray is a contiguous non-empty sequence of elements within an array.

//Example 1:
// Input: nums = [1,5,4,2,9,9,9], k = 3
// Output: 15
// Explanation: The subarrays of nums with length 3 are:
// [1,5,4] which meets the requirements and has a sum of 10.
// [5,4,2] which meets the requirements and has a sum of 11.
// [4,2,9] which meets the requirements and has a sum of 15.
// [2,9,9] which does not meet the requirements because the element 9 is repeated.
// [9,9,9] which does not meet the requirements because the element 9 is repeated.
//We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
public class MaximumSumOfDistinctSunarrayWithLengthK {
    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            Set<Integer> st = new HashSet<>();
            int count = 0;
            int j = 0;
            long max = 0;
            long maxVal = 0;
            for (int i = 0; i < nums.length; i++) {
                while (st.contains(nums[i])) {
                    st.remove(nums[j]);
                    max -= nums[j];
                    j++;
                }
                st.add(nums[i]);
                max += nums[i];
                // Tips = I was making another condition for the set size more than k. We can remove the element for the size k. I was facing issue with the j pointer when size is met then we can remove the value of j.
                if (st.size() == k) {
                    maxVal = Math.max(maxVal, max);
                    max -= nums[j];
                    st.remove(nums[j]);
                    j++;
                }
            }
            return maxVal;
        }
    }
}
