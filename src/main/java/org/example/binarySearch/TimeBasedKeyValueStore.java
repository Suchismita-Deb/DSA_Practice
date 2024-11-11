package org.example.binarySearch;

// https://leetcode.com/problems/time-based-key-value-store/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
//
//Implement the TimeMap class:
//
//TimeMap() Initializes the object of the data structure.
//void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
//String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
//
//
//Example 1:
//
//Input
//["TimeMap", "set", "get", "get", "set", "get", "get"]
//[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
//Output
//[null, null, "bar", "bar", null, "bar2", "bar2"]
public class TimeBasedKeyValueStore {
    class TimeMap {

        // In the set block the value will be always gien in increasing order so the time will be sorted.
        // "foo" - [bar,1],[bar,4]
        // One key will have multiple value and each value will have the time and String.
        // If the get time like 3 then will get the time smaller than the 3.
        HashMap<String,ArrayList<Pair<String,Integer>>> mp;

        public TimeMap() {
            mp = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(mp.containsKey(key)){
                mp.get(key).add(new Pair(value,timestamp));
            }
            else{
                mp.put(key,new ArrayList<>());
                mp.get(key).add(new Pair(value,timestamp));
            }
        }

        public String get(String key, int timestamp) {
            if(!mp.containsKey(key)) return "";
            ArrayList<Pair<String, Integer>> list = mp.get(key);
            return search(list,timestamp);
        }
        String search(List<Pair<String,Integer>> list, int timestamp){
            int start = 0;
            int end = list.size()-1;
            String res ="";
            while(start<=end){
                int mid = (start+end)/2;
                int time = list.get(mid).i;
                if(time<=timestamp){
                    res = list.get(mid).str;// Closest value seen now. Will update the result. In binary search when we get the possible value we update like the min and and the max value in rotated array.
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            return res;
        }
    }
    public class Pair<T, T1> {
        String str;
        Integer i;
        Pair(String str, int i){
            this.i = i;
            this.str = str;
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
