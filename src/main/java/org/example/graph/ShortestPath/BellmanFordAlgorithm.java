package org.example.graph.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

/*
Single Source Shortest Path Algorithm.
Directed Weighted Graph.
Works in negative weight graph.
 */

public class BellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e8));
        dist[S] = 0;
        // V X E
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != (int) (1e8) && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Checking if there is negative cycle. Nth time to check negative cycle.
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != (int) (1e8) && dist[u] + wt < dist[v]) {
                int[] temp = new int[1];
                temp[0] = -1;// returning -1 in array as the return type is array. If the value reduce then it indicates that there is a cycle.
                return temp;
            }
        }
        return dist;
    }
}
