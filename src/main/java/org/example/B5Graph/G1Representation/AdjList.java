package org.example.B5Graph.G1Representation;

import java.util.ArrayList;

public class AdjList {
    public static void main(String[] args) {
        ArrayList<ArrayList> adj = new ArrayList<>();
        int v = 3;
        // Initializing with empty value.
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // Undirected graph.
        // 1--2
        adj.get(1).add(2);
        adj.get(2).add(1);
        // 2---3

        adj.get(2).add(3);
        adj.get(3).add(2);
        // 1---3
        adj.get(1).add(3);
        adj.get(3).add(1);

        for (int i = 1; i <= v; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
