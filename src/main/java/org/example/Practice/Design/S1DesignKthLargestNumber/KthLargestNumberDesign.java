package org.example.Practice.Design.S1DesignKthLargestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
// One Approach - Make a list with initial value and make sorted and new element will be added to the exact position and with Binary search we can search the exact position to add the element.
class KthLargestUsingList {

    List<Integer> stream;
    int k;

    public KthLargestUsingList(int k, int[] nums) {
        stream = new ArrayList<Integer>(nums.length);
        this.k = k;

        for (int num : nums) {
            stream.add(num);
        }

        Collections.sort(stream);
    }

    public int add(int val) {
        int index = getIndex(val);
        // Add val to correct position
        stream.add(index, val);
        return stream.get(stream.size() - k);
    }

    private int getIndex(int val) {
        int left = 0;
        int right = stream.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midElement = stream.get(mid);
            if (midElement == val) return mid;
            if (midElement > val) {
                // Go to left half
                right = mid - 1;
            } else {
                // Go to right half
                left = mid + 1;
            }
        }
        return left;
    }
}

// Another approach using heap. In class add the detail and in constructor initialize it. 
class KthLargestUsingHeap {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestUsingHeap(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // Add to our minHeap if we haven't processed k elements yet
        // or if val is greater than the top element (the k-th largest)
        if (minHeap.size() < k || minHeap.peek() < val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}
public class KthLargestNumberDesign {

    public static void main(String[] args) {
        int k = 3;
        int[] initialStream = {4, 5, 8, 2};

        // Sorted List Based Approach
        System.out.println("=== Sorted List Approach ===");
        KthLargestUsingList listBased = new KthLargestUsingList(k, initialStream);
        System.out.println(listBased.add(3));  // returns 4
        System.out.println(listBased.add(5));  // returns 5
        System.out.println(listBased.add(10)); // returns 5
        System.out.println(listBased.add(9));  // returns 8
        System.out.println(listBased.add(4));  // returns 8

        // Priority Queue Based Approach
        System.out.println("\n=== Min Heap Approach ===");
        KthLargestUsingHeap heapBased = new KthLargestUsingHeap(k, initialStream);
        System.out.println(heapBased.add(3));  // returns 4
        System.out.println(heapBased.add(5));  // returns 5
        System.out.println(heapBased.add(10)); // returns 5
        System.out.println(heapBased.add(9));  // returns 8
        System.out.println(heapBased.add(4));  // returns 8
    }
}
