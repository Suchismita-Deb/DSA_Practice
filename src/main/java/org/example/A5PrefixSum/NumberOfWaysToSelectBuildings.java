package org.example.A5PrefixSum;

//https://leetcode.com/problems/number-of-ways-to-select-buildings/?envType=study-plan-v2&envId=amazon-spring-23-high-frequency
public class NumberOfWaysToSelectBuildings {
    class Solution {
        public long numberOfWays(String s) {
            // Tips - When there is a count to select the number like 3 or 5 then first set the middle element and then choose the left and right.

            // 010 and 101 are the options.
            // The constraints are big so dp will not work.
            // When there is the middle 0 then see how many 1 on the left side and how many on the right side.
            // 0 1 2 3 4 5
            // 0 0 1 1 0 1
            // For the 0 at index 1, number of 1 on the left side is 0 and number of 1 on the right side is 3. We can choose the 1 at index 2 or 3 or 5. In the case we can make the element for all the 1's in the left.
            // Total number of valid element are (count of 1 in left*count of 1 i right) = 0*3 = 0 for taking the 0 at index 1.
            long res = 0;
            long prez[] = new long[s.length()];
            long preo[] = new long[s.length()];
            prez[0] = s.charAt(0) == '0' ? 1 : 0;
            preo[0] = s.charAt(0) == '1' ? 1 : 0;
            for (int i = 1; i < s.length(); i++) {
                preo[i] = preo[i-1];
                prez[i] = prez[i-1];
                if (s.charAt(i) == '1') {
                    preo[i] += 1;
                } else {
                    prez[i] += 1;
                }
            }
            // Thinking of that for one 0 we need to see the prefix 1 at the left and 1 in the right and for value 1 we need to check the prefix 0 in the left and in the right. I thought that we may need the prefix1 and 0 for the left and right. we do not need it we can use the prefix 1 and 0 only to see teh left and right.
            // Only count for the index 1 to n-1 as total 3 element and there should be one element in the left when we consider the middle element.
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
