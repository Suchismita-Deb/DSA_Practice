package org.example.A1Array.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Implementation {

    // https://leetcode.com/problems/valid-palindrome/description/
    // A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    // Given a string s, return true if it is a palindrome, or false otherwise.
    // Input: s = "A man, a plan, a canal: Panama"
    // Output: true
    // Explanation: "amanaplanacanalpanama" is a palindrome.
    class ValidPalindrome {
        public boolean isPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                if (!Character.isLetterOrDigit(s.charAt(i))) i++;
                else if (!Character.isLetterOrDigit(s.charAt(j))) j--;
                else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
            return true;
        }
    }

    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
    // Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    // Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2. The tests are generated such that there is exactly one solution. You may not use the same element twice. Your solution must use only constant extra space.
    // Input: numbers = [2,7,11,15], target = 9
    // Output: [1,2]
    // Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
    class TwoSum2InputArrayIsSorted {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0;
            int j = numbers.length - 1;
            int[] res = new int[2];
            while (i < j) {
                if (numbers[i] + numbers[j] > target) j--;
                else if (numbers[i] + numbers[j] < target) i++;
                else {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    break;
                }
            }
            return res;
        }
    }
    // https://leetcode.com/problems/3sum/description/
    // Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    // Notice that the solution set must not contain duplicate triplets.

    //Input: nums = [-1,0,1,2,-1,-4]
    //Output: [[-1,-1,2],[-1,0,1]]
    //Explanation:
    //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    //The distinct triplets are [-1,0,1] and [-1,-1,2].
    //Notice that the order of the output and the order of the triplets does not matter.
    class Sum3 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[i] + nums[start] + nums[end] > 0) {
                        end--;
                    } else if (nums[i] + nums[start] + nums[end] < 0) {
                        start++;
                    } else {
                        List<Integer> r = new ArrayList<>();
                        r.add(nums[i]);
                        r.add(nums[start]);
                        r.add(nums[end]);
                        res.add(r);
                        start += 1;
                        while (nums[start] == nums[start - 1] && start < end) {
                            start++;
                        }
                    }
                }
            }
            return res;
        }
    }
    // https://leetcode.com/problems/container-with-most-water/description/
    // You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    // Find two lines that together with the x-axis form a container, such that the container contains the most water.
    // Return the maximum amount of water a container can store.

    //Notice that you may not slant the container.
    // Input: height = [1,8,6,2,5,4,8,3,7]
    //Output: 49
    //Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

    class ContainerWithMostWater {
        public int maxArea(int[] height) {
            int res = 0;
            int left = 0;
            int right = height.length - 1;
            while (left < right) {
                int area = Math.min(height[left], height[right]) * (right - left);
                res = Math.max(area, res);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return res;
        }
    }
}
