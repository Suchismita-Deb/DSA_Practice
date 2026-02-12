package org.example.A2BinarySearch;

// https://leetcode.com/problems/search-a-2d-matrix/description/

public class B02Search2dMatrix {
    public boolean searchMatrix(int[][] nums, int target) {
        int row = nums.length;
        int col = nums[0].length;

        int topRow = 0;
        int botRow = row - 1;

        // Finding the target row.
        while (topRow <= botRow) {
            int midRow = (topRow + botRow) / 2;
            if (nums[midRow][0] > target) {
                botRow = midRow - 1;
            } else if (nums[midRow][col - 1] < target) {
                topRow = midRow + 1;
            } else {
                break;
            }
        }

        if (topRow > botRow) return false;

        // Row containing the value. Finding the exact row.
        // If value is not present in this row then the value is not present return -1.
        int validRow = (topRow + botRow) / 2;

        int left = 0, right = col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[validRow][mid] > target) {
                right--;
            } else if (nums[validRow][mid] < target) {
                left++;
            } else {
                return true;
            }
        }
        return false;

    }
    /*
    Another approach.
    class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = 0, m = matrix[0].length - 1;
        while (n < matrix.length && m >= 0) {
            if (matrix[n][m] == target) {
                return true;
            } else if (matrix[n][m] > target) {
                m--;
            } else {
                n++;
            }
        }
        return false;
        }
    }
     */
}
