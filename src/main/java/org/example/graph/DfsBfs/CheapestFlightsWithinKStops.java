package org.example.graph.DfsBfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/

// n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
// Output - 700.
public class CheapestFlightsWithinKStops {
    class Pair {
        int first;
        int second;
        int third;

        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    class Graph {
        int first;
        int second;

        Graph(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // Simple Dijkstra will not work. Say there is a shortest path from src to some
            // point using k steps and we are storing the distance in the heap and no other
            // step to reach to final place.
            // We need to take some other place with more distance as we can only make k
            // steps.
            // Here we need to mainly think about the k steps.
            // In the heap will store the steps, node and distance.
            // No need of heap as we are taking care of teh steps and the steps are
            // increasing at a 1 steps.
            // Maintain one dist array and store the distance. When reached the destination
            // will not stop and continue till the steps.
            ArrayList<ArrayList<Graph>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());
            for (int i = 0; i < flights.length; i++) {
                adj.get(flights[i][0]).add(new Graph(flights[i][1], flights[i][2]));
            }

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(0, src, 0));
            int dist[] = new int[n];
            Arrays.fill(dist, (int) 1e8); // We will find teh min distance so storing the max value.
            dist[src] = 0;

            while (q.size() != 0) {
                int count = q.peek().first;
                int node = q.peek().second;
                int cost = q.peek().third;
                q.remove();
                if (count > k)
                    continue; // not allowed so need to remove and continue meaning in next time it is pop().
                for (Graph nb : adj.get(node)) {
                    // for (int nb : flights[node]) {
                    // int newNode = nb[1];
                    // int edgeW = nb[2]; // This is not possible as in the given array flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]] 1 is connected to 2 and 3 so not able to get all the adj node. So need the adj list.
                    int newNode = nb.first;
                    int edgeW = nb.second;
                    if (cost + edgeW < dist[newNode] && count <= k) {
                        dist[newNode] = cost + edgeW;
                        q.add(new Pair(count + 1, newNode, cost + edgeW));
                    }
                }
            }

            if (dist[dst] == (int) 1e8)
                return -1;
            return dist[dst];
        }
    }
}
