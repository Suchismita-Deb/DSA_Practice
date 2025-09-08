package org.example.B5Graph.G2Traversal;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        AdjList();
        // AdjMatrix();
    }

    private static void AdjList() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 3;
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(1).add(0);
        adj.get(0).add(1);

        for (int i = 0; i <= v; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j));
            }
            System.out.println();
        }

        ArrayList<Integer> ls = new ArrayList<>();
        boolean vis[] = new boolean[v + 1];
        vis[0] = true;
        dfsAdjList(0, vis, adj, ls);
        System.out.println(ls);
    }


    public static void dfsAdjList(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);

//        System.out.println(node);
        for (Integer it : adj.get(node)) {
            if (vis[it] == false)
                dfsAdjList(it, vis, adj, ls);
        }
    }

    private static void AdjMatrix() {
        int v = 3;
        int[][] arr = new int[v + 1][v + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
            }
        }
        arr[0][1] = 1;
        arr[1][0] = 1;

        arr[1][2] = 1;
        arr[2][1] = 1;

        arr[2][3] = 1;
        arr[3][2] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        ArrayList<Integer> ls = new ArrayList<>();
        boolean vis[] = new boolean[v + 1];
        vis[0] = true;
        dfsAdjMatrix(0, vis, arr, ls);
        System.out.println(ls);
    }

    private static void dfsAdjMatrix(int node, boolean[] vis, int[][] arr, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);
        for (int i = 0; i < arr.length; i++) {
            if (vis[i] == false) {
                vis[i] = true;
                dfsAdjMatrix(i, vis, arr, ls);
            }
        }
    }


}
