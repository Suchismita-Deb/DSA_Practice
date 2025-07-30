package org.example.A14Graph.G7ShortestPath.DijkstraAlgorithmPractice;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

/*
Why BFS and not DFS?

If we want to find a possible path, DFS will be more efficient. Because DFS will return a possible path if found, while it may not the shortest path.

BFS will try every possible path at the same time.

If we want to find the shortest of all possible paths, BFS is more efficient. It's impossible for DFS to determine which is the shortest before trying all possible paths.
*/

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid.length == 0 || grid == null) {
                return -1;
            }
            int n = grid.length;
            int m = grid[0].length;
            if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
                return -1; // Cant move as starting and ending is 1.
            }
            int dirs[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 },
                    { -1, 1 }, { -1, -1 }, { 1, 1 }, { 1, -1 } };
            // First part is for the 4 direction and the remaining is for the diagonal.

            // Queue will contain the row and col.
            Queue<int[]> q = new LinkedList<>();
            int vis[][] = new int[n][m]; // Visited array of row and col.

            q.add(new int[] { 0, 0 });// Adding the row and the col in the queue.
            vis[0][0] = 1;
            int ans = 0;
            while (q.size() != 0) {
                // int row = q.peek(); Queue contains int[] so can not access directly.
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = q.peek();
                    q.remove();

                    if (cur[0] == n - 1 && cur[1] == m - 1) {
                        return ans+1;
                    }
                    for (int j = 0; j < 8; j++) {
                        int newRow = cur[0] + dirs[j][0];
                        int newCol = cur[1] + dirs[j][1];

                        if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m || vis[newRow][newCol] == 1 || grid[newRow][newCol] == 1) {
                            continue;
                        }

                        vis[newRow][newCol] = 1;
                        q.add(new int[] { newRow, newCol });
                    }
                }
                ans++;
            }
            return -1; // ans!=0?ans:-1. Not correct. ans value will increase it should only
        }
    }
}
