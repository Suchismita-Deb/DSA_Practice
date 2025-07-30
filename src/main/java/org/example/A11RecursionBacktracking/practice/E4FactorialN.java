package org.example.A11RecursionBacktracking.practice;

public class E4FactorialN {
    public static void main(String[] args) {
        int n=5;
        System.out.println(factN(n));
    }

    private static int factN(int n) {
        if(n==0){
            return 1;
        }
        return n * factN(n-1);
    }
}
