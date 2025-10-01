package org.example.Premium.Amazon.AmazonSpringStudyPlan23;

// https://leetcode.com/problems/number-of-ways-to-select-buildings/description/

// You are given a 0-indexed binary string s which represents the types of buildings along a street where:
// s[i] = '0' denotes that the ith building is an office and
// s[i] = '1' denotes that the ith building is a restaurant.
// As a city official, you would like to select 3 buildings for random inspection. However, to ensure variety, no two consecutive buildings out of the selected buildings can be of the same type.
// For example, given s = "001101", we cannot select the 1st, 3rd, and 5th buildings as that would form "011" which is not allowed due to having two consecutive buildings of the same type.
// Return the number of valid ways to select 3 buildings.

// Input: s = "001101"
// Output: 6
// Explanation:
// The following sets of indices selected are valid:
// [0,2,4] from "001101" forms "010"
// [0,3,4] from "001101" forms "010"
// [1,2,4] from "001101" forms "010"
// [1,3,4] from "001101" forms "010"
// [2,4,5] from "001101" forms "101"
// [3,4,5] from "001101" forms "101"
//No other selection is valid. Thus, there are 6 total ways.
public class NumberOfWaysToSelectBuildings {
    class Solution {
        public long numberOfWays(String s) {
            // When there is a count to select the number like 3 or 5 then first set the
            // middle element and then choose the left and right.

            // 010 and 101 are the options.
            // The constraints are big so dp will not work.
            // When there is the middle 0 then see how many 1 on the left side and how many on the right side.
            // 0 1 2 3 4 5
            // 0 0 1 1 0 1
            // For the 0 at index 1, number of 1 on the left side is 0 and number of 1 on the right side is 3. We can choose the 1 at index 2 or 3 or 5. In the case we can make the element for all the 1's in the left.
            // Total number of valid element are (count of 1 in left*count of 1 i right) =
            // 0*3 = 0 for taking the 0 at index 1.
            long res = 0;
            long[] prez = new long[s.length()];
            long[] preo = new long[s.length()];
            prez[0] = s.charAt(0) == '0' ? 1 : 0;
            preo[0] = s.charAt(0) == '1' ? 1 : 0;
            for (int i = 1; i < s.length(); i++) {
                preo[i] = preo[i - 1];
                prez[i] = prez[i - 1];
                if (s.charAt(i) == '1') {
                    preo[i] += 1;
                } else {
                    prez[i] += 1;
                }
            }
            // Thinking of that for one 0 we need to see the prefix 1 at the left and 1 in the right and for value 1 we need to check the prefix 0 in the left and in the right. I thought that we may need the prefix1 and 0 for the left and right. we donot need it we can use the prefix 1 and 0 only to see teh left and right. Only count for the index 1 to n-1 as total 3 element and there should be one element in the left when we consider the middle element.
            int n = s.length();
            for (int i = 1; i < s.length() - 1; i++) {
                if (s.charAt(i) == '1') {
                    res += prez[i - 1] * (prez[n - 1] - prez[i]);
                } else {
                    res += preo[i - 1] * (preo[n - 1] - preo[i]);
                }
            }
            return res;
        }
    }
}
