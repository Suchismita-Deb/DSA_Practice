package org.example.array.interval;

import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals/description/
// intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
public class NonOverlappingIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals,(a, b)->(a[0]-b[0]));
            int count=0;
            int end = intervals[0][1];
            for(int i=1;i<intervals.length;i++){
                if(intervals[i][0]<end){
                    count++;
                    end = Math.min(end,intervals[i][1]); // Greedy as quickly I want the end so that I can get more intervals.
                }
                else{
                    end = intervals[i][1];
                }
            }
            return count;
        }
    }
}
