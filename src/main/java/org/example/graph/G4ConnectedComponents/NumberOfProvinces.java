package org.example.graph.G4ConnectedComponents;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        // isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        int n = isConnected.length;
        boolean vis[] = new boolean[n + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, isConnected, vis);
            }
        }
        return count;
    }

    public static void dfs(int i, int[][] isConnected, boolean[] vis) {
        vis[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && vis[j] == false) {
                dfs(j, isConnected, vis);
            }
        }
    }
}

