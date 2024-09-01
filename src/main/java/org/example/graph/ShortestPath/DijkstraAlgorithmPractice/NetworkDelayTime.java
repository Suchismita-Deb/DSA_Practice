package org.example.graph.ShortestPath.DijkstraAlgorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/network-delay-time/description/
public class NetworkDelayTime {
    class Pair {
        int distance;
        int vertex;

        Pair(int distance, int vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }
    }

    class Edge {
        int first;
        int second;

        Edge(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
// times = [[2,1,1],[2,3,1],[3,4,1]]  n=4 k=2 Output = 2.
// ArrayList<ArrayList<Edge>> adj.
// 2 -> {3,1},{1,1}

    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            // Dijkstra Algorithm.
            // BFS is simple going layer by layer.
            ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < times.length; i++) {
                adj.get(times[i][0]).add(new Edge(times[i][1], times[i][2]));
            } // Using the class

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
            pq.add(new Pair(0, k));
            int[] distance = new int[n + 1]; // Node is till n so making for n+1;
            Arrays.fill(distance, (int) (1e8));// Need to find the min value.
            distance[k] = 0;
            while (pq.size() != 0) {
                Pair top = pq.peek(); // pq is Pair type.
                pq.remove();
                int node = top.vertex;
                int dist = top.distance;
                for (Edge nb : adj.get(node)) { // adj is Edge type so getiing the nb as Edge.
                    if (dist + nb.second < distance[nb.first]) { // In Edge first is node and second is distance. We are calculating the distance and also adding the previous distance to go to this node.
                        // In the example from node 2->1 and 3 it took 1 and from 3 to 4 it took 2.
                        distance[nb.first] = dist + nb.second;
                        pq.add(new Pair(distance[nb.first], nb.first));
                    }
                }
            }
            System.out.println(Arrays.toString(distance)); // The 0th value is 1e8.
            int maxVal = 0;
            for (int i = 1; i <= n; i++) {
                // If any other index is int max then not reached then return -1.
                if (distance[i] == (int) (1e8)) return -1;
                maxVal = Math.max(maxVal, distance[i]);
            }
            return maxVal;
        }
    }
}
