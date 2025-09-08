package org.example.A4SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Implementation {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    // You are given an array prices where prices[i] is the price of a given stock on the ith day.
    // You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    // Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    // Example 1:
    // Input: prices = [7,1,5,3,6,4]
    // Output: 5
    // Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    // Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    class BestTimeToBuyAndSellStock {
        public int maxProfit(int[] prices) {
            int[] prefix = new int[prices.length];
            prefix[0] = 100000;
            for (int i = 1; i < prices.length; i++) {
                prefix[i] = Math.min(prefix[i - 1], prices[i - 1]);
            }
            System.out.println(Arrays.toString(prefix));
            // [100000, 7, 1, 1, 1, 1]
            int max = 0;
            for (int i = prices.length - 1; i >= 0; i--) {
                max = Math.max(max, prices[i] - prefix[i]);
            }
            return max;
        }
    }

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    // Given a string s, find the length of the longest substring without repeating characters.
    // Input: s = "abcabcbb"
    // Output: 3
    // Explanation: The answer is "abc", with the length of 3.
    // Input: s = "bbbbb"
    // Output: 1
    // Explanation: The answer is "b", with the length of 1.
    class Solution {
        public int LongestSubstringWithoutRepeatingCharacters(String s) {
            int i = 0, j = 0;
            int max = Integer.MIN_VALUE;
            if (s.length() <= 1) return s.length();
            HashSet<Character> hset = new HashSet<>();
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

    // https://leetcode.com/problems/longest-repeating-character-replacement/description/
    // You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
    // Return the length of the longest substring containing the same letter you can get after performing the above operations.
    // Example 1:
    // Input: s = "ABAB", k = 2
    // Output: 4
    // Explanation: Replace the two 'A's with two 'B's or vice versa.
    class LongestRepeatingCharacterReplacement {
        // TODO
        // Sliding Window often needs hashmap for the variable size window.
        public int characterReplacement(String s, int k) {
            // When changing the char in the string then the value and the string are changing.
            // When checking for the next window the string will be not in exact form.
            // In this case it is stored in hashmap and get the char value.

            // We have the count of all the char and for the max value we are checking if by changing any other char for k times if we are getting the max value.

            // ABABBA - Substring BABB we need to replace the A - the smallest occurring char here A.
            // Maintain the count - hashmap.
            // WindowLength = 4 Count of most char = 3. 4-3 = 1 is the total count of char needs to be replaced.

            // Left and right pointing to the start. Right will increase an check like substring A.
            // Check the formula windowLength = 1. Most frequent char count = 1. 1-1<=k satisfy then continue.
            // Here will focus on the count and not on the string.
            // ABABBA - When right will be at the end then frequence of A = 3 and B = 3. Now we have to remove the left pointer and check a freq = 2 and b = 3.
            // Now the formula is successful then continue.
            int left = 0;
            int right = 0;
            int mostLetter = 0;
            int[] arr = new int[26];
            int res = 0;
            int letterChange = 0;
            while (right < s.length()) {
                arr[s.charAt(right) - 'A']++;
                mostLetter = Math.max(mostLetter, arr[s.charAt(right) - 'A']);
                while ((right - left + 1) - mostLetter > k) {
                    arr[s.charAt(left) - 'A']--;
                    left++;
                }
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;
        }
    }

    // https://leetcode.com/problems/permutation-in-string/description/
    // Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
    // In other words, return true if one of s1's permutations is the substring of s2.
    // Input: s1 = "ab", s2 = "eidbaooo"
    // Output: true
    // Explanation: s2 contains one permutation of s1 ("ba").
    class PermutationString {
        public boolean checkInclusion(String s1, String s2) {
            // S1 is present in s2 so checking with the window size.
            // Frequency is s1 should match with the same length of frequency of s2.
            int n1 = s1.length();
            int n2 = s2.length();
            int[] freq = new int[26];
            for (int i = 0; i < n1; i++) {
                freq[s1.charAt(i) - 'a']++;
            }
            int[] freq1 = new int[26];
            for (int i = 0; i < n2; i++) {
                freq1[s2.charAt(i) - 'a']++;
                if (i >= n1) {
                    freq1[s2.charAt(i - n1) - 'a']--;
                }
                if (Arrays.equals(freq, freq1)) {
                    return true;
                }
            }
            return false;
        }
    }

    // https://leetcode.com/problems/minimum-window-substring/description/
    // Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
    // The testcases will be generated such that the answer is unique.
    // Input: s = "ADOBECODEBANC", t = "ABC"
    //Output: "BANC"
    //Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
    class MinimumWindowSubstring {
        // TODO
        public String minWindow(String s, String t) {
            // Making one hashmap to store the char count of t as it contains duplicates.

            // One pointing start and another substring where the char count of s matches with t.

            // To check the match will take the t hashmap and the word hashmap and store the count. If the char at word is matching with the count of the char then update the variable by 1.

            // When the count of word matches with count of t then update the variable by 1 and if the variable matches with the total char needed then the substring contains all char and we can store the length.

            // Then we can increase the i pointer from the start and keep on check the char in the map. If no change then continue the i++ if not then increase the j and make the substring valid.

            // Will take the min length.

            HashMap<Character, Integer> hmapT = new HashMap<>();
            for (char x : t.toCharArray()) {
                // Converting a string to a chararray toCharArray()
                hmapT.put(x, hmapT.getOrDefault(x, 0) + 1);
            }
            int matched = 0;
            int start = 0;
            int minLen = s.length() + 1; // Any value that will not come in the answer.
            int subStr = 0;

            for (int endWindow = 0; endWindow < s.length(); endWindow++) {
                // if the char is present in the string t. Then incresae the count in the map.
                char rightChar = s.charAt(endWindow);
                if (hmapT.containsKey(rightChar)) {
                    hmapT.put(rightChar, hmapT.get(rightChar) - 1); // If present then value will be deduct.
                    if (hmapT.get(rightChar) == 0) matched++; // When the count is 0 the increase the matched.
                }

                while (matched == hmapT.size()) {
                    if (minLen > endWindow - start + 1) {
                        minLen = endWindow - start + 1;
                        subStr = start;
                    }
                    char deletedChar = s.charAt(start);
                    start++;
                    if (hmapT.containsKey(deletedChar)) {
                        if (hmapT.get(deletedChar) == 0) matched--;
                        hmapT.put(deletedChar, hmapT.get(deletedChar) + 1);
                    }
                }
            }
            return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
        }
    }
}
