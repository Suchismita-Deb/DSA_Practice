package org.example.Premium.Amazon;

// You are given a 0-indexed string s consisting of only lowercase English letters. In one operation, you can change any character of s to any other character.
//
//Return true if you can make s a palindrome after performing exactly one or two operations, or return false otherwise.
//Input: s = "abcdba"
//Output: true
//Explanation: One way to make s a palindrome using 1 operation is:
//- Change s[2] to 'd'. Now, s = "abddba".
//One operation could be performed to make s a palindrome so return true.

// s.length()<=10^5
public class ValidPalindrome4 {
    class Solution {
        public boolean makePalindrome(String s) {
            int count = 0;
            int left = 0;
            int right = s.length() - 1;
            while (left <= right) {
                char chLeft = s.charAt(left);
                char chRight = s.charAt(right);
                if (chLeft != chRight) {
                    count++;
                    if (count > 2) {
                        return false;
                    }
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
