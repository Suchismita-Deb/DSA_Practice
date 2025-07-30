package org.example.A8StackQueue.MonotonicQueue;

// https://leetcode.com/problems/sliding-window-maximum/description/

import java.util.Deque;
import java.util.LinkedList;

// nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // [1,2,3,4]
        // First window will get the max as 3 then will shift the window as window size 3 and will remove 1 from the window. There is no need to check for 2 as 3 is max.
        // When we get one max then we can remove the element in front of the max.
        // Use deque to add the max value at the end and remove all the small value in the front. Deque is always in the decreasing order.
        // [1,1,1,1,1,4,5]
        // deque = [1 1 1 1 1] when 4 comes it will check with the first element and remove all 1 and the deque = [4] It will be in decreasing fashion. When we got 5 then we remove 4. Monotonic Decreasing Queue. Need to add the element in O(1) time and need to remove the element in the front O(1) time. With stack insertion is good but removal of the min element form the front in O(1) not possible.

        // [8,7,6,9]
        // First got max number as 8 added in queue. Then got 7 added in queue and will only remove smaller element. [8,7] so when we need max element will see the first element.
        // Deque will store the index of the element so when the index is crossing the window then pop the element from queue. Window moves and we remove 8 from queue. Now in the next window gt 6 so added and max is 7. Now when window move we remove 7 and [6] got 9 and compare 6 is less so remove 6.

        int n = nums.length;
        int[] res = new int[n - k + 1];
        int j = 0;
        Deque<Integer> q = new LinkedList<>(); // Queue will store the index.
        for (int i = 0; i < n; i++) {
            // remove number out of range k.
            while (q.size() != 0 && q.peek() < i - k + 1) {
                q.poll(); // removing form the first size of the queue.
            }
            // remove the smaller number in k range.
            while (q.size() != 0 && nums[q.peekLast()] < nums[i]) {
                q.pollLast(); // removing form the end. Difference between queue and deque that in deque we can remove element form the last.
            }
            q.add(i);
            if (i >= k - 1) {
                res[j++] = nums[q.peek()]; // when I am at the end index of the window.
            }
        }
        return res;
    }
}
