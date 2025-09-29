package org.example.A1Array.interval;

// https://leetcode.com/problems/merge-intervals/description/

import java.util.ArrayList;
import java.util.Arrays;

// Intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
public class MergeInterval {
    class Solution {
        public int[][] merge(int[][] intervals) {
            int val[][] = new int[intervals.length][2];
            for(int i=0;i<intervals.length;i++){
                for(int j=0;j<2;j++){
                    val[i][j] = intervals[i][j];
                }
            }
            Arrays.sort(intervals); //  (a, b) ->Integer.compare(a[0],b[0]) default.

            ArrayList<int[]> ans = new ArrayList<>();
            // ArrayList of array.
            ans.add(intervals[0]);

            for(int i=1;i<intervals.length;i++){
                int currStart = intervals[i][0];
                int lastEnd = ans.get(ans.size()-1)[1];
                if(currStart<=lastEnd){ // [[1,3],[2,6]] Added [1,3] in list and then [2,6] and then checking the max value and updating the list.
                    int finalEnd = Math.max(intervals[i][1],lastEnd);
                    ans.get(ans.size()-1)[1] = finalEnd;
                }
                else{
                    ans.add(intervals[i]);
                }
            }
            // int res[][] = new int[ans.size()][2];
            // The size is dynamic. We need the arraylist.
            // return ans.toArray(res);
            return ans.toArray(new int[ans.size()][2]);

        }
    }
}
