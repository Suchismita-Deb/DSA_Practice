package org.example.A6Heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

public class KthLargestElementInAnArray {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // Default is min heap.
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<nums.length;i++){
                pq.offer(nums[i]);
                // If the size exceeds k.
                if(pq.size()>k){
                    // Remove the root element (lowest of all).
                    pq.poll();
                }
            }
            return pq.peek();
        }
    }
}
