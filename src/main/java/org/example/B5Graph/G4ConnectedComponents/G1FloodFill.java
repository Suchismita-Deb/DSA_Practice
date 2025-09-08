package org.example.B5Graph.G4ConnectedComponents;

import java.util.Arrays;

// https://leetcode.com/problems/flood-fill/description/

public class G1FloodFill {
    class Solution {

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int vis[][] = new int[image.length][image[0].length]; // mXn matrix taking care of the m and the n size.
            for (int row[] : vis)
                Arrays.fill(row, -1);
            int c = image[sr][sc];
            dfs(image, vis, sr, sc, c, color);
            return image;
        }

        void dfs(int[][] image, int vis[][], int i, int j, int c, int color) {
            if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != c)
                return;
            if (vis[i][j] == 1) {
                return;
            }
            if (image[i][j] == c) {
                image[i][j] = color;
            }
            vis[i][j] = 1;
            dfs(image, vis, i + 1, j, c, color);
            dfs(image, vis, i, j + 1, c, color);
            dfs(image, vis, i, j - 1, c, color);
            dfs(image, vis, i - 1, j, c, color);
        }
    }
}
