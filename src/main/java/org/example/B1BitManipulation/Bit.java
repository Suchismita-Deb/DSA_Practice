package org.example.B1BitManipulation;

public class Bit {
    public static void main(String[] args) {
        int a = 0b101;
        int b = 0b111;
        System.out.println(a&b); // 5
        System.out.println(Integer.toBinaryString(a&b)); // 101
    }
}
