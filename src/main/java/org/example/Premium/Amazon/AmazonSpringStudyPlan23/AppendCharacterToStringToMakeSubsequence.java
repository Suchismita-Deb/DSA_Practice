package org.example.Premium.Amazon.AmazonSpringStudyPlan23;

// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/

// You are given two strings s and t consisting of only lowercase English letters.
// Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.

// A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

// Input: s = "coaching", t = "coding"
// Output: 4
// Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
// Now, t is a subsequence of s ("coachingding").
// It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
public class AppendCharacterToStringToMakeSubsequence {
    class Solution {
        public int appendCharacters(String s, String t) {
            int j = 0;

            if (t.length() == 0) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (j < t.length() && s.charAt(i) == t.charAt(j)) {
                    j++;  // Match characters from t in s
                }
            }
            return t.length() - j;
        }
    }

}
