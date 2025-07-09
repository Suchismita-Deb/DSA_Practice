package org.example.graph.G8TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;
// https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopoSortDFS {
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