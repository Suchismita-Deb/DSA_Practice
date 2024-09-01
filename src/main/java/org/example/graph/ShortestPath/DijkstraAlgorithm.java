package org.example.graph.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
/*
Time = O(ElogV) E = Edges and V = Node.
Space = O(V)

Both Directed and Undirected Weighted Graph.
Not in negative weight cycle graph.
Implementation is like BFS.
Will get the min distance from the min heap.
 */

public class DijkstraAlgorithm {

    class Pair {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
    //Function to find the shortest distance of all the vertices from the source vertex S.
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Min Heap based on distance. // Default is min heap.
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int dist[] = new int[V];
        Arrays.fill(dist, ((int) (1e9)));

        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (ArrayList<Integer> nb : adj.get(node)) {
                // ArrayList<Integer> cannot be converted to ArrayList<ArrayList<Integer>>
                int adjNode = nb.get(0); // cannot find symbol int adjNode = nb.get(node).get(0);
                int wt = nb.get(1);
                if (wt + dis < dist[adjNode]) {
                    pq.add(new Pair(wt + dis, adjNode));
                    dist[adjNode] = wt + dis;
                }
            }
        }
        return dist;
    }
}
