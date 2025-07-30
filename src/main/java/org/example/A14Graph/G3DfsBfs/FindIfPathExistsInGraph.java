package org.example.A14Graph.G3DfsBfs;

import java.util.ArrayList;

// https://leetcode.com/problems/find-if-path-exists-in-graph/
// Return true if there exists any path from source to destination.
public class FindIfPathExistsInGraph {
    class Solution {

        boolean ans;
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            // Generally dfs is best to check if exists type of problem.
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());
            for (int i = 0; i < edges.length; i++) {
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
            }
            int vis[] = new int[n];
            return dfs(adj, source, destination, vis);
        }

        boolean dfs(ArrayList<ArrayList<Integer>> adj, int source, int destination, int vis[]) {
            if (source == destination)
                return true;
            vis[source] = 1;
            for (int nb : adj.get(source)) {
                if (vis[nb] == 0) {
                    ans|=dfs(adj, nb, destination, vis);
                }
            }
            // Any one path is true then return true. So doing or operator.
            return ans;
        }
    }
}
