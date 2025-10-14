package org.example.A2BinarySearch;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

// [3,4,5,1,2] Output: 1
//Explanation: The original array was [1,2,3,4,5] rotated 3 times.

public class B04MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        // Need to find the smallest value. Template code used in many cases.
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int minVal = nums[0];

        while (left <= right) {
            int mid = (left + right) / 2;
            int leftVal = nums[left];
            int rightVal = nums[right];
            int midVal = nums[mid];
            minVal = Math.min(minVal, midVal);
            // [3,4,5,1,2] Mid = 5 storing in res.
            if (rightVal > leftVal) {
                minVal = Math.min(minVal, leftVal); // In the sorted part.
                break;
            }
            // [3,4,5,1,2] Middle smaller than left then will go to the left portion to find the min.
            // If mid is smaller than right then go to the right portion to find the min.
            if (midVal >= leftVal) { // In the greater half smaller element is in the left.
                left = mid + 1; // [3,4,5,1,2] // (5 >= 3)
            } // left is pointing to 1 and right is pointing to 2
            else if(minVal < leftVal){  // [5,6,7,1,2,3,4] say mid is pointing to 2.
                right = mid - 1; // (2<5) so right is pointing to 7. The pointing part is sorted so geting the min as left that is 7. Min is already 1 so the minimum value is 1.
            }
        }
        return minVal;
    }
}
