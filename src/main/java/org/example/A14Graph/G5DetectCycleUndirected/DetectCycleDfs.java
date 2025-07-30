package org.example.A14Graph.G5DetectCycleUndirected;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleDfs {
    class Solution {
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            int[] vis = new int[V];
            Arrays.fill(vis, -1);
            for (int i = 0; i < V; i++) {
                if (vis[i] == -1) {
                    if (dfs(adj, i, -1, vis)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int par, int[] vis) {
            vis[node] = 1;
            for (int nb : adj.get(node)) {
                if (vis[nb] == -1) {
                    if (dfs(adj, nb, node, vis)) return true;
                } else {
                    // The nb is the par of the node. so nb==node meaning same node nb==parent meaning parent of the node.
                    // 1 -> {2,3,5}
                    // 2 -> {1}
                    // Here 2 is connected to 1 but it is not cycle. From the neighbour node will get 1 but 1 is par so no cycle,
                    if (vis[nb] != -1 && nb != par) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
