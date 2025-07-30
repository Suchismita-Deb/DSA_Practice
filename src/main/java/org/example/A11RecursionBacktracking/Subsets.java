package org.example.A11RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/

public class Subsets {
    class Iterative {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            // Adding one empty subset [[]]
            // Adding 1 to []: [[], [1]];
            // Adding 2 to [] and [1]: [[], [1], [2], [1, 2]];
            // Adding 3 to [], [1], [2] and [1, 2]: [[], [1], [2], [1, 2], [3], [1, 3], [2,3], [1, 2, 3]]
            for (int num : nums) {
                int s = list.size();
                for (int i = 0; i < s; i++) {
                    // Here first we need to get the value of the list.size then use in the for loop
                    // as inside the loop we are changing the list size so it will go in infinite loop.
                    List<Integer> subList = new ArrayList<>(list.get(i));
                    // The subList should directly get the value of the ith element and not only
                    // Initilization as it will create empty value.
                    subList.add(num);
                    list.add(subList);
                }
            }
            return list;
        }
    }
    class Recursion {
        public List<List<Integer>> subsets(int[] nums) {
            // Recurrence.
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> subList = new ArrayList<>();
            subsetArray(nums, 0, list, subList);
            return list;
        }

        void subsetArray(int nums[], int i, List<List<Integer>> list, List<Integer> subList) {
            if (i == nums.length) {
                list.add(new ArrayList<>(subList));
                return;
            }
            // Pick the number.
            subList.add(nums[i]);
            subsetArray(nums, i + 1, list, subList);
            // Remove the number.
            subList.remove(subList.size() - 1);
            subsetArray(nums, i + 1, list, subList);
        }
    }
}
