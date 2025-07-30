package org.example.A14Graph.G5DetectCycleUndirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleBfs {
    // If vis is true and it is not the parent of the node then there is a cycle.
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[] = new int[adj.size()];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (bfs(adj, vis, i))
                    return true;
            }
        }
        return false;
    }

    boolean bfs(ArrayList<ArrayList<Integer>> adj, int vis[], int src) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        vis[src] = 1;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();
            for (int nb : adj.get(node)) {
                if (nb != par && vis[nb] == 1) {
                    return true;
                } else if (vis[nb] == 0) {
                    q.add(new Pair(nb, node));
                    vis[nb] = 1;
                }
            }
        }
        return false;
    }
}
