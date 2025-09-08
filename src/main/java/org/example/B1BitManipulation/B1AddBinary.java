package org.example.B1BitManipulation;

// https://leetcode.com/problems/add-binary/description/

// Given two binary strings a and b, return their sum as a binary string.
// Input: a = "11", b = "1"
// Output: "100"
// Input: a = "1010", b = "1011"
// Output: "10101"

// Iterate starting from end.
// Now a  can be 1011 and b can be 101 then the loop cannot be max as when b[2] there is no value. In this case use while loop till pointer and counter.
public class B1AddBinary {
    public String addBinary(String a, String b) {
        int n = a.length() - 1;
        int n1 = b.length() - 1;
        int count = 0;
        StringBuilder str = new StringBuilder();
        while (n >= 0 || n1 >= 0 || count > 0) {
            char ch = (n >= 0) ? a.charAt(n) : '0';
            char ch1 = (n1 >= 0) ? b.charAt(n1) : '0';
            if (ch == '0' && ch1 == '0') {
                if (count == 1) {
                    str.append('1');
                    count = 0;
                } else str.append('0');
            } else if (ch == '1' && ch1 == '1') {
                if (count == 0) {
                    str.append('0');
                    count = 1;
                } else {
                    str.append('1');
                }
            } else {
                if (count == 1) {
                    str.append('0');
                } else {
                    str.append('1');
                }
            }
            n--;
            n1--;
        }
        System.out.println(str);
        return str.reverse().toString();
    }
}
