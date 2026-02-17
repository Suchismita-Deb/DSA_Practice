package org.example.CSES.IntroductoryProblem.NumberSpiral;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
//        long t = scn.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());



        while (t-- > 0) {
//            long row = Long.parseLong(st.nextToken());
//            long col = Long.parseLong(st.nextToken());
            String line = br.readLine();
//            if (line == null || line.isEmpty()) break;

            String[] parts = line.split(" ");
            long row = Long.parseLong(parts[0]);
            long col = Long.parseLong(parts[1]);
            long max = Math.max(row, col);
            long val = (max * max) - (max - 1);
            if (row == col) {
                System.out.println(val);
                continue;
            }
            if (max % 2 == 0) {
                if (max == row) val += (max - col);
                else val -= (max - row);
            } else {
                if (max == row) val -= (max - col);
                else val += (max - row);
            }
            System.out.println(val);
        }
    }
}
