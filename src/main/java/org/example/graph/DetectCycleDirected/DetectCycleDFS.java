package org.example.graph.DetectCycleDirected;

import java.util.ArrayList;

public class DetectCycleDFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // making a vis and path vis. If the node is visited in the same path then only cycle. Toposort is another way.
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(adj, vis, pathVis, i) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[], int node) {
        vis[node] = 1;
        pathVis[node] = 1; // for the initial node.
        for (int nb : adj.get(node)) {
            if (pathVis[nb] == 1) {
                return true;
            } else if (vis[nb] == 0) {
                if (dfs(adj, vis, pathVis, nb) == true) {
                    return true;
                }
            }
        }
        pathVis[node] = 0;
        return false;
    }
}
