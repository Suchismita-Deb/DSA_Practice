package org.example.tips;

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


    }
}
