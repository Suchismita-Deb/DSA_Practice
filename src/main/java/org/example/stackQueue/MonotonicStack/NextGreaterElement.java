package org.example.stackQueue.MonotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
// https://leetcode.com/problems/next-greater-element-i/description/
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            mp.put(nums1[i], i);
        }
        Stack<Integer> st = new Stack<>();
        st.push(nums2[0]);
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1); // Initially filled with -1
        // nums1 = [4,1,2] nums2 = [2,1,6,4]
        for (int i = 1; i < nums2.length; i++) {
            // while loop will continue till the time
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                int n = st.peek();
                // Making the stack monotonic decreasing and when num is greater than pop the
                // elements from stack and see the map present.
                if (mp.containsKey(n)) {
                    res[mp.get(n)] = nums2[i];
                }
                st.pop();
            }
            // Stack top containing the largest element. Now adding the value.
            // 2 1 will be inserted. When 6 comes then remove from stack then 4 inserted.
            // Monotonic decreasing stack.
            st.push(nums2[i]);
        }
        return res;
    }
}