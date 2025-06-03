package org.example.recursionBacktracking.practice;

public class E1Print1ToN {
    public static void main(String[] args) {
        int n=5;
        printNum(1, n);
        System.out.println();
        printNum(n);
    }

    private static void printNum(int n) {
        if(n==0){
            return;
        }
        printNum(n-1); // One parameter. It will go to the start then print the number.
        System.out.println(n);
    }

    private static void printNum(int i, int n) {
        if(i>n){
            return;
        }
        System.out.println(i);
        printNum(i+1,n);
    }
}
