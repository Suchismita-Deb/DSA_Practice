package org.example.dynamicProgramming.DpOnStringLongestCommonSubsequence;

import java.util.Arrays;

// https://leetcode.com/problems/edit-distance/description/
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation:
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[501][501];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return minDist(word1, word2, 0, 0, dp);
    }

    int minDist(String word1, String word2, int i, int j, int[][] dp) {
        if (i == word1.length() && j == word2.length()) return 0;
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;
        if (dp[i][j] != -1) return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) return minDist(word1, word2, i + 1, j + 1, dp);
        int op1 = 0, op2 = 0, op3 = 0;
        // update.
        op1 += 1 + minDist(word1, word2, i + 1, j + 1, dp);
        // delete.
        op2 += 1 + minDist(word1, word2, i + 1, j, dp);
        // insert.
        op3 += 1 + minDist(word1, word2, i, j + 1, dp);
        return dp[i][j] = Math.min(Math.min(op1, op2), op3);
    }
}