package org.example.Premium.Google;

import java.util.Arrays;

// https://leetcode.com/problems/finding-the-number-of-visible-mountains/description/?envType=study-plan-v2&envId=google-spring-23-high-frequency
// You are given a 0-indexed 2D integer array peaks where peaks[i] = [xi, yi] states that mountain i has a peak at coordinates (xi, yi). A mountain can be described as a right-angled isosceles triangle, with its base along the x-axis and a right angle at its peak. More formally, the gradients of ascending and descending the mountain are 1 and -1 respectively.
// A mountain is considered visible if its peak does not lie within another mountain (including the border of other mountains).
// Return the number of visible mountains.

// peaks = [[2,2],[6,3],[5,4]]
// Output: 2
// Explanation: The diagram above shows the mountains.
//- Mountain 0 is visible since its peak does not lie within another mountain or its sides. Base from 0 to 4.
//- Mountain 1 is not visible since its peak lies within the side of mountain 2. Base from 1 to 9.
//- Mountain 2 is visible since its peak does not lie within another mountain or its sides. Base from 3 to 9.
// There are 2 mountains that are visible.

public class FindNumberOfVisibleMountains {
    class Solution {
        public int visibleMountains(int[][] peaks) {
            int n = peaks.length;
            int startInd[] = new int[n];
            int endInd[] = new int[n];
            for (int i = 0; i < n; i++) {
                startInd[i] = peaks[i][0] - peaks[i][1]; // Right angle isosceles triangle height is same as the half base.
                // If the peak is at 5,4 then the side is 5-4 = starting from 1 to 5+4 = 9.
                endInd[i] = peaks[i][1] + peaks[i][0];
            }
            // Taking the start and the end in a separate array.
            // Need to do in same 2d array as we need to sort based on start point.
            int base[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                base[i][0] = startInd[i];
                base[i][1] = endInd[i];
            }

            Arrays.sort(base, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);
            // Initially sort by the start value.
            // If start value is same then sort by the end value in decreasing order as we
            // first add the
            // wider mountain.

            for (int i = 0; i < n; i++) {
                System.out.println(base[i][0] + " " + base[i][1]);
            }

            int count = 0;
            int i = 0;
            while (i < base.length) {
                count++;
                if (i + 1 == base.length) {
                    return count;
                }

                int curStart = base[i][0];
                int curEnd = base[i][1];
                int nextStart = base[i + 1][0];
                int nextEnd = base[i+1][1];

                if (curStart == nextStart) // Depending on the peak and height one will be overlapped.
                    count--;
                while (i + 1 != base.length && curEnd >= nextEnd) {
                    i++;// Continue not even checking for the mountain whose base is smaller.
                }
                i++;
            }
            return count;
        }
    }
}
