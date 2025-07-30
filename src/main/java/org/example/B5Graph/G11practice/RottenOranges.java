package org.example.B5Graph.G11practice;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/description/

//grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
public class RottenOranges {
    // Checking for all the levels and not going in depth of one node.
    // Multisource BFS.
    class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    class Solution {
        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            Queue<Pair> q = new LinkedList<>();
            int vis[][] = new int[n][m];

            int fresh = 0;
            // Adding the sources to the queue.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 2) {
                        q.add(new Pair(i, j, 0));
                        vis[i][j] = 2;
                    } else {
                        vis[i][j] = 0;
                    }
                    if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }

            int rows[] = { -1, 0, 1, 0 };
            int cols[] = { 0, 1, 0, -1 };
            int cnt = 0;
            int tm = 0;
            while (!q.isEmpty()) {
                int r = q.peek().row;
                int c = q.peek().col;
                int t = q.peek().time;
                // We can check the time when getting from the queue and we can also get the time from the value before adding.
                q.remove();
                for (int i = 0; i < 4; i++) {
                    int nrow = r + rows[i];
                    int ncol = c + cols[i];
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1
                            && vis[nrow][ncol] == 0) {
                        q.add(new Pair(nrow, ncol, t + 1));
                        tm = Math.max(t+1, tm);
                        vis[nrow][ncol] = 2;
                        cnt++;
                    }
                }
            }
            return cnt == fresh ? tm : -1;
        }
    }
}
