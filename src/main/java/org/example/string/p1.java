package org.example.string;

public class p1 {
    public static void main(String[] args) {
        var a = 15;
        var b = 10;
        A1.addToInt(a,b);
        System.out.println(a);
    }

    public class A1 {
        public static void addToInt(int x, int amountToAdd) {
            x = x + amountToAdd;
        }
    }
}
