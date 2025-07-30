package org.example.A3Greedy;

// https://leetcode.com/problems/hand-of-straights/description/

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
// https://leetcode.com/problems/hand-of-straights/
public class HandInStraight {
    class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            // The order does not matter.
            // [1,2,3,6,2,3,4,7,8] W = 3 Then also the value will be same.
            // [1,2,3,7,2,3,4,6,8] W = 3. Output - [[1,2,3],[2,3,4],[6,7,8]]

            // Can store the count of the element.
            // 1 2 3 4 6 7 8
            // 1 2 2 1 1 1 1
            // Then we can proceed like for 1 how many group can be made with the starting value as 1. The frequency of 1 is 1. So we can make 1 2 3 and the count is reduced by 1 of the element 1 2 3.
            // Now the frequency value.
            // 1 2 3 4 6 7 8
            // 0 1 1 1 1 1 1
            // Then from the remaining element will get the min value so we need to store in min heap. Next element is 2. See if any W size element value present like 2 3 4 and count is reduced. We can also sort the array and add in treemap where the key are sorted and get the element from the firstKey and check for the k group starting from the element.
            if (hand.length % groupSize != 0) return false;
            TreeMap<Integer, Integer> mp = new TreeMap<>();
            for (int i : hand) {
                mp.put(i, mp.getOrDefault(i, 0) + 1);
            }
            List<Integer> ls = new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();
            while (mp.size() != 0) {
                int first = mp.firstKey();
                for (int i = first; i < first + groupSize; i++) {
                    if (!mp.containsKey(i)) return false;
                    ls.add(i);
                    int val = mp.get(i);
                    mp.put(i, val - 1);
                    if (mp.get(i) == 0) {
                        mp.remove(i);
                    }
                }
                list.add(new ArrayList(ls));
                ls = new ArrayList<>();
            }
            System.out.println(list); // To print the list.
            return true;
        }
    }
}
