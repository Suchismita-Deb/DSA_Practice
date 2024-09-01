package org.example.tips;

import java.util.PriorityQueue;

public class HeapImp {
    public static void main(String[] args) {
        // Default in heap is Min heap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // MaxHeap contains comparator.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((b, a) -> b - a);
        // When adding the integer then it will compare with the value.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        // Min distance form the origin.
        // array is given so we are storing the array and the min heap is calculated based on the distance.


        // PriorityQueue default is min heap. but when adding with the Pair of first and second values like that then we need to specify on what basis we want the min element on the top and add the comparator like (a,b) -> a.distance-b.distance.

    }
}
