package org.example.tips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListImp {
    public static void main(String[] args) {
        // Getting random number.
        System.out.println((int)(Math.random()*10)); // This will generate the random number between 10.
        // Math.random generates decimal number.
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);arr.add(20);arr.add(30);
        System.out.println((int)(Math.random()*arr.size())); // This will give the random index. Then print the element.
        Collections.shuffle(arr);
        System.out.println(arr);// This will give in any order then we can get the first element.
    }
}
