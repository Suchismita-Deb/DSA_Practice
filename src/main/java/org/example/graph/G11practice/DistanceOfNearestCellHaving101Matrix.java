package org.example.graph.G11practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving101Matrix {

    class Node {
        int row;
        int col;
        int dist;

        Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    class Solution {
        public int[][] updateMatrix(int[][] mat) {

            if (mat == null || mat.length == 0 || mat[0].length == 0)
                return new int[0][0];

            int n = mat.length;
            int m = mat[0].length;
            int vis[][] = new int[n][m];
            for (int row[] : vis)
                Arrays.fill(row, -1);
            Queue<Node> q = new LinkedList<>();
            int dist[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 0) {
                        q.add(new Node(i, j, 0));
                        vis[i][j] = 1;
                        dist[i][j] = 0;
                    }
                    else{
                        vis[i][j] = 0;// Mark as 0.
                    }
                }
            }


            // int dist[][] = new int[n][m];
            while (!q.isEmpty()) {
                int r = q.peek().row;
                int c = q.peek().col;
                int d = q.peek().dist;
                q.remove();
                int rows[] = { -1, 0, 1, 0 };
                int cols[] = { 0, 1, 0, -1 };

                dist[r][c]= d;// Step.
                for (int i = 0; i < 4; i++) {
                    int nrow = r + rows[i];
                    int ncol = c + cols[i];
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                            mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                        // dist[nrow][ncol] = d + 1;
                        vis[nrow][ncol] = 1;
                        q.add(new Node(nrow, ncol, d + 1));
                    }
                }
            }
            return dist;
        }
    }
}
