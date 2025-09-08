package org.example.B5Graph.G3DfsBfs;

// https://leetcode.com/problems/number-of-enclaves/

// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
// A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
// Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

import org.example.Pair;

import java.util.*;

// 1 that are connected with the boundary and mot counter. Bfs on the 1 in the boundary and changing the vis[i][j] value and when the entire bfs on the boundary completed then the 1 that are not connected with the boundary 1 can be counted.


public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        int dirR[] = {0,-1,0,1};
        int dirC[] = {1,0,-1,0};
        while(!q.isEmpty()){
            Pair arr = q.peek();
            int row = arr.first;
            int col = arr.second;
            q.poll();
            for(int i=0;i<4;i++){
                int newR = row+dirR[i];
                int newC = col+dirC[i];
                if(newR>=0 && newR<n && newC>=0 && newC<m && grid[newR][newC]==1 && vis[newR][newC]==0){
                    q.add(new Pair(newR, newC));
                    vis[newR][newC] = 1;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1)
                    count++;
            }
        }
        return count;
    }
}
