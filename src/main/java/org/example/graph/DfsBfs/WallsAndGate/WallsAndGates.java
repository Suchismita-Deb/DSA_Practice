package org.example.graph.DfsBfs.WallsAndGate;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/walls-and-gates/description/
public class WallsAndGates {
    // Multisource BFS from the gate.
    class Solution {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public void wallsAndGates(int[][] rooms) {
            int n = rooms.length;
            int m = rooms[0].length;

            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (rooms[i][j] == 0) queue.add(new int[]{i, j});
                }
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] curr = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int row = curr[0] + dx[i];
                        int col = curr[1] + dy[i];
                        if (isValid(row, col, n, m) && rooms[row][col] == Integer.MAX_VALUE) {
                            rooms[row][col] = rooms[curr[0]][curr[1]] + 1;
                            queue.add(new int[]{row, col});
                        }
                    }
                }
            }
        }

        public boolean isValid(int i, int j, int n, int m) {
            return i >= 0 && j >= 0 && i < n && j < m;
        }
    }
}
