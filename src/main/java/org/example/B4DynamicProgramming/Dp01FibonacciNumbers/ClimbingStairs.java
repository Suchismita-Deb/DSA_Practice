package org.example.B4DynamicProgramming.Dp01FibonacciNumbers;

import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/description/
// You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
// Example 1:
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps.

// Example 2:
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
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


            // There are multiple ways to reach to the top at (n-2) so n-2 will contain the result and number of ways to reach to the top.
            return arr[n] = climb(n - 2, arr) + climb(n - 1, arr);
        }
    }
}

// climbStairs(5)
// ├── climbStairs(4)
// │   ├── climbStairs(3)
// │   │   ├── climbStairs(2)
// │   │   │   ├── climbStairs(1) → 1
// │   │   │   └── climbStairs(0) → 1
// │   │   └── climbStairs(1) → 1
// │   └── climbStairs(2) → already computed
// └── climbStairs(3) → already computed