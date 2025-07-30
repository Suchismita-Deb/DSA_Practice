package org.example.A14Graph.G3DfsBfs;

import java.util.Arrays;

// https://leetcode.com/problems/is-graph-bipartite/

// Not only checking of cycle. As only odd cycle is not bipartite.
public class IsGraphBipartite {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int vis[] = new int[graph.length];
            Arrays.fill(vis, -1);
            // Initially filled with -1. Then the adj will be filled with 1 and 0.
            // Odd cycle will not be a valid case.
            for (int i = 0; i < graph.length; i++) {
                if (vis[i] == -1)
                    if (dfs(graph, vis, i, 0) == false)
                        return false;
            }
            return true;
        }

        boolean dfs(int graph[][], int vis[], int node, int col) {
            // Already visited.
            if (vis[node] != -1) {
                return vis[node]==col; // If visited then it has the different color.
            }
            vis[node] = col;
            for (int nb : graph[node]) {
                if (vis[nb] == -1) {
                    if (dfs(graph, vis, nb, 1 - col) == false)
                        return false;
                } else if (vis[nb] == vis[node]) // color of the node is same.
                    return false;
            }
            return true;
        }
    }

}
