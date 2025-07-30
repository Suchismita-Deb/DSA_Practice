package org.example.A13DynamicProgramming.DpOnStringLongestCommonSubsequence;

// https://leetcode.com/problems/shortest-common-supersequence/description/

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String text1, String text2) {
        // Code of the lcs count and lcs print.
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
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
        // Output of abac and cab is ab.
        StringBuilder ans = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ans.append(text1.charAt(i - 1)); // When char equal then take one and move diagonally.
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(text1.charAt(i - 1)); // When one is bigger then go to that direction.
                i--;
            } else {
                ans.append(text2.charAt(j - 1));
                j--;
            }
        }
        // When some char of text1 is present.
        while (i > 0) {
            ans.append(text1.charAt(i - 1));
            i--;
        }
        // When some char of text2 is present.
        while (j > 0) {
            ans.append(text2.charAt(j - 1));
            j--;
        }
        // Reverse and then convert to String.
        return ans.reverse().toString();
    }
}