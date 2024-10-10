package org.example.tips;

import java.util.Arrays;
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



        // b=a will copy the reference and not the element.
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        System.out.println("t"+t);

    }
}
