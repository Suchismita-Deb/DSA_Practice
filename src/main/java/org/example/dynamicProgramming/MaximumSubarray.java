package org.example.dynamicProgramming;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) sum = 0;
            sum += nums[i]; // first the condition. sum<0 reset then add new value.
            max = Math.max(sum, max); // [-2,-1] = -1 and not 0. So we have to put the if first.
        }
        return max;
    }
}
