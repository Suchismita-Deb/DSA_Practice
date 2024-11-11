package org.example.heap;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    class KthLargest {
        PriorityQueue<Integer> pq;
        int size;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            this.size = k;
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            pq.offer(val);
            while (pq.size() > size) {
                pq.poll();
            }
            return pq.size() == size ? pq.peek() : 0;
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
