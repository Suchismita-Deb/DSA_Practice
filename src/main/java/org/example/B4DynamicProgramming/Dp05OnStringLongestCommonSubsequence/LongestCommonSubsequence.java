package org.example.B4DynamicProgramming.Dp05OnStringLongestCommonSubsequence;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-subsequence/description/
// Input: text1 = "abcde", text2 = "ace"
// Output: 3
// Explanation: The longest common subsequence is "ace" and its length is 3.
public class LongestCommonSubsequence {

    // Memorization.
    class Memorization {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length();
            int m = text2.length();
            int dp[][] = new int[n+1][m+1];
            for (int row[] : dp) {
                Arrays.fill(row, -1);
            }
            return lcs(text1, text2, n - 1, m - 1, dp);
        }

        int lcs(String text1, String text2, int i, int j, int dp[][]) {
            if (i < 0 || j < 0) {
                return 0;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            // String match then we can change the index of text1 and text2.
            if (text1.charAt(i) == text2.charAt(j)) {
                return 1+lcs(text1, text2, i - 1, j - 1, dp); // Match adding 1.
            }
            // ace and aec
            // Shift the i in first string and check if any match and then shift the j in text2 and check if any match.
            // Return the max.
            return dp[i][j] = Math.max(lcs(text1, text2, i - 1, j, dp), lcs(text1, text2, i, j - 1, dp));
        }
    }

    // Tabulation
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length();
            int m = text2.length();
            int dp[][] = new int[n + 1][m + 1];
            // dp of n+1 and m+1.
            // Filling first row and left column with 0.
            for (int i = 0; i <= m; i++) {
                dp[0][i] = 0;
            }
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1]; // Match adding 1.
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[n][m];
        }
    }
}
