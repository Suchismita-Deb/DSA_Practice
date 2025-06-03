package org.example.recursionBacktracking.practice;

public class E7FibonacciNum {
    public static void main(String[] args) {
        int n = 5;
        // 0 1 1 2 3 5 8
        System.out.println(fibNum(n));
    }

    private static int fibNum(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return fibNum(n-1) + fibNum(n-2);
    }
}
