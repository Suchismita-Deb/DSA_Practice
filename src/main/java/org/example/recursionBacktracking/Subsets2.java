package org.example.recursionBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    No duplicates. When got the same number then move the pointer to the end.
 */
public class Subsets2 {
    class Iterative {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            subsetArray(nums, 0, list, l);
            return list;
        }

        void subsetArray(int[] nums, int i, List<List<Integer>> list, List<Integer> l) {
            // Adding in the list. No need to check for any base case.
            list.add(new ArrayList<>(l));
            for (int j = i; j < nums.length; j++) {
                // Checking with the value and only taking the first value.
                if (j != i && nums[j] == nums[j - 1]) continue;
                l.add(nums[j]); // include
                subsetArray(nums, j + 1, list, l); // explore. Always j+1.
                l.remove(l.size() - 1); // remove.
            }
        }
    }

    class Recursion {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> subList = new ArrayList<>();
            subsetsNoDup(nums, 0, list, subList);
            return list;
        }

        void subsetsNoDup(int[] nums, int i, List<List<Integer>> list, List<Integer> subList) {
            if (i == nums.length) {
                list.add(new ArrayList<>(subList));
                return;
            }

            // Include the element.
            subList.add(nums[i]);
            subsetsNoDup(nums, i + 1, list, subList);

            // Remove the element.
            subList.remove(subList.size() - 1);

            // If similar elemnet then we should move the index to the element where it is
            // not similar.
            // [1,2,2,3] i should point to 3.
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            subsetsNoDup(nums, i + 1, list, subList);

        }
    }
}
