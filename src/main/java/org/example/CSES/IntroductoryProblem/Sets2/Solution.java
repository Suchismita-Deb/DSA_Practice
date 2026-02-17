package org.example.CSES.IntroductoryProblem.Sets2;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = n*(n+1)/2;
        if(sum%2!=0){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        long half = sum/2;
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        for(int i=(int)n; i>=1; i--){
            if(half>=i){
                set1.add(i);
                half -= i;
            }else{
                set2.add(i);
            }
        }
        System.out.println(set1.size());
        for(int num : set1){
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(set2.size());

        for(int num : set2){
            System.out.print(num + " ");
        }
    }
}

// Solution updated to resolve TLE using the StringBuilder.

class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = n * (n + 1) / 2;

        if (sum % 2 != 0) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        long half = sum / 2;
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        for (int i = (int) n; i >= 1; i--) {
            if (half >= i) {
                set1.add(i);
                half -= i;
            } else {
                set2.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set1.size()).append("\n");
        for (int num : set1) sb.append(num).append(" ");
        sb.append("\n").append(set2.size()).append("\n");
        for (int num : set2) sb.append(num).append(" ");

        System.out.println(sb.toString());
    }
}

// Solution updated with PrintWriter.
class Solution2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = n * (n + 1) / 2;

        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        if (sum % 2 != 0) {
            out.println("NO");
            out.close();
            return;
        }

        out.println("YES");
        long half = sum / 2;
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        for (int i = (int) n; i >= 1; i--) {
            if (half >= i) {
                set1.add(i);
                half -= i;
            } else {
                set2.add(i);
            }
        }

        out.println(set1.size());
        for (int num : set1) out.print(num + " ");
        out.println();
        out.println(set2.size());
        for (int num : set2) out.print(num + " ");

        out.close();
    }
}
// Solution updated with o(n/2)
class TwoSetsOptimized {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = (long) n * (n + 1) / 2;

        if (sum % 2 != 0) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        if (n % 4 == 0) {
            for (int i = 1; i <= n / 2; i++) {
                if (i % 2 == 1) {
                    set1.add(i);
                    set1.add(n - i + 1);
                } else {
                    set2.add(i);
                    set2.add(n - i + 1);
                }
            }
        } else if (n % 4 == 3) {
            // Base case
            set1.add(1);
            set1.add(2);
            set2.add(3);
            for (int i = 4; i <= n; i += 4) {
                set1.add(i);
                set1.add(i + 3);
                set2.add(i + 1);
                set2.add(i + 2);
            }
        }

        System.out.println(set1.size());
        for (int x : set1) System.out.print(x + " ");
        System.out.println();
        System.out.println(set2.size());
        for (int x : set2) System.out.print(x + " ");
        System.out.println();
    }
}
