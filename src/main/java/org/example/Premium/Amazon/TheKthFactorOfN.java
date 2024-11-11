package org.example.Premium.Amazon;

// You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
//
//Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.
//
//
//
//Example 1:
//
//Input: n = 12, k = 3
//Output: 3
//Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/the-kth-factor-of-n/description/
public class TheKthFactorOfN {
    class Solution {
        public int kthFactor(int n, int k) {
            ArrayList<Integer> arr = new ArrayList<>();

            int cnt = 0;
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    arr.add(i);
                    if (i * i != n) {
                        arr.add(n / i);
                    };
                }
            }
            arr.sort(Integer::compareTo);
            return arr.size()<k?-1:arr.get(k-1);
        }
    }
    class SolutionON {
        public int kthFactor(int n, int k) {
            int arr[] = new int[k];
            Arrays.fill(arr,-1);
            int pos=0;
            for(int i=1;i<=n;i++){
                if(pos==k)
                    return arr[pos-1];
                if(n%i==0)
                    arr[pos++] = i;

            }
            return arr[k-1];
        }
    }
}
