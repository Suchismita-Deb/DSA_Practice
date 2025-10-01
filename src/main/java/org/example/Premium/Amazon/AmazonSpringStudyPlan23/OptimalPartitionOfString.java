package org.example.Premium.Amazon.AmazonSpringStudyPlan23;

// https://leetcode.com/problems/optimal-partition-of-string/description/

import java.util.HashSet;
import java.util.Set;

// Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.

// Return the minimum number of substrings in such a partition.
// Note that each character should belong to exactly one substring in a partition.

//Example 1:
//Input: s = "abacaba"
//Output: 4
//Explanation:
//Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
//It can be shown that 4 is the minimum number of substrings needed.
public class OptimalPartitionOfString {
    class Solution {
        public int partitionString(String s) {
            Set<Character> st = new HashSet<>();
            int count=0;
            for(int i=0;i<s.length();i++){
                if(st.contains(s.charAt(i))){
                    // Adding in set and when there is a same element then clear the set and get the new string.
                    count++;
                    System.out.println(st); // "ab","ac","ab"
                    st.clear();
                }
                st.add(s.charAt(i));
            }
            return count+1; // Adding 1 as the last string will not be counted.
        }
    }
}
