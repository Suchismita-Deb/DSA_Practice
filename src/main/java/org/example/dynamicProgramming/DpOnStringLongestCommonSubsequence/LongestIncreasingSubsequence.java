package org.example.dynamicProgramming.DpOnStringLongestCommonSubsequence;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    class Solution {
        // Check the notes of the course.
        // The count of the lis is correct but the sequence will not be correct.
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0)
                return 0;
            ArrayList<Integer> lis = new ArrayList<>();
            lis.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] <= lis.get(lis.size() - 1)) {
                    for (int j = 0; j <lis.size() ; j++) {

                        if (lis.get(j)>=nums[i]) {
                            lis.set(j, nums[i]);
                            break;
                        }
                    }
                }
                else{
                    lis.add(nums[i]);
                }
            }
            return lis.size();
        }
    }
}
