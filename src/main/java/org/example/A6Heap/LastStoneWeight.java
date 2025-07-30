package org.example.A6Heap;

// https://leetcode.com/problems/last-stone-weight/description/

import java.util.PriorityQueue;

public class LastStoneWeight {
    // On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y.
    // The result of this smash is:
    //If x == y, both stones are destroyed, and
    //If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
    //At the end of the game, there is at most one stone left.

    // Input: stones = [2,7,4,1,8,1]
    //Output: 1
    //Explanation:
    //We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
    //we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
    //we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
    //we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

    class Solution {
        public int lastStoneWeight(int[] stones) {
            // Always need the max element sorting always will not work. Use priority queue.
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
            for(int i:stones){
                pq.offer(i);
            }
            while(pq.size()>1){
                int max1 = pq.poll();
                int max2 = pq.poll();
                if(max1!=max2) {
                    pq.offer(max1-max2);
                }
            }
            return pq.size()==1?pq.peek():0;
        }
    }
}
