package org.example.array.matrix;

// https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/

// Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of sub matrices that contain: grid[0][0], an equal frequency of 'X' and 'Y', at least one 'X'.
// grid = [["X","Y","."],["Y",".","."]]
// Output: 3
// grid = [[".","."],["Y","X"]]
// Output = 1.
public class CountSubmatrixWithEqualFreqOfXY {
    class Solution {
        public int numberOfSubmatrices(char[][] grid) {
            // I was thinking like traversal from the start node.
            // In matrix problem always think of prefix matrix and then traversal.
            // Here we can have a count of prefic of x,y,.
            // I was thinking of pair and adding the value in the same matrix. With pair the code was looking messy.
            // Easy was to make different matrix for x, y and then for the value check the matrix.
            int[][] xCount = matrixCount(grid,'X');
            int yCount[][] = matrixCount(grid,'Y');
            int ans = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(xCount[i][j]>0 && xCount[i][j] == yCount[i][j]){
                        ans++;
                    }
                }
            }
            return ans;
        }
        int[][] matrixCount(char grid[][], char ch){
            int res[][]= new int[grid.length][grid[0].length];
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    // First for the res[0][0]
                    if(grid[i][j]==ch) res[i][j] = 1;
                    // res[i][j] will be adding the value and in (i>0&&j>0) will reduce the value.
                    // Useful in prefix sum.
                    if (i > 0) res[i][j] += res[i - 1][j];
                    if (j > 0) res[i][j] += res[i][j - 1];
                    if (i > 0 && j > 0) res[i][j] -= res[i - 1][j - 1];
                }
            }
            return res;
        }
    }
}
