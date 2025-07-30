package org.example.B5Graph.G9MinimumSpanningTree.MstPractice;

import java.util.ArrayList;
import java.util.PriorityQueue;

// https://leetcode.com/problems/min-cost-to-connect-all-points/

public class MinCostToConnectAllPoints {
    class Edge {
        int first;
        int second;
        int third;

        Edge(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    class Pair {
        int vertex;
        int distance;

        Pair(int distance, int vertex) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    // points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
    // Output = 20.
    class Solution {

        public int minCostConnectPoints(int[][] points) {
            // Connect each pair of points with a weighted edge, the weight being the manhattan distance between those points.
            // Now it is like MST.
            ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
            for (int i = 0; i < points.length; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < points.length; i++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                for (int j = i + 1; j < points.length; j++) { // Undirected so connecting one node with the other.
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int d1 = Math.abs(x2 - x1);
                    int d2 = Math.abs(y2 - y1);
                    int d = d1 + d2;
                    adj.get(i).add(new Edge(i, j, d));
                    adj.get(j).add(new Edge(j, i, d)); // Undirected graph.
                    // For the node i checking for all i+1 to n and adding the dist in the edge.
                    // Making the node in point as node 0, 1, 2 and the connection among them contains the distance. Making them the vertex and then storing in the heap.
                }
            }
            int[] vis = new int[points.length];

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
            // Default it is min heap but it is giving error for the comparator so added the comparator.
            pq.add(new Pair(0, 0));
            int sum = 0;
            while (pq.size() != 0) {
                int node = pq.peek().vertex;
                int dist = pq.peek().distance;
                pq.remove();
                if (vis[node] == 1) continue;
                vis[node] = 1;
                sum += dist;
                for (Edge nb : adj.get(node)) {
                    pq.add(new Pair(nb.third, nb.second));  // First adding the distance.
                }
            }
            return sum;
        }
    }
}
