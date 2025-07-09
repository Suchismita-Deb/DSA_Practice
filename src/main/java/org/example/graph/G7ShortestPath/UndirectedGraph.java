package org.example.graph.G7ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

public class UndirectedGraph {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // BFS Storing pair of vertex and dist of one unit.
        // Given as matrix. Will convert to the list.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // This is important to add value to the adj.
        for (int i = 0; i < n; i++) {
            // This is for the nodes.
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            // This is for the edges.
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        int dist[] = new int[n];
        Arrays.fill(dist,(int) (1e9));
        dist[src] = 0;
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int wt = q.peek().second;
            q.remove();
            for (int nb : adj.get(node)) {
                // Dist is minimum then only add in the queue.
                if (wt + 1 < dist[nb]) {
                    dist[nb] = wt + 1;
                    q.add(new Pair(nb, dist[nb]));
                }
            }
        }
        // if unreachable then return -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) (1e9)) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
