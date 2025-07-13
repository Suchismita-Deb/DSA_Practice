package org.example.tips;

public class StringImp {
    public static void main(String[] args) {

        // StringBuilder to the String.
        StringBuilder str = new StringBuilder("Text");
        System.out.println(str.toString());

        // String equal.
        String st = "Hello";
        System.out.println(st.equals("Hello"));

        String code = "Hello89";
        boolean isAlphaNumeric = code != null && !code.isEmpty()
                && code.chars().allMatch(c -> Character.isLetterOrDigit(c));
        // Only to do on character. Here to do in string.

        //  Check if string contains only vowels.
        String input = "aeiouAEIOU";
        boolean isOnlyVowels = input.chars()
                .allMatch(c -> "aeiouAEIOU".indexOf(c) >= 0);
    }
}
