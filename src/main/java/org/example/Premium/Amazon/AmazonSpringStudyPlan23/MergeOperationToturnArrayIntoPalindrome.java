package org.example.Premium.Amazon.AmazonSpringStudyPlan23;

// You are given an array nums consisting of positive integers.
//
//You can perform the following operation on the array any number of times:
//
//Choose any two adjacent elements and replace them with their sum.
//For example, if nums = [1,2,3,1], you can apply one operation to make it [1,5,1].
//Return the minimum number of operations needed to turn the array into a palindrome.

//Example 1:
//Input: nums = [4,3,2,1,2,3,1]
//Output: 2
//Explanation: We can turn the array into a palindrome in 2 operations as follows:
//- Apply the operation on the fourth and fifth element of the array, nums becomes equal to [4,3,2,3,3,1].
//- Apply the operation on the fifth and sixth element of the array, nums becomes equal to [4,3,2,3,4].
//The array [4,3,2,3,4] is a palindrome.
//It can be shown that 2 is the minimum number of operations needed.
public class MergeOperationToturnArrayIntoPalindrome {
    class Solution {
        public int minimumOperations(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int count = 0;
            while (left <= right) {
                if (nums[left] < nums[right]) {

                    left++;
                    nums[left] += nums[left - 1];
                    count++;
                } else if (nums[right] < nums[left]) {
                    right--;
                    nums[right] += nums[right + 1];
                    count++;
                } else {
                    left++;
                    right--;
                }
            }
            return count;
        }
    }
}
