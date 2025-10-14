package org.example.tips;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class MapImp {
    public static void main(String[] args) {
        Map<Integer,Integer> mp = new HashMap<>();
        int arr[] = {1,2,2,2,2,3,8,4,4,8,5,5,8,4};
        for(int i:arr){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("LinkedHashMap maintain insertion order.");
        System.out.println("TreeMap sort the order by key.");

        // TreeMap implements NavigableMap, which maintains sorted order of keys. That’s why you get access to methods like firstKey(), lastKey(), higherKey(), lowerKey(). Not working for duplicate value as it will update the the key with new value.
        // higherKey(K)	Returns the least key strictly greater than the given key K
        // lowerKey(K)	Returns the greatest key strictly less than the given key K
        // treeMap mp = [(20,"Twenty"),(10,"Ten"),(30,"Thirty")]
        // System.out.println("Lower than 30: " + map.lowerKey(30));   // 20
        // System.out.println("Higher than 25: " + map.higherKey(25)); // 30
        // System.out.println("First Key: " + mp.firstKey()); // 20
        // System.out.println("Last Key: " + mp.lastKey());   // 30
        // HashMap has no firstKey or lastKey.

        // Map of String and an ArrayList<>
        Map<String, ArrayList<String>> mpArrayList = new HashMap<>();
        // Adding element in the mpArrayList.
        mpArrayList.computeIfAbsent("code", val -> new ArrayList<>()).add("Java");
        mpArrayList.computeIfAbsent("code", val -> new ArrayList<>()).add("Python");
        // getOrDefault works when values are immutable (primitives) - Works because you always overwrite: mp.put(key, mp.getOrDefault(key, 0) + 1)
        // Map<String, ArrayList<String>> values are mutable objects and add to the value and not a new value.
        for (Map.Entry<String, ArrayList<String>> entry : mpArrayList.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            System.out.println(key + " -> " + value);
        }
        // Iterate on Map other way like keyset and foreach.

    }
}
