package org.example.graph.DfsBfs;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/redundant-connection/description/
public class RedundantConnection {
    class DfsSolution {
        public int[] findRedundantConnection(int[][] edges) {
            // Tree is defined as undirected graph with no cycle.
            // There is a graph with n nodes from 1 to n. There is an edge added that is not making the graph a tree.
            // Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
            // Input = edges = [[1,2],[1,3],[2,3]]
            // Output = [2,3]
            // 2 is already connected with 3 when we add this one node later it is creating the loop.

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= edges.length; i++) {
                adj.add(new ArrayList<>());
            }
            int[] vis = new int[edges.length + 1];
            // Multiple DFS call. O(N^2).

            // Construct the graph by adding the edges one after the other and for each edge will do dfs and see if cycle exists. If cycel is detected then we know that for the last edge the cycle is formed so returned the last edge.
            for (int i = 0; i <= edges.length; i++) {
                Arrays.fill(vis, -1); // Reset the value of the vis array.
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
                // Adding the edges and checking the dfs if cycle is true. When one edge gives true for the cycle then return the edge as the last edge created the cycle.
                if (dfs(adj, vis, edges[i][0], -1)) {
                    // Return true meaning cycle exists.
                    int[] arr = {edges[i][0], edges[i][1]};
                    return arr;
                }
            }
            return new int[2]; // Empty array as no cycle.
        }

        boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node, int par) {
            if (vis[node] == 1) // Already reached and cycle detected.
                return true;
            vis[node] = 1;
            for (int nb : adj.get(node)) {
                if (par != nb && dfs(adj, vis, nb, node))
                    // Undirected so the neighbour node can be the par need to check in the condition.
                    return true;
            }
            return false;
        }
    }

    // Another approach by using DSU when we try doing union and find that the parent is already same for the vertex then it is already connected and it is the redundant connection.

    class DsuSolution {
        class DSU {
            int[] rank, parent; // Making the rank and the union.

            DSU(int n) {
                rank = new int[n + 1];
                parent = new int[n + 1]; // nodes from 1 to n.
                for (int i = 0; i <= n; i++) {
                    parent[i] = i;
                }
            }

            int find(int node) {
                if (parent[node] == node) return node;
                return parent[node] = find(parent[node]);
                // parent = [1,1,1] parent of 2 and 3 is 1.
                // find(3) then we got the value as 1 and then find(1) and update the value as next time it will be easy.
            }

            boolean union(int u, int v) {
                int U = find(u); // Getting the parent of the node.
                int V = find(v);
                if (U == V) return false; // Already connected.
                if (rank[U] < rank[V]) { // Rank is the max height and if the rank of V is more then connecting small height rank will not change the rank.
                    parent[U] = V;
                } else if (rank[V] < rank[U]) {
                    parent[V] = U;
                } else {
                    parent[U] = V; // Equal and connecting with V and the rank is increased.
                    rank[V]++;
                }
                return true;
            }
        }

        class Solution {
            public int[] findRedundantConnection(int[][] edges) {
                // Using Union find edges = [[1,2],[1,3],[2,3]]. Here we are connecting 1 and 2.
                // par = [1,1,3].
                // Union 1 and 3 so par = [1,1,1]. Now when we got the edge [2,3] then it means will do the union with par and par of both of them are same. So returning the edge.
                int n = edges.length;
                DSU dsu = new DSU(n);
                for (int[] edge : edges)
                    if (!dsu.union(edge[0], edge[1])) return edge;
                return new int[2];

            }
        }
    }
}
