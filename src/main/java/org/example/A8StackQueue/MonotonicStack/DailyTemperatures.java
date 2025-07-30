package org.example.A8StackQueue.MonotonicStack;

// https://leetcode.com/problems/daily-temperatures/description/

import java.util.Stack;

// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
// temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]

public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> st = new Stack<>();
            st.push(0);
            int[] res = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    int n = st.peek();
                    res[n] = i - n;
                    st.pop();
                }
                st.push(i);
            }
            return res;
        }
    }
}
