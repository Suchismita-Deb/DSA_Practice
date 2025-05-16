package org.example.tips;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practice {

    public static void main(String[] args) {

    }
    public static void dfsAdjList(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        if(vis[node]==true){
            return;
        }
        vis[node] = true;
        ls.add(node);
        for(int ar:adj.get(node)){
            dfsAdjList(ar,vis,adj,ls);
        }
    }
    public static void bfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while(!q.isEmpty()){
            int n = q.poll();
            ls.add(n);
            for(int a:adj.get(n)){
                if(vis[a]==false) {
                    q.add(a);
                    vis[a] = true;
                }
            }
        }
    }

}
