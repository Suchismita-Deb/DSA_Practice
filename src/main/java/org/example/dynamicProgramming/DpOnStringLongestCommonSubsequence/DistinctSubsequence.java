package org.example.dynamicProgramming.DpOnStringLongestCommonSubsequence;

import java.util.Arrays;

public class DistinctSubsequence {

    class Solution {
        public int numDistinct(String s, String t) {
            int n = s.length();
            int m = t.length();
            int dp[][] = new int[n+1][m+1]; // taking n and m size and also taking n+1 and m+1 works.
            // In LCS we take n+1 and m+1.
            for (int row[] : dp) {
                Arrays.fill(row, -1);
            }
            return distinct1(s, t, n - 1, m - 1, dp);
        }

        int distinct1(String s, String t, int i, int j, int dp[][]) {
            if (j < 0) // Done for t. // First adding this condition.
                return 1;
            if (i < 0)
                return 0;

            if (dp[i][j] != -1)
                return dp[i][j];
            // int return type so base case should return 1 or 0.

            if (s.charAt(i) == t.charAt(j)) {
                // When match we can take the case or we move further and take other scenario.
                return dp[i][j] = distinct1(s, t, i - 1, j - 1, dp) + distinct1(s, t, i - 1, j, dp);
            }
            return dp[i][j] = distinct1(s, t, i - 1, j, dp);

        }
    }
    // Tabulation
    class Tabulation {
        public int numDistinct(String s, String t) {
            int n = s.length();
            int m = t.length();
            int dp[][] = new int[n + 1][m + 1]; // taking n and m size and also taking n+1 and m+1 works.
            // In LCS we take n+1 and m+1.
            for (int row[] : dp) {
                Arrays.fill(row, 0);
            }
            for (int i = 0; i <= n; i++)
                dp[i][0] = 1; // if (i < 0) return 0; // value is there in t.
            for (int j = 1; j <= m; j++)
                dp[0][j] = 0; // if (j < 0) return 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        // When match we can take the case or we move further and take other scenario.
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][m];
        }
    }
}
