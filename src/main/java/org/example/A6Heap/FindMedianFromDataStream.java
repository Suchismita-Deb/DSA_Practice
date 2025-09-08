package org.example.A6Heap;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/find-median-from-data-stream/description/

public class FindMedianFromDataStream {
    class MedianFinder {
        // Input
        //["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
        //[[], [1], [2], [], [3], []]
        //Output
        //[null, null, null, 1.5, null, 2.0]
        //Explanation
        //MedianFinder medianFinder = new MedianFinder();
        //medianFinder.addNum(1);    // arr = [1]
        //medianFinder.addNum(2);    // arr = [1, 2]
        //medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        //medianFinder.addNum(3);    // arr[1, 2, 3]
        //medianFinder.findMedian(); // return 2.0

        // When the number are coming in order ans sorted then we can check for the
        // middle value. We have to make the number in sorted order.

        // If we sort always then O(log n) else making the array traverse amd place in
        // sorted order will cost O(n).

        // Making 2 part. one part will contain n/2 element and other will contain n/2
        // elements.
        // Odd element then one will be n/2+1. The difference between two part will be
        // at max 1.

        // There will be a small heap and a large heap and all element in small heap
        // will be smaller than the large heap.
        // The small heap will be max heap and the large heap will be the min heap.

        // [2,3] and [4,5] now there are 4 numbers and the median will be (3+4)/2.
        // [1,2,3] and [8,9] the median is 3. So from max heap we got the max number and
        // min heap will give the small number.
        // We can directly calculate.

        Queue<Integer> smallHeap; // smallHeap - MaxHeap.
        Queue<Integer> largeHeap; // largeHeap - MinHeap.

        public MedianFinder() {
            // Heap by default is min heap in java without a comparator.
            smallHeap = new PriorityQueue<Integer>((a, b) -> b - a);
            largeHeap = new PriorityQueue<Integer>();
        }

        public void addNum(int num) {
            /*
             * add(2)
             * add(3)
             * add(7)
             * add(4)
             * getMedian()
             * When we get add(2) then add in small heap. small heap count 1 andlarge heap
             * is 0. Difference is 1.
             *
             * The add(3) add in small heap. Small heap count 2 and large heap count 0
             * difference is 2-0 = 2. Take the max element and put in the max heap.
             * Adding in heap is log n.
             *
             * We always need to check if the size of small heap is <= large heap.
             *
             * We also checck if every element in small heap is <= large heap.
             * add(7) in small heap.
             *
             * The maxof small heap is 7 and min of large is 3 so 7<3 no, move 7 to large
             * heap.
             *
             * add(4) in small the max of small = 4 is not less than or equl to the min of
             * the large.
             *
             * So moving 4 in large. Now size of small is 1 and size of large is 3 not
             * matching.
             *
             * Get the min element from large and put in the small.
             */

            smallHeap.add(num);

            // if the size of two heap is not same or the size difference is more than 1.
            if (smallHeap.size() - largeHeap.size() > 1 || (!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek())) {
                largeHeap.add(smallHeap.poll());
            }

            // Checking for the largeHeap.
            if (largeHeap.size() - smallHeap.size() > 1) {
                smallHeap.add(largeHeap.poll());
            }
        }

        public double findMedian() {
            if (largeHeap.size() == smallHeap.size()) {
                return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
            }
            if (largeHeap.size() > smallHeap.size()) {
                return (double) largeHeap.peek();
            } else {
                return (double) smallHeap.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
