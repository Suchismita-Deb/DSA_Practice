package org.example.array.interval;

import java.util.ArrayList;

// https://leetcode.com/problems/insert-interval/description/
// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
// intervals = [[1,3],[6,9]], newInterval = [2,5]
// [[1,5],[6,9]]
public class InsertInterval {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            ArrayList<int[]> ans = new ArrayList<>();
            for (int[] interval : intervals) {
                if (newInterval == null || interval[1] < newInterval[0]) {
                    // [[8,9]]
                    // [12,15] ( 9<12 meaning new will not be in the interval)
                    // Interval go before the value.
                    ans.add(interval); // Adding the interval.
                } else if (interval[0] > newInterval[1]) {
                    // [[8,9],[12,15]]
                    // [1,7]
                    ans.add(newInterval);
                    // newInterval after the interval.
                    ans.add(interval); // newInterval is before the interval and we can add the new interval and also the interval as there will be no merge.
                    newInterval = null;// Making the newInterval as null and can add all the other interval.
                } else {
                    // [[1,3],[5,7]]
                    // [2,6]
                    // [[1,7]]
                    // Updating the new interval.
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                    // newInterval = [1,6] not adding the changes yet to the list and checking for the next interval.
                    // In the next run it will take the min and max and the range will be [1,7].
                }
            }
            if (newInterval != null)
                ans.add(newInterval);
            return ans.toArray(new int[ans.size()][]);
        }
    }
}
