package org.example.B2RecursionBacktracking.practice;

import java.util.Arrays;

public class E5ReverseAnArray {

    public static void main(String[] args) {
        int arr[] = {1,3,4,5,6};
        int ar[] = {1,3,4,5,6};
        int n = arr.length;
        reverseArray(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
        fun(ar,0);
        System.out.println();
        funLast(ar,ar.length-1);
    }


    // Inplace.
    private static void reverseArray(int[] arr, int i, int j) {
        if(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            reverseArray(arr, i + 1, j - 1);
        }
    }
    // Starting index 0.
    private static void fun(int[] ar, int i){
        if(i==ar.length){
            return;
        }
        fun(ar,i+1);
        System.out.print(ar[i]);
    }
    // Starting index ar.length
    private static void funLast(int ar[], int i){
        if(i<0){
            return;
        }
        System.out.print(ar[i]);
        funLast(ar,i-1);
    }
}
