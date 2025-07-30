package org.example.B5Graph.G10DSU.DsuPractice;

public class NumberOfProvince {
    class Solution {
        // Return the number of connected components.
        public int findCircleNum(int[][] isConnected) {
            int result = 0;
            int n = isConnected.length;
            DSU dsu = new DSU(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isConnected[i][j] == 1) dsu.union(i, j);
                }
            }
            return dsu.getComponents();
        }

        class DSU {
            private final int[] parent;
            private final int[] rank;
            private int numberOfComponents;

            public DSU(int n) {
                parent = new int[n];
                rank = new int[n];
                numberOfComponents = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    rank[i] = 1;
                }
            }

            private int find(int v) {
                if (parent[v] == v) return v;
                return parent[v] = find(parent[v]);
            }

            public boolean union(int u, int v) {
                int par_u = find(u);
                int par_v = find(v);
                if (par_u == par_v) return false;
                if (rank[u] < rank[v]) {
                    parent[par_u] = par_v;
                } else if (rank[v] < rank[u]) {
                    parent[par_v] = par_u;
                } else {
                    parent[par_v] = par_u;
                    rank[par_u]++;
                }
                numberOfComponents--;
                return true;
            }

            public int getComponents() {
                return numberOfComponents;
            }
        }
    }
}
