package org.example.heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // tasks = ["A","A","A","B","B","B"], n = 2
    // Output - 8.
    // Tasks can be completed in any order, identical tasks must be separated by at least n intervals due to cooling time. Return the minimum number of intervals required to complete all tasks.
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            // A _ _ A need 2 unit of space between same task. In the middle we can do one B.
            // A B _ A B _ A B
            // AAABBCC n=1 We should process the most frequent char first
            // CBCBA_A_A more time. So first the most frequency character.
            // ABABAC_C ABACABC Count will be updated after every
            // A taken then count of A reduced A->2 B->2 C->2.
            // Taking anything between B and C say B then AB count  A->2 B->1 C->2
            // Taking anything between A and C say A then ABA count A->1 B->1 C->2
            // Taking C ABAC count A->1 B->1 C->1
            // Taking A then ABACA then count A->0 B->1 C->1
            // Taking B and C now. So ABACABC. We calculate the frequency after every change and getting the max count so using the max heap.

            // Max heap pop the element in O(logN).
            // Max heap - 3 2 2 N=1 Time initially = 0 Queue containing frequency and time.
            // Taking first element and making the count 2 and time = 1 remove from max heap and adding in queue. Queue contains 2,2 (frequency of the char and the time after which this character is available (n+t) n is 1 and t=1 as only one element is taken) Queue = (2,2)
            // Taking one element from max heap  = 2 2 Time = 2 and adding the value in queue = (1,3) (n=1 and t = 2)
            // Time is 2 so can add the element from queue. When the count of the element becomes 0 then we donot add in the queue.

            if (n == 0) return tasks.length;
            int[] arr = new int[26]; // Storing the frequency.
            for (char ch : tasks)
                arr[ch - 'A']++;

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {// Total 26 char array when count >0 then add in heap.
                    pq.add(arr[i]);
                }
            }
            int time = 0;
            Queue<Pair> q = new LinkedList<>();
            while (pq.size() != 0 || q.size() != 0) {
                time++;
                if (pq.size() != 0) {
                    int top = pq.poll();
                    if (top > 1) q.add(new Pair(top - 1, n + time));
                }
                if (q.size() != 0 && q.peek().second == time) {
                    // If it is not empty and the top element time is matched with the time and we can use the element then only add in heap.
                    pq.add(q.poll().first);
                }
            }
            return time;
        }
    }
}
