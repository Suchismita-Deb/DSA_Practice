package org.example.slidingWindow;

import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// Given a string s, find the length of the longest substring without repeating characters.
// Input: s = "abcabcbb".
// Output: 3.
// Explanation: The answer is "abc", with the length of 3.
public class LongestSubstringWithoutRepeatingCharacter {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int i = 0, j = 0;
            int max = Integer.MIN_VALUE;
            if (s.length() <= 1) return s.length();
            HashSet<Character> hset = new HashSet<>();
            // Sliding window needs to check the frequency then we need the hash set.

            while (j < s.length()) {
                if (hset.contains(s.charAt(j))) {

                    while (hset.contains(s.charAt(j))) {
                        hset.remove(s.charAt(i));
                        i++;
                    }
                }
                max = Math.max(max, j - i + 1);
                hset.add(s.charAt(j));
                j++;
            }
            return max;
        }
    }
}
