package org.example.A11RecursionBacktracking;

// https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.List;

// candidates = [2,3,6,7], target = 7.
// Given distinct integer. return a list of all unique combinations of candidates where the chosen numbers sum to target. Same number can be taken multiple times.
// Output = [[2,2,3],[7]]
public class CombinationSum {
    class Solution {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> ans = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<List<Integer>>();

            combinationSum(candidates, target, ans, 0, 0, res);
            return res;
        }

        void combinationSum(int arr[], int target, List<Integer> ans, int ind, int sum, List<List<Integer>> res) {
            // Here I need to add the ans to the res so no need to return type.
            // Generally in backtracking we have void return type and global variable for
            // the ans.
            // We can pass tings in the parameter. Things which we are passing in parameter
            // donot need to be in the return type.
            if (ind >= arr.length || sum > target)
                return;
            if (sum == target) {
                res.add(new ArrayList<>(ans));
            }
            /*
             * if (arr[ind] + sum <= target) {
             * sum += arr[ind];
             * ans.add(arr[ind]);
             * combinationSum(arr, target, ans, ind, sum);
             * sum -= arr[ind];
             * } else {
             * combinationSum(arr, target, ans, ind + 1, sum);
             * sum -= arr[ind];
             * }// For the condition differnt block not needed we can call the method.
             */
            else {
                ans.add(arr[ind]);
                combinationSum(arr, target, ans, ind, sum + arr[ind], res);
                // sum -= ans.get(ans.size() - 1);
                ans.remove(ans.get(ans.size() - 1));
                combinationSum(arr, target, ans, ind + 1, sum, res);
            }
        }
    }
}
