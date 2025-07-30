package org.example.A1Array.implementation;

// https://leetcode.com/problems/encode-and-decode-strings/description/

// Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
//
//Machine 1 (sender) has the function:
//
//string encode(vector<string> strs) {
//  // ... your code
//  return encoded_string;
//}
//Machine 2 (receiver) has the function:
//vector<string> decode(string s) {
//  //... your code
//  return strs;
//}
//So Machine 1 does:
//
//string encoded_string = encode(strs);
//and Machine 2 does:
//
//vector<string> strs2 = decode(encoded_string);
//strs2 in Machine 2 should be the same as strs in Machine 1. Implement the encode and decode methods. You are not allowed to solve the problem using any serialize methods (such as eval).

import java.util.ArrayList;
import java.util.List;

//Input: dummy_input = ["Hello","World"]
//Output: ["Hello","World"]
//Explanation:
//Machine 1:
//Codec encoder = new Codec();
//String msg = encoder.encode(strs);
//Machine 1 ---msg---> Machine 2
//
//Machine 2:
//Codec decoder = new Codec();
//String[] strs = decoder.decode(msg);
public class EncodeAndDecodeString {
    public class Solution {

        public String encode(List<String> strs) {
            StringBuilder encodedString = new StringBuilder();
            for (String str : strs) {
                encodedString.append(str.length()).append("#").append(str);
            }
            return encodedString.toString();
        }

        public List<String> decode(String str) {
            List<String> list = new ArrayList<>();
            int i = 0;
            while (i < str.length()) {
                int j = i;
                while (str.charAt(j) != '#') j++;

                int length = Integer.valueOf(str.substring(i, j));
                i = j + 1 + length;
                list.add(str.substring(j + 1, i));
            }
            return list;
        }
    }

}
