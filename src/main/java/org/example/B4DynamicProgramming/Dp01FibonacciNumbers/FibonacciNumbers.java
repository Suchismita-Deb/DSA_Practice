package org.example.B4DynamicProgramming.Dp01FibonacciNumbers;

// https://leetcode.com/problems/fibonacci-number/description/

/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).



Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 */
public class FibonacciNumbers {
    class Solution {
        public int fib(int n) {
            int a = 0;
            int b = 1;
            if(n==0||n==1){
                return n;
            }
            int ans = -1;
            for(int i=0;i<n-1;i++){
                ans = a+b;
                a = b;
                b = ans;
            }
            return ans;
        }
    }

}

// When doing the Fin in recursion then every number is going till the base time O(n^2).
// Using DB only the max number is going till the base case and the array is filled and all other number will get the value from the array time O(n).
// Recursion - Top down.
// Tabulation - Bottom Up.
// In Tabulation think about the dp table directly.