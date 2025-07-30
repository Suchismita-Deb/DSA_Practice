package org.example.A13DynamicProgramming;

// https://leetcode.com/problems/maximum-product-subarray/description/

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        /*
        int res = nums[0];
        int min = 1;
        int max = 1; // Carry min and max and will check for the next number.
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i] * max;
            max =Math.max(nums[i], Math.max(temp, min * nums[i]));
            // Math.max(temp, Math.max(min * nums[i], nums[i]));
            // max is not storing the overall max. It is only storing the value obtained after the new number.
            min = Math.min(nums[i], Math.min(temp, min * nums[i]));
            // Math.min(temp, Math.min(min * nums[i], nums[i]));
            // min and max value is present for al the element.
            // [-1,-2,-3] = 6 There is min and max value and when we got -3 then either max = 6 or min = -6.
            // the max and min value will get the max and min by multiply new element with the previous min and max.
            // We are updating the max so we need another variable to store the max.
            res = Math.max(res, max);
        }
        return res;
        */
        double max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            double temp = max;  // store the max because before updating min your max will already be updated

            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if (max > ans) {
                ans = max;
            }
        }
        return (int) ans;
    }

}
