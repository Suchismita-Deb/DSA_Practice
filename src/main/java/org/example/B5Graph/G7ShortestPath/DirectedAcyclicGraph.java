package org.example.B5Graph.G7ShortestPath;

import java.util.ArrayList;
import java.util.Stack;

// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/0
// Given a Weighted Directed Acyclic Graph and a source vertex in the graph, find the shortest paths from given source to all other vertices.
// For a general weighted graph, single source shortest distances in O(VE) time using Bellman–Ford Algorithm.
// For a graph with no negative weights, we can do better and calculate single source shortest distances in O(E + VLogV) time using Dijkstra’s algorithm.
// Can we do even better for Directed Acyclic Graph (DAG)? We can calculate single source shortest distances in O(V+E) time for DAGs using Topological Sorting.
public class DirectedAcyclicGraph {
    //User function Template for Java
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Solution {
        public int[] shortestPath(int N, int M, int[][] edges) {

            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < N; i++) { // adding empty arraylist
                adj.add(new ArrayList<Pair>());
            }

            for (int i = 0; i < M; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];
                adj.get(u).add(new Pair(v, wt));
            }

            int vis[] = new int[N];
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < N; i++) {
                if (vis[i] == 0) {
                    topoSort(adj, i, vis, st);
                }
            }

            int dist[] = new int[N];
            for (int i = 0; i < N; i++) {
                dist[i] = (int) (1e9);
            }

            dist[0] = 0;//Here it is for the 0 node. It can be any src.

            while (!st.isEmpty()) {
                int node = st.peek();
                st.pop();

                for (Pair nb : adj.get(node)) {
                    int v = nb.first;
                    int wt = nb.second;

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (dist[i] == (int) (1e9)) {
                    dist[i] = -1; // If not reachable then -1.
                }
            }

            return dist;
        }

        void topoSort(ArrayList<ArrayList<Pair>> adj, int i, int vis[], Stack<Integer> st) {
            vis[i] = 1;
            for (Pair nb : adj.get(i)) {
                int node = nb.first;
                if (vis[node] == 0)
                    topoSort(adj, node, vis, st);
            }
            st.add(i);
        }
    }
}
