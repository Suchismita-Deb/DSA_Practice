package org.example.A6Heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/

public class KthClosestPointToTheOrigin {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            // Default heap in java it is min heap.
            // For max heap we need comparator.
            // Initially storing the distance in the priority and cannot be able to get the int[][].
            // Here in heap will store the coordinates based on the value of distance.
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
            for (int n[] : points) {
                pq.offer(n);
                while (pq.size() > k) {
                    pq.poll();
                }
            }
            // output can contain more than one value.
            // It will contain k size of the value.
            int res[][] = new int[k][2];
            int i=0;
            while(pq.size()!=0){
                int arr[] = pq.poll();
                res[i][0] = arr[0];
                res[i][1] = arr[1];
                i++;
            }
            return res;
        }
    }
}
