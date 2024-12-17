package org.example.string;

public class p1 {
    public static void main(String[] args) {
        Integer num = 10;
        modify(num);
        System.out.println(System.identityHashCode(num));
        num = 100;
        System.out.println(System.identityHashCode(num));
        System.out.println(num);
    }

    public static void modify(Integer num) {
        num = 200;
    }
}
