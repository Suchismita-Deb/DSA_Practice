package org.example.B2RecursionBacktracking.practice;

public class E3SumN {
    public static void main(String[] args) {
        int n=5;
        System.out.println(sumFirstN(n));
    }

    private static int sumFirstN(int n) {
        if(n==0){
            return 0;
        }
        return n + sumFirstN(n-1);
    }
}
