package org.example.A14Graph.G9MinimumSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

public class PrimsAlgorithm {
    static class Pair {
        int node;
        int distance;
        int par;

        Pair(int distance, int node, int par) {
            this.node = node;
            this.distance = distance;
            this.par = par;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        // Here it is only asking for the sum so we donot need to store the par.
        // To print the MST then we need the parent.
        pq.add(new Pair(0, 0, -1));
        int vis[] = new int[V];
        Arrays.fill(vis, 0);
        int sum = 0;
        ArrayList<int[]> mst = new ArrayList<>(); // [[0,2],[1,2],[2,3],[3,4]]

        while (pq.size() != 0) {
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            int par = pq.peek().par;

            pq.remove();
            if (vis[node] == 1) continue;
            vis[node] = 1;
            mst.add(new int[]{par, node});
            sum += distance;

            for (int[] nb : adj.get(node)) {// getting the inner type.
                int n = nb[0];
                int wt = nb[1];
                if (vis[n] == 0) {
                    pq.add(new Pair(wt, n, node));
                }
            }

        }

        // To print the mst.
        /*
        for(int i=0;i<mst.size();i++){
            int ar[] = mst.get(i);
            System.out.println(ar[0] + " " + ar[1]);
        }
        */
        return sum;
    }
}

