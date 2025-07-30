package org.example.A13DynamicProgramming.FibonacciNumbers;

import java.util.Arrays;

public class ClimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            int[] arr = new int[n + 1];
            Arrays.fill(arr, -1);
            return climb(n, arr);
        }

        public int climb(int n, int[] arr) {
            if (arr[n] != -1) return arr[n];
            if (n <= 1) return arr[n] = 1;
            return arr[n] = climb(n - 2, arr) + climb(n - 1, arr);
        }
    }
}
