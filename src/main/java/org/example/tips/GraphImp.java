package org.example.tips;

import java.util.ArrayList;

public class GraphImp {
    static class Edge{
        int first;
        int second;
        Edge(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        // If the dfs method return type is boolean then when ever will call the dfs will check the if condition for the boolean return.

        // edges = [[2,1,1],[2,3,1],[3,4,1]]
        // When edges are given in the form of node to node and weight meaning 2->1 and the weight is 1. 2-->3 2 is directed to 3 and teh weight is 1. Here we need to create the adj matrix.

        // In some cases the edges are given as edges = [[1,2],[2,3]] meaning the node 0 is connected to 1 and 2 and node 1 is connected to 2 and 3. This is already in adj list form.

        // times = [[2,1,1],[2,3,1],[3,4,1]] n = 4.
        int n=4;
        int times[][] = new int[2][3];
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){ // This is for the nodes.
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){ // This is adding the edges and it will continue for the edges like times.length.
            adj.get(times[i][0]).add(new Edge(times[i][1],times[i][2]));
            // 2 -> {1,1},{3,1}
        }
    }
}
