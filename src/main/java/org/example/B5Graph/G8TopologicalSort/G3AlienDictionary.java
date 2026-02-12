package org.example.B5Graph.G8TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G3AlienDictionary {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // Using BFS.
        // Kahn Algorithm.
        int indegree[] = new int[V];
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

        int arr[] = new int[V];
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

    public String findOrder(String[] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) { // Making the adj list.
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int ptr = Math.min(s1.length(), s2.length());
            // Making the DAG.
            for (int j = 0; j < ptr; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        int arr[] = topoSort(K, adj);
        String ans = "";
        for (int it : arr) {
            ans = ans + (char) (it + (int) 'a');
        }
        return ans;
    }

}
