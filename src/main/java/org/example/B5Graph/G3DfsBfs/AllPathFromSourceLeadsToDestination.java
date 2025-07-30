package org.example.B5Graph.G3DfsBfs;

import java.util.ArrayList;

/* Determine whether all paths starting from source eventually, end at destination */
// https://leetcode.com/problems/all-paths-from-source-lead-to-destination/description/

public class AllPathFromSourceLeadsToDestination {
    class Solution {
        public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>()); // For the nodes adding with the empty value.
            }
            for (int i = 0; i < edges.length; i++) {
                adj.get(edges[i][0]).add(edges[i][1]);
            }
            // Boolean state array with 'B' as we need to know if we have seen the node before.
            return dfs(adj, source, destination, new Boolean[n]);
        }

        boolean dfs(ArrayList<ArrayList<Integer>> adj, int source, int destination, Boolean[] state) {
            if (state[source] != null) {
                // If the source is already visited then will return the value.
                // 1 -> {2,3}
                // 2 -> {4}
                // 3 -> {4}
                // 4 -> {5}
                // 5 -> {}
                // Here when we reached 4 though one node then we make the node 4 as true. If we reach 4 further will simply return true.
                return state[source];
            }
            if (adj.get(source).size() == 0) {
                // 1->{2,3}
                // 2->{}
                // 3->{}
                // 1 is reaching to 2,3 and 2 is not going to 3 so if one node has no neighbouring node then it should be destination.
                return source == destination;
            }
            state[source] = false; // Before starting will set to false. This will help to detect the cycle and parallel edges.
            for (int nb : adj.get(source)) {
                if (!dfs(adj, nb, destination, state)) {
                    return false;
                }
            }
            // We are maintaining the state for the checking of loop.
            // 1->{2}
            // 2->{1,3,4}
            // 3->{5}
            // 4->{5}
            // 5->{}
            // Loop between 1 and 2. Directed graph. So when we get node 1 we make that to false.
            // When dfs starts for the node 2 then will go to the nb 1 and it will get false and return.
            // If dfs goes well then will return true and update the state as true.
            state[source] = true; // When the entire path goes well then will set the state to true.
            return true;
        }
    }
}
