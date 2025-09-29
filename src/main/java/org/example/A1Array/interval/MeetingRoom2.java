package org.example.A1Array.interval;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/meeting-rooms-ii/
// Given an array of meeting time intervals where intervals[i] = [start, end], return the minimum number of conference rooms required.
// Intervals = [[0,30],[5,10],[15,20]]
// Output: 2

// (0,30),(10,15),(15,20)
// Here the start and the end is  15. In the question res = 2 and the end will be first then  the start.
// Make the start array with all the starting point and the end with the ending point.
// start =[0,10,15]
// end=[15,20,30]
// Start point 0. startvalue<endvalue 0<15 counter++ and start++. When start at 15 and end at 15 then move the end pointer and when all the start value are done then return max counter.


public class MeetingRoom2 {
    // Count the number of overlapping intervals. Merge the overlapping intervals and then check for the size.
    // Copy the array and then check the size.

    public int minMeetingRoom(List<int[]> intervals){
        int n = intervals.size();
        int start[] = new int[n];
        int end[] = new int[n];

        for(int i=0;i<n;i++){
            int arr[] = intervals.get(i);
            start[i] = arr[0];
            end[i] = arr[1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int count=0,res=0;
        int s=0, e=0;
        while(s<n){
            if(start[s]<end[s]){
                count++;
                s++;
            }
            else{
                count--;
                e++;
            }
            res = Math.max(count,res);
        }

        return res;
    }
}
