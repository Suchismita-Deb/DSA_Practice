package org.example.Premium.Amazon;

// Given a string s and an integer k, return true if s is a k-palindrome.

// A string is k-palindrome if it can be transformed into a palindrome by removing at most k characters from it.

// Example 1:
// Input: s = "abcdeca", k = 2
// Output: true
// Explanation: Remove 'b' and 'e' characters.
// Example 2:
// Input: s = "abbababa", k = 1
// Output: true

// Constraints:
// 1 <= s.length <= 1000
// s consists of only lowercase English letters.
// 1 <= k <= s.length
public class ValidPalindrome3 {
    class Solution {
        public boolean isValidPalindrome(String s, int k) {
            Boolean[][][] dp = new Boolean[s.length()][s.length()][k + 1];
            return valid(s, k, 0, s.length() - 1, dp);
        }

        boolean valid(String s, int k, int i, int j, Boolean[][][] dp) {
            if (i >= j) return true;
            if (dp[i][j][k] != null) return dp[i][j][k];
            char chI = s.charAt(i);
            char chJ = s.charAt(j);
            if (chI != chJ) {
                // op1 = valid(s, k-1, i + 1, j, dp);
                // op2 = valid(s, k-1, i, j - 1, dp);
                dp[i][j][k] = valid(s, k - 1, i + 1, j, dp) || valid(s, k - 1, i, j - 1, dp);
            } else {
                dp[i][j][k] = valid(s, k, i + 1, j - 1, dp);
            }
            return dp[i][j][k];
        }
    }
}
