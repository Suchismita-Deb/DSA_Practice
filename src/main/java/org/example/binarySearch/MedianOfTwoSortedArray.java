package org.example.binarySearch;

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
public class MedianOfTwoSortedArray {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // Merge sort and get the elements in the same array then O(N) operations.

            // O(log(m+n)) array is already soretd so can think of binary search. When there is log then think of binary search.
            // num1[] = [1,2,3,4,5,6,7,8]
            // nums2[] = [1,2,3,4,5]
            // array[] = [1,1,2,2,3,3,4,4,5,5,6,7,8]
            // Median = 4. 6 element in both side.
            // Total number of element = 13. So the middle = 13/2 = 6.
            // We can make the sorted array till the middle. Left should be like half.
            // In nums2 the left pointer at 0 and the right pointer end and the middle is 3 so from left to the middle is 3 element. The half is 6 so I need another 3 element. Taking from nums1[] first 3 element. Then we need to check if it is the correct left side. So checking if the num1[2] < nums2[3] and if nums2[2] < nums[3] left part is correct.
            // In the array[] the median is the 4 meaning if the size is odd then after finding the left part we can check the min(nums1[leftPart+1], nums2[leftPart+1]) here both are 4 if there were 5 then the min is considered.

            // If the total size is 12.
            // num1[] = [1,2,3,4,5,6,7,8]
            // nums2[] = [1,2,3,4]
            // array[] = [1,1,2,2,3,3,4,4,5,6,7,8]
            // The mid of nums2 is 1 so consider the first 2 element.
            // [1,2] then the mid is 6. SO taking 6-2 = 4 element from nums1[] = [1,2,3,4] and checking that 2<5 this is correct, 4!<3 not correct so left part not correct. Take the left of the array and point to mid+1 so left pinter is at 3 and mid is also 3. So taking till 3 and then taking 6-3 = 3 element form nums1 s element are [1,2,3] in both the array. Then the median is avg of 3 and 4 so taking the max of left part and min of right part.
            int n = nums1.length;
            int m = nums2.length;
            // Binary search on smaller array.
            if (n > m) {
                // If nums1 is bigger array then swap.
                return findMedianSortedArrays(nums2, nums1);
            }
            // Binary search on nums1 as it is smaller.
            int half = (n + m + 1) / 2;
            int left = 0;
            int right = n;
            while (left <= right) {
                int midNum1 = (left + right) / 2;
                int midNum2 = half - midNum1;

                // We are considering the index and it can go out of bound <0 then int min and more than size then intMax.
                int num1Left = (midNum1 <= 0) ? Integer.MIN_VALUE : nums1[midNum1 - 1];
                int num1Right = (midNum1 == n) ? Integer.MAX_VALUE : nums1[midNum1];
                int num2Left = (midNum2 <= 0) ? Integer.MIN_VALUE : nums2[midNum2 - 1];
                int num2Right = (midNum2 == m) ? Integer.MAX_VALUE : nums2[midNum2];
                // Correct portion.
                if (num1Left <= num2Right && num2Left <= num1Right) {
                    if ((n + m) % 2 != 0) {
                        return Math.max(num1Left, num2Left);
                    } else {
                        return (Math.max(num1Left, num2Left) + Math.min(num1Right, num2Right)) / 2.0;
                    }
                } else if (num1Left > num2Right) {
                    right = midNum1 - 1;
                } else {
                    left = midNum1 + 1;
                }
            }
            return 0;
        }
    }
}
