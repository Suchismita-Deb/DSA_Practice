package org.example.B5Graph.G8TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;
// https://www.geeksforgeeks.org/problems/topological-sort/1

/*
Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.
Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]
Output: true.

Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]

*/
public class G1TopoSortDFS {


    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Using DFS.
        // Using Stack and store all the node connected then print the elements in stack.
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                dfs(adj,vis,i,st);
            }
        }
        int arr[] = new int[V];
        int i=0;
        while(!st.isEmpty()){
            arr[i++] = st.peek();
            st.pop();
        }
        return arr;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int vis[], int node, Stack<Integer> st){
        vis[node] = 1;
        for(int nb:adj.get(node)){
            if(vis[nb]==0)
                dfs(adj,vis,nb,st);
        }

        // If there is any nb then that will be pushed first in the stack then the node.
        // It will be pushed after the connected nodes are pushed.
        st.push(node);
    }
}