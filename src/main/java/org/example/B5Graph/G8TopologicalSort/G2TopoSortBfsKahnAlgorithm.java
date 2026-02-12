package org.example.B5Graph.G8TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G2TopoSortBfsKahnAlgorithm {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // Using BFS.
        // Kahn Algorithm.
        // Maintaining the indegree when the indegree is 0 then insert in queue.
        // If there is a cycle then indegree will never be zero for that node so the sorted array of the topo sort wil not contain the n number of node, so we can say that there is a cycle.

        int[] indegree = new int[V];
        // 1-->2 meaning indegree of 2 is 1.
        for (int i = 0; i < V; i++) {
            for (int n : adj.get(i)) {
                indegree[n]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] arr = new int[V];
        int i = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            arr[i++] = node;
            for (int nb : adj.get(node)) {
                indegree[nb]--;
                if (indegree[nb] == 0) {
                    q.add(nb);
                }
            }
        }
        return arr;
    }
}