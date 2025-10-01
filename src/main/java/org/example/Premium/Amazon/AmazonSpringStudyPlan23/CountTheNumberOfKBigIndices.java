package org.example.Premium.Amazon.AmazonSpringStudyPlan23;

// You are given a 0-indexed integer array nums and a positive integer k.
// We call an index i k-big if the following conditions are satisfied:
// There exist at least k different indices idx1 such that idx1 < i and nums[idx1] < nums[i].
// There exist at least k different indices idx2 such that idx2 > i and nums[idx2] < nums[i].
// Return the number of k-big indices.

// Input: nums = [2,3,6,5,2,3], k = 2
// Output: 2

// Explanation: There are only two 2-big indices in nums:
// i = 2 --> There are two valid idx1: 0 and 1. There are three valid idx2: 2, 3, and 4.
// i = 3 --> There are two valid idx1: 0 and 1. There are two valid idx2: 3 and 4.

import java.util.Arrays;
import java.util.PriorityQueue;

public class CountTheNumberOfKBigIndices {
    // We need to find the count of the index where the elements in the right and left are smaller than the index.
    // We can have the prefix and suffix count it will be O(n^2)

    // Making a priority queue and storing the value and if the size is k and the max value of the priority queue is lesser than the element value at the index then we can make the boolean array value as true in the index.
    // Make another array from the right to left.
    // If the value true in both the array then count++.

    // In place of making two array we can make one array and again when coming from right to left see if teh array is true and the max element is less then the array element then increase the count.
    class Solution {
        public int kBigIndices(int[] nums, int k) {
            // Index is k-big if the array has k small element in the left and right index.
            int n = nums.length;
            boolean[] leftToRight = new boolean[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < n; i++) {
                if (pq.size() == k && pq.peek() < nums[i]) leftToRight[i] = true;
                pq.add(nums[i]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            boolean[] rightToLeft = new boolean[n];
            PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a);
            for (int i = n - 1; i >= 0; i--) {
                if (pq1.size() == k && pq.peek() < nums[i]) {
                    rightToLeft[i] = true;
                }
                pq1.add(nums[i]);
                if (pq1.size() > k) {
                    pq1.poll();
                }
            }
            System.out.println(Arrays.toString(leftToRight));
            System.out.println(Arrays.toString(rightToLeft));
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (leftToRight[i] && rightToLeft[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    class SpaceOptimisedArray {
        public int kBigIndices(int[] nums, int k) {
            // Index is k-big if the array has k small element in the left and right index.
            int n = nums.length;
            boolean[] leftToRight = new boolean[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < n; i++) {
                if (pq.size() == k && pq.peek() < nums[i]) leftToRight[i] = true;
                pq.add(nums[i]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            int count = 0;
            pq.clear();
            for (int i = n - 1; i >= 0; i--) {
                if (pq.size() == k && pq.peek() < nums[i]) {
                    count++;
                }
                pq.add(nums[i]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            return count;
        }
    }
}

