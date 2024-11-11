package org.example.Premium.Amazon;

// https://leetcode.com/problems/reorder-data-in-log-files/

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

// You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
//
//There are two types of logs:
//
//Letter-logs: All words (except the identifier) consist of lowercase English letters.
//Digit-logs: All words (except the identifier) consist of digits.
//Reorder these logs so that:
//
//The letter-logs come before all digit-logs.
//The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
//The digit-logs maintain their relative ordering.
//Return the final order of the logs.
//
//
//
//Example 1:
//
//Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
//Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
//Explanation:
//The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
//The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
public class ReorderDataInLogFile {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            ArrayList<String> letterLog = new ArrayList<>();
            ArrayList<String> digitLog = new ArrayList<>();
            TreeMap<String, String> mp = new TreeMap<>();
            for (String s : logs) {
                String[] str = s.split(" ");
                if (isNumeric(str[1])) {
                    digitLog.add(s);
                } else {
                    int len = str.length;
                    StringBuilder strBuilder = new StringBuilder();
                    for (int i = 1; i < len; i++) {
                        strBuilder.append(str[i]);
                    }
                    mp.put(str[0], strBuilder.toString());
                    letterLog.add(s);
                }
            }
            System.out.println(digitLog);
            System.out.println(letterLog);
            System.out.println(mp);

            Collections.sort(letterLog, (log1, log2) -> {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                // Compare based on the content first, then by the identifier
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp == 0) {
                    return split1[0].compareTo(split2[0]); // If contents are the same, compare by identifier
                }
                return cmp;
            });

            String[] res = new String[logs.length];

            int pos = 0;

            for (int i = 0; i < letterLog.size(); i++) {
                res[pos++] = letterLog.get(i);
            }
            for (int i = 0; i < digitLog.size(); i++) {
                res[pos++] = digitLog.get(i);
            }
            return res;
        }

        boolean isNumeric(String str) {
            for (char ch : str.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }
            return true;
        }
    }
}
