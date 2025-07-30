package org.example.B2RecursionBacktracking.practice;

public class E2PrintNTo1 {
    public static void main(String[] args) {
        int n=5;
        printRevNum(n);
    }

    private static void printRevNum(int n) {
        if(n==0){
            return;
        }
        System.out.println(n);
        printRevNum(n-1);
    }
}
