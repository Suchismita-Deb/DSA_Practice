package org.example.A4SlidingWindow;

// https://leetcode.com/problems/contains-duplicate-ii/description/

import java.util.HashSet;

public class ContainsDuplicate2 {
    // HashSet to check if within the k window size there is any similar element.
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int i = 0;
            // j = i+k then it is considering the window size of k.
            // Answer can be there is window size <k.
            // [99,99] k = 2. Then it will return false as it is considering window size of 2.
            // The answer is true as with the range the element is present.
            int j = 0;


            // Window size max is k and size can be from 1 to k. It is not fixed size of k.
            // Generally variable size we take hashmap.
            HashSet<Integer> hset = new HashSet<>();
            // Within the size range I need to check if the value is present. To check
            // hashmap takes min time.
            while (j < nums.length) {
                if (hset.contains(nums[j]))
                    return true;
                hset.add(nums[j]);
                if (hset.size() > k) {
                    hset.remove(nums[i]);
                    i++;
                }
                j++;
            }

            return false;
        }
    }
}
