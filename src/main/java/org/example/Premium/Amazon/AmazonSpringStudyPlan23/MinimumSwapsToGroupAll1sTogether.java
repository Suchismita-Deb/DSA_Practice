package org.example.Premium.Amazon.AmazonSpringStudyPlan23;

// Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.
//Example 1:
//Input: data = [1,0,1,0,1]
//Output: 1
//Explanation: There are 3 ways to group all 1's together:
//[1,1,1,0,0] using 1 swap.
//[0,1,1,1,0] using 2 swaps.
//[0,0,1,1,1] using 1 swap.
//The minimum is 1.

// Cannot just see the max 1 count and see the part which contains max 1.
// [1,0,1,0,1] = The max 1 count = 3, max length of 1 = 1. Need 1 swap and not 2.
public class MinimumSwapsToGroupAll1sTogether {
    class Solution {
        public int minSwaps(int[] data) {
            int totalOnes = 0;

            // Count the total number of 1's in the array
            for (int num : data) {
                totalOnes += num;
            }

            // Edge case: if there are no 1's or only one 1, no swaps are needed
            if (totalOnes == 0 || totalOnes == 1) {
                return 0;
            }

            // Sliding window approach to find the minimum number of 0's in a window of size totalOnes
            int windowZeros = 0;
            int minSwaps = Integer.MAX_VALUE;

            // Calculate number of 0's in the first window of size totalOnes
            for (int i = 0; i < totalOnes; i++) {
                if (data[i] == 0) {
                    windowZeros++;
                }
            }

            // Initialize minSwaps with the count of 0's in the first window
            minSwaps = windowZeros;

            // Slide the window across the array
            for (int i = totalOnes; i < data.length; i++) {
                // Slide the window: remove the effect of the element leaving the window (i - totalOnes)
                if (data[i - totalOnes] == 0) {
                    windowZeros--;
                }

                // Add the effect of the new element entering the window
                if (data[i] == 0) {
                    windowZeros++;
                }

                // Update the minimum swaps needed
                minSwaps = Math.min(minSwaps, windowZeros);
            }

            return minSwaps;
        }
    }

}
