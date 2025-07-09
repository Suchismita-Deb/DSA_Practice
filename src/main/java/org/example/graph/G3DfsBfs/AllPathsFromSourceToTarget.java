package org.example.graph.G3DfsBfs;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/all-paths-from-source-to-target/description/

// [[1,2],[3],[3],[]]
// Output = [[0,1,3],[0,2,3]]
// Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
public class AllPathsFromSourceToTarget {
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            // Input graph = [[1,2],[3],[3],[]]
            // 0th node connected to 1,2.
            // Already in adj list form.
            int destination = graph.length - 1;
            // DAG no cycle so no need of visited array.
            dfs(graph, 0, destination);
            return res;
        }

        void dfs(int[][] graph, int source, int destination) {
            ls.add(source); // Adding
            if (source == destination) {
                res.add(new ArrayList<>(ls));
                return;
            }
            for (int nb : graph[source]) {
                dfs(graph, nb, destination);
                ls.remove(ls.size() - 1);
            }
        }
    }
}
