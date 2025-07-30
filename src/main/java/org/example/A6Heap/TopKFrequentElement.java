package org.example.A6Heap;

// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

public class TopKFrequentElement {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> mp = new HashMap<>();
            for (int n : nums) {
                mp.put(n, mp.getOrDefault(n, 0) + 1);
            }
            PriorityQueue<Map.Entry<Integer, Integer>> maph = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                maph.add(entry);
            }

            List<Integer> res = new ArrayList<>();
            while (res.size() < k) {
                Map.Entry<Integer, Integer> entry = maph.poll();
                res.add(entry.getKey());
            }


            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = res.get(i);
            }
            return result;
        }
    }
}
