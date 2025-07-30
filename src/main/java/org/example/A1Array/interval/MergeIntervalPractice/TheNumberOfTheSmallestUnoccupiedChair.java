package org.example.A1Array.interval.MergeIntervalPractice;

// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/

// There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.
// For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
// When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, they can sit in that chair.
// times[i] = [arrivali, leavingi], and an integer targetFriend. All arrival times are distinct.
// Return the chair number that the friend numbered targetFriend will sit on.

// Input: times = [[1,4],[2,3],[4,6]], targetFriend = 1
// Output: 1
// Friend 0 arrives at time 1 and sits on chair 0.
// Friend 1 arrives at time 2 and sits on chair 1.
// Friend 1 leaves at time 3 and chair 1 becomes empty.
// Friend 0 leaves at time 4 and chair 0 becomes empty.
// Friend 2 arrives at time 4 and sits on chair 0.
//Since friend 1 sat on chair 1, we return 1.
public class TheNumberOfTheSmallestUnoccupiedChair {
}
