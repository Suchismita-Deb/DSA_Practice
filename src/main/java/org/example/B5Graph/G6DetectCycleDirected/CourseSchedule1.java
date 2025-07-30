package org.example.B5Graph.G6DetectCycleDirected;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule1 {
    // Cycle Detection using DFS
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // [0,1] means to take course 0 you need to first take course 1.
        // Course 1 is the prerequisite.
        for (int e[] : prerequisites) {
            adj.get(e[1]).add(e[0]);
        }

        int vis[] = new int[n];
        boolean ans = false;
        for (int i = 0; i < n; i++) {
            ans |= dfs(adj, vis, i);
        }
        return !ans;
    }

    boolean dfs(List<List<Integer>> adj, int vis[], int i) {
        if (vis[i] == 2) {
            return false;
        }
        if (vis[i] == 1) {
            return true;
        }
        vis[i] = 1; // when doing the node then we mark as 1.
        boolean cycle = false;
        for (int nb : adj.get(i)) {
            cycle |= dfs(adj, vis, nb);
        }
        vis[i] = 2; // after completing the node then will make it as 2.
        return cycle;
    }

}
