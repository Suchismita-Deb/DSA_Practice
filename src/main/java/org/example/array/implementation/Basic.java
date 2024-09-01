package org.example.array.implementation;

import java.util.*;

public class Basic {
    // Contains Duplicate.
    // If any element appears twice return true. Make a set and add elements and if set contains return true.

    // Valid Anagrams.
    // When the char in a word are same and can be rearranged.
    // anagram nagaram.
    // Making map of char for the first word and increase the count. For the second word reduce the count of teh char from the map. If map contains any value then they are not anagram.
    class ValidAnagram {
        public boolean isAnagram(String s, String t) {
            Map<Character,Integer> mp = new HashMap<>();
            for(int i = 0;i<s.length();i++){
                char ch= s.charAt(i);
                mp.put(ch,mp.getOrDefault(ch,0)+1);
            }
            for(int i = 0;i<t.length();i++){
                char ch= t.charAt(i);
                mp.put(ch,mp.getOrDefault(ch,0)-1);
            }
            for (Map.Entry<Character,Integer> entry : mp.entrySet()){
                if(entry.getValue()!=0){
                    return false;
                }
            }
            return true;
        }
    }

    // 2 sum.
    // One value and in map check for the remaining value.
    class TwoSum {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> mp = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                mp.put(nums[i],i);
            }
            int a = 0;
            int b = 0;
            for(int i=0;i<nums.length;i++){
                a = i;
                if(mp.containsKey(target-nums[i])){
                    b = mp.get(target-nums[i]);
                    if(a!=b)
                        break;
                }
            }
            int arr[] = {a,b};
            return arr;
        }
    }

    // Group Anagram.
    // Given a string of an array. Group all the anagram in a list and return the List of List.
    // Making HashMap of HashMap and ArrayList.
    // For individual string create a map and check if it is present in the map.
    class GroupAnagram {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<HashMap<Character,Integer>, ArrayList<String>> map = new HashMap<>();

            for(String str:strs){
                HashMap<Character,Integer> mp = new HashMap<>();
                for(int i=0;i<str.length();i++) {
                    // Making the map.
                    char ch = str.charAt(i);
                    mp.put(ch, mp.getOrDefault(ch, 0) + 1);
                }
                if(map.containsKey(mp) == false){
                    // If not exists then make a new array and add.
                    ArrayList<String> arr = new ArrayList<>();
                    arr.add(str);
                    map.put(mp,arr);
                }
                else{
                    // If exists then add to the array.
                    ArrayList<String> arr = map.get(mp);
                    arr.add(str);
                }
            }
            List<List<String>> res = new ArrayList<>();
            for(ArrayList<String> val:map.values()){
                res.add(val);
            }
            return res;
        }
    }

    // Top K most Frequent Element.
    // Given an array find the k most frequent element.
    // MaxHeap of frequency of the element.
    class TopKFrequentElement {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> mp = new HashMap<>();
            for(int n:nums){
                mp.put(n,mp.getOrDefault(n,0)+1);
            }
            PriorityQueue<Map.Entry<Integer,Integer>> maph = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
            for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
                maph.add(entry);
            }

            List<Integer> res = new ArrayList<>();
            while(res.size()<k){
                Map.Entry<Integer, Integer> entry = maph.poll();
                res.add(entry.getKey());
            }
            int result[] = new int[k];
            for(int i=0;i<k;i++){
                result[i] = res.get(i);
            }
            return result;
        }
    }

    // Product Of Array Except Self.
    // Prefix and Suffix Product and get the value form the prefix and suffix without the index.
    class ProductOfArrayExceptSelf {
        public int[] productExceptSelf(int[] nums) {
            int prefixProduct[] = new int[nums.length];
            int suffixProduct[] = new int[nums.length];
            prefixProduct[0] = nums[0];
            for(int i=1;i<nums.length;i++){
                prefixProduct[i] = nums[i]*prefixProduct[i-1];
            }
            suffixProduct[nums.length-1] = nums[nums.length-1];
            for(int i=nums.length-2;i>=0;i--){
                suffixProduct[i] = nums[i]*suffixProduct[i+1];
            }
            int res[] = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                if(i==0){
                    res[i] = suffixProduct[i+1];
                }
                else if(i==nums.length-1){
                    res[i] = prefixProduct[i-1];
                }
                else{
                    res[i] = prefixProduct[i-1]*suffixProduct[i+1];
                }
            }
            return res;
        }
    }

    // Longest Consequtive Sequence.
    class LongestConsequtiveSequence {
        public int longestConsecutive(int[] nums) {
            if(nums.length==0) return 0;
            // Draw the sequence of the number.
            // In the number line will check if the prefix number is present. Efficient way
            // is to check with set. When we have to check if exists or not then go with set as it is fast.

            // 100 4 200 1 3 2
            // 1234 100 200
            // No prefix of 1 as 0 is not present, no prefix of 100 as 99 is not present.
            // Will make a sequence from (100 -> ), (200 -> ) then (1 -> 2-> 3-> 4)
            // With set the starting of the sequence.
            // nums[] check if 4 has any prefix yes, then check for 3 and yes then check for 2 and then check for 1.

            HashSet<Integer> hset = new HashSet<>();
            for(int i=0;i<nums.length;i++){
                hset.add(nums[i]);
            }
            int longest = 1;
            for(int i=0;i<nums.length;i++){
                int count=0;
                // checking if num[i] is the start of the sequence
                if(!hset.contains(nums[i]-1)){
                    int val = nums[i];
                    while(hset.contains(val)){// continue the check for the next element.
                        val++;
                        count++;
                    }
                }
                longest = Math.max(longest,count);
            }
            return longest;

        }
    }
}
