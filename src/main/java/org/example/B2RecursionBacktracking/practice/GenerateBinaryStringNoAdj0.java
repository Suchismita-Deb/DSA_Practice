package org.example.B2RecursionBacktracking.practice;

// https://leetcode.com/contest/weekly-contest-405/problems/generate-binary-strings-without-adjacent-zeros/description/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// A binary string x is valid if all substrings of x of length 2 contain at least one "1".
// Return all valid strings with length n, in any order.
// n = 3
// Output: ["010","011","101","110","111"]
public class GenerateBinaryStringNoAdj0 {

    class Solution {
        List<String> list = new ArrayList<>();
        public List<String> validStrings(int n) {
            StringBuilder str = new StringBuilder();
            // Passing the same stringBuilder then it will get duplicate value and we have to use set.
            validString(0, 0, n, str);
            validString(0, 1, n, str);
            HashSet<String> hset = new HashSet<>();
            for (int i = 0; i < list.size(); i++) {
                hset.add(list.get(i));
            }

            System.out.println(hset);
            List<String> ans = new ArrayList<>();
            for (String s : hset) {
                ans.add(s);
            }
            return ans;
        }

        void validString(int i, int prev, int n, StringBuilder str) {
            if (str.length() == n) {
                list.add(str.toString());
                return;
            }

            // Adding 1 first. Learning I was adding this after the check if prev==0.

            validString(i + 1, 1, n, str.append(1));
            str.deleteCharAt(str.length() - 1);

            if (prev == 1) {
                validString(i + 1, 0, n, str.append(0));
                str.deleteCharAt(str.length() - 1);
                // validString(i+1,1,n,str.append(1)); No need to add 1 as we are adding it first.
            }
        }
    }

    // Without using Hashset.
    class Solution1 {
        public List<String> validStrings(int n) {
            StringBuilder a = new StringBuilder("0");
            StringBuilder b = new StringBuilder("1");
            List<String> ans = new ArrayList<>();
            // Passing other stringBuilder.
            fun(ans, 0, a, n);
            fun(ans, 1, b, n);
            return ans;
        }

        void fun(List<String> ans, int prev, StringBuilder str, int n) {
            // Base Condition.
            if (str.length() == n) {
                ans.add(str.toString());
                return;
            }
            // Add.
            str.append('1');
            fun(ans, 1, str, n);
            // Backtrack.
            str.deleteCharAt(str.length() - 1);
            // Additional Condition.
            if (prev == 1) {
                str.append('0');
                fun(ans, 0, str, n);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}
