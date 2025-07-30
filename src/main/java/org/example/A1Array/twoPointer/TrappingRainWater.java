package org.example.A1Array.twoPointer;

// https://leetcode.com/problems/trapping-rain-water/description/

public class TrappingRainWater {
    // Getting the prefix and the suffix large value and calculating the min value and the array height value for an index. If positive then add the value.
    class Solution {
        public int trap(int[] arr) {
            int[] prefixLarge = new int[arr.length];
            prefixLarge[0] = 0;
            for (int i = 1; i < arr.length; i++) {
                prefixLarge[i] = Math.max(arr[i - 1], prefixLarge[i - 1]);
            }
            int[] suffixLarge = new int[arr.length];
            suffixLarge[arr.length - 1] = 0;
            for (int i = arr.length - 2; i >= 0; i--) {
                suffixLarge[i] = Math.max(arr[i + 1], suffixLarge[i + 1]);
            }
            int[] num = new int[arr.length];
            num[0] = 0;
            num[arr.length - 1] = 0;
            // Height given = [0,1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
            // PrefixLarge = [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
            // SuffixLarge = [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]
            for (int i = 1; i < arr.length - 1; i++) {
                if (Math.min(prefixLarge[i], suffixLarge[i]) - arr[i] > 0) {
                    num[i] = Math.min(prefixLarge[i], suffixLarge[i]) - arr[i];
                } else num[i] = 0;
            }
            int sum = 0;
            for (int i = 0; i < num.length; i++) {
                sum += num[i];
            }
            return sum;
        }
    }
}
