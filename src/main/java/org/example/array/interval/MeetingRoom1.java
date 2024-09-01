package org.example.array.interval;

// https://leetcode.com/problems/meeting-rooms/description/

import java.util.Arrays;

// Given an array of meeting time intervals where intervals[i] = [start, end], determine if a person could attend all meetings.
// Intervals = [[0,30],[5,10],[15,20]]
// Output: false
public class MeetingRoom1 {
    // Sort on the basis of the first value.
    // If there is any overlapping then return false;
    // for the interval[i][0]<interval[i-1][1] then false.
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, (a, b)->Integer.compare(b[0],a[0]));
            // Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
            for(int i=1;i< intervals.length;i++){
                if(intervals[i][0]<intervals[i-1][1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
