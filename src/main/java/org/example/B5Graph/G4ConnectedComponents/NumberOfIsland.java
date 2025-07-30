package org.example.B5Graph.G4ConnectedComponents;

// https://leetcode.com/problems/number-of-islands/

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        // [["1","1","0","0","0"],
        //  ["1","1","0","0","0"],
        //  ["0","0","1","0","0"],
        //  ["0","0","0","1","1"]]
        // Op = 3
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(char grid[][], int i, int j) {
        if (i < 0 || j < 0)
            return;
        if (i >= grid.length || j >= grid[i].length)
            return;
        if (grid[i][j] == '0')
            return;
        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}