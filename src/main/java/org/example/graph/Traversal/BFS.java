package org.example.graph.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        bfsAdjList();
        // bfsAdjMatrix();
    }

    private static void bfsAdjMatrix() {
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
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[v + 1];

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer a = q.poll();
            res.add(a);
//            for(int it:arr[a]){
//                // it = arr[2] = [0,1,0,1];
//                if(vis[it]==false && arr[a][it]==1){
//                    q.add(it);
//                    vis[it]=false;
//                }
//            }

            for (int i = 0; i <= v; i++) {
                if (arr[a][i] == 1 && vis[i] == false) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println(res);
    }

    private static void bfsAdjList() {
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

        System.out.println(adj); // [[1], [2, 0], [1, 3], [2]]

        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[v + 1];

        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            Integer a = q.poll();

            arr.add(a);
            for (Integer it : adj.get(a)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        System.out.println(arr);
    }
}

