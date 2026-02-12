package org.example.B5Graph.G1Representation;

import org.example.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph1 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=3;i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        // 2---3

        adjList.get(2).add(3);
        adjList.get(3).add(2);
        // 1---3
        adjList.get(1).add(3);
        adjList.get(3).add(1);
        for(int i=1;i<=3;i++){
            System.out.print(i +" -> ");
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j));
            }
            System.out.println();
        }

        // [[], [2, 3], [1, 3], [2, 1]]
        // BFS.
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> adj = new ArrayList<>();
        boolean vis[] = new boolean[3+1];
        vis[1] = true;
        q.add(1);
        while (!q.isEmpty()){
            int node = q.poll();
            adj.add(node);
            for(int n:adjList.get(node)){
                if(vis[n]==false){
                    vis[n] = true;
                    q.add(n);
                }
            }
        }
        System.out.println(adj);
        dfs(0,adjList,adj,vis);

    }
    public static void dfs(int i, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> adj, boolean vis[]){
        adj.add(i);
        vis[i] = true;
        for(int n:adjList.get(i)){
            if(vis[n]==false){
                dfs(n,adjList,adj,vis);
            }
        }
    }
    public static void walls(int[][] rooms){
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rooms[i][j] == 0){
                    q.add(new Pair(i,j));
                }
            }
        }
        int dirR[] = {-1,0,1,0};
        int dirC[]  = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair pos = q.poll();
            int row = pos.first;
            int col = pos.second;
            for(int i=0;i<4;i++ ){
                int newRow = row+dirR[i];
                int newCol = col+dirC[i];
                if(isValid(newRow, newCol, n, m)){
                    if(rooms[newRow][newCol]!=Integer.MAX_VALUE){
                        rooms[newRow][newCol] = rooms[row][col] + 1;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }
    public static boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
}