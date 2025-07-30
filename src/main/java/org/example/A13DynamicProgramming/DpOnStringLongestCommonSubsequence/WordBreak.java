package org.example.A13DynamicProgramming.DpOnStringLongestCommonSubsequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-break/description/

public class WordBreak {
    class Solution1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean dp[] = new boolean[s.length() + 1];
            dp[s.length()] = true;
            Set<String> st = new HashSet<>();
            for (String sr : wordDict) {
                st.add(sr);
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                for (String w : st) {
                    if (i + w.length() <= s.length() && s.startsWith(w, i)) {
                        // String myStr = "Hello";
                        // System.out.println(myStr.startsWith("He"));   // true
                        dp[i] = dp[i + w.length()];
                    }
                    if(dp[i]){

                        break;
                    }
                }
            }

            return dp[0];
        }
    }
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> st = new HashSet<>();
            for (String sr : wordDict) {
                st.add(sr);
            }
            int[] dp = new int[301];
            Arrays.fill(dp, -2);
            System.out.println(st);
            return checkSub(s, st, 0, dp) == 1;
        }

        int checkSub(String s, Set<String> st, int i, int[] dp) {
            if (i == s.length()) return dp[i] = 1;
            if (dp[i] != -2) return dp[i];
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                temp.append(s.charAt(j));
                // System.out.println(temp);
                String str = temp.toString(); // Set of string so we need to convert to string and not compare withs
                // stringbuilder.
                if (st.contains(str)) {
                    System.out.println(str);
                    if (checkSub(s, st, j + 1, dp) == 1) {
                        return dp[i] = 1;
                    }
                }
            }
            return dp[i] = -1;
        }
    }
}
