package org.example.Premium.Amazon.AmazonExplore.Design;

// https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.*;

/*
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.


Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]
*/
public class InsertDeleteGetRandom {
    class RandomizedSet {

        Map<Integer,Integer> mp;

        List<Integer> l;

        public RandomizedSet() {
            mp = new HashMap<>();
            l = new ArrayList<>();
        }

        public boolean insert(int val) {
            if(mp.containsKey(val)){
                return false;
            }
            // Map contains the value and the index.
            mp.put(val,mp.size());
            l.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(mp.containsKey(val)){
                int ind = mp.get(val);
                int lastVal = l.get(l.size()-1);
                if(val!=lastVal){
                    mp.put(l.get(l.size()-1),ind);
                    // Map contains the index so that get will be easy to get the index.
                    l.set(ind,l.get(l.size()-1));
                    // Make the element in the last then remove the last element.
                    // In case map contain one element then only remove meaning the val removed same as the last element in list.
                }
                l.remove(l.size()-1);
                mp.remove(val);
                // mp.put(l.get(l.size()-1),ind);
                return true;
            }
            return false;
        }

        public int getRandom() {
            Random rand = new Random();
            int i = rand.nextInt(l.size());
            return l.get(i);
        }
    }
}
