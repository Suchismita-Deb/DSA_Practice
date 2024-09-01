package org.example.binarySearch;

import java.util.Arrays;

// https://leetcode.com/problems/koko-eating-bananas/description/
// The ith index has piles[i] bananas. Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Return the minimum speed of eating banana in an hour.
// piles = [3,6,7,11], h = 8 Output: 4
// piles = [30,11,23,4,20], h = 5 Output: 30

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        // The maximum value can be the max value of the array.
        System.out.println(Arrays.toString(piles));
        int low = 1;
        int high = piles[piles.length - 1]; // Doing the binary search in the range of 1 to the max value of the array.
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int hour = 0;
            for (int i = 0; i < piles.length; i++) {
                // 7/3 = 2. I want 3. Another way if there is remainder then add 1.
                hour += Math.ceil((double) piles[i] / mid); // Total hour needed if k is mid.
            }
            // the number of hours needed for the k is hour.
            if (hour <= h) {
                ans = Math.min(ans, mid);
                high = mid - 1; // Checking for min value.
            } else {
                low = mid + 1; // Increase the k value as it is not completed.
            }
        }
        return ans;
    }

}
