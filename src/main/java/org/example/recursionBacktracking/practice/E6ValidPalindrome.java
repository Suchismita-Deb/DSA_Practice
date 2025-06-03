package org.example.recursionBacktracking.practice;

public class E6ValidPalindrome {
    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(validPalin(0, str));
    }

    private static boolean validPalin(int i, String str) {
        if(i>=(str.length()/2)){
            return true;
        }
        if(str.charAt(i)!=str.charAt(str.length()-i-1)){
            return false;
        }
        return validPalin(i+1,str);
    }
}
