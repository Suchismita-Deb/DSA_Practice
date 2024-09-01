package org.example.Premium;

// Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]
// nums = [3,5,2,1,6,4]
// Output: [3,5,1,6,2,4]

// One way to sort the array [1,2,3,4,5,6].
// 2>1 but 2!>3 so swap between 2 and 3. [1,3,2,4,5,6] Greater so all the elements will ebe greater than 1 so no issue.
// when we got 2 and 4 then 4>2 but 4!>5 so swap between 4 and 5. When we do not get the condition satisfy then swap. O(NlogN)

// Another approach.
// In the given array 3 nd 5 is sorted, 2>1 but 2!>5 so swap between 2 and 1.
// [3,5,1,2,6,4] Till 1 is good but 2!>6 so swap between 2 and 6 then all values are correct.

// 0 1 2 3 4 5
// 3 5 2 1 6 4
// index 1 should be greater than 0 and index 2 should be less than 1.
// Odd index should be greater than the prev index and the even index should be smaller than the previous index.
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n-1; i++) {
            if((i%2==0 && nums[i]>=nums[i+1]) || (i%2==1 && nums[i]<=nums[i+1]))
                swap(nums, i, i+1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
