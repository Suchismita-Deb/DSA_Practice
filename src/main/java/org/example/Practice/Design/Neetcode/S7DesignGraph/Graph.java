package org.example.Practice.Design.Neetcode.S7DesignGraph;

import java.util.ArrayList;
import java.util.HashSet;

public class Graph {
    private ArrayList<ArrayList> adjList;

    public Graph() {
        adjList = new ArrayList<>();
    }
    public void addEdge(int src, int dst) {
        while (adjList.size() <= src) {
            // src node not present in the graph then add the node.
            adjList.add(new ArrayList<>());
        }
        while (adjList.size() <= dst) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (src >= adjList.size()) return false;
        return adjList.get(src).remove((Integer) dst);
    }

    public boolean hasPath(int src, int dst) {
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(src, dst, visited);
    }

    private boolean hasPathDFS(int src, int dst, HashSet<Integer> visited) {
        if (src == dst) return true;
        if (src >= adjList.size()) return false;

        visited.add(src);
        ArrayList<Integer> neighbors = (ArrayList<Integer>) adjList.get(src);

        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                if (hasPathDFS(neighbor, dst, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}

