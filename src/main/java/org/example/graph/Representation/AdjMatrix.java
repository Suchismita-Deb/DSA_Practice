package org.example.graph.Representation;

import java.util.ArrayList;
import java.util.Arrays;

public class AdjMatrix {
    public static void main(String[] args) {
        int N = 6;
        int matrix[][] = new int[N][N];

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 3)));
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(3, 2)));
        edges.add(new ArrayList<>(Arrays.asList(1, 4)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4)));

        for (int i = 0; i < edges.size(); i++) {
            matrix[edges.get(i).get(0)][edges.get(i).get(1)] = 1;
            matrix[edges.get(i).get(1)][edges.get(i).get(0)] = 1;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
