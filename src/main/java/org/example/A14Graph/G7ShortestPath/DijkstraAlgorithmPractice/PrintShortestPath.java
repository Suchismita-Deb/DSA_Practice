package org.example.A14Graph.G7ShortestPath.DijkstraAlgorithmPractice;

// https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintShortestPath {
    // From src to dest print the shortest path
    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    class Solution {
        public List<Integer> shortestPath(int n, int m, int edges[][]) {
            // Dijkstra Algorithm to get the shortest value.
            // Need to remember the path coming from to reach the node.
            // Need to store the parent of all the node.

            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for(int i=0;i<=n;i++){
                adj.add(new ArrayList<>());
            }
            // edges = [[1, 2, 2], [2, 5, 5], [2, 3, 4], [1, 4, 1], [4, 3, 3], [3, 5, 1]]
            // {a,b,w}
            for(int i=0;i<m;i++){
                adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
                adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
            }
            int dist[] = new int[n+1];
            // Arrays.fill(dist,(int)1e8);


            int parent[] = new int[n+1];
            for(int i=1;i<=n;i++) {
                parent[i] = i;
                dist[i] = (int)1e8;
            }
            dist[1] = 0;

            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.first-b.first);
            pq.add(new Pair(0,1));

            while(pq.size()!=0){
                int node = pq.peek().second;
                int wt = pq.peek().first;
                pq.poll();

                for(Pair nb:adj.get(node)){
                    int adjNode = nb.first;
                    int adjWt = nb.second;
                    if(wt+adjWt <dist[adjNode]){
                        dist[adjNode] = wt+adjWt;
                        parent[adjNode] = node;
                        pq.add(new Pair(adjWt + wt,adjNode));
                    }
                }
            }

            List<Integer> list = new ArrayList<>();
            if(dist[n]==(int)1e8){
                list.add(-1);
                return list;
            }
            int node = n;
            while(parent[node]!=node){
                list.add(node);
                node = parent[node];
            }
            list.add(1);
            Collections.reverse(list);
            return list;
        }
    }
}
