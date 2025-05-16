package org.example.tips;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayImp {
    public static void main(String[] args) {
        // Custom input array
        int a[] = { 1, 8, 3 };

        // Create an array b[] of same size as a[]
        // Copy elements of a[] to b[]
        int b[] = Arrays.copyOf(a, 3);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        a[1] = 98;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        // Changing of a will not change b.


        // b=a will copy the reference and not the element.
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        System.out.println("t"+t);
        scn.close();
        // Sort the first element in List<int[]> array.
        List<int[]> intervals = new ArrayList<>(Arrays.asList(
                new int[]{1, 3},
                new int[]{8, 9},
                new int[]{6, 9}
        ));

        // Adding element.
        List<int[]> interval = new ArrayList<>();
        intervals.add(new int[]{1, 3});
        intervals.add(new int[]{8, 9});
        intervals.add(new int[]{6, 9});


        // Sort the interval based on the first value.
        intervals.sort((aVal, bVal) -> Integer.compare(aVal[0], bVal[0]));
        System.out.println(intervals);



        // ArrayList<int[]> convert to int[][].
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(new int[]{1, 3});
        int[][] array = ans.toArray(new int[ans.size()][]);

    }
}
