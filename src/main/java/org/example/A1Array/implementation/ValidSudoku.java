package org.example.A1Array.implementation;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/description/

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
// Each row must contain the digits 1-9 without repetition. Each column must contain the digits 1-9 without repetition. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// A Sudoku board (partially filled) could be valid but is not necessarily solvable. Only the filled cells need to be validated according to the mentioned rules.

// Input: board =
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true
public class ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            // Need to check only for the added value.
            // Row should contain unique value and col should contain unique value.
            // Adding the Hashset for the row and for the column.
            // The hashset for the blocks also to check if the block contains unique numbers.
            Set<Character> row = null;
            Set<Character> col = null;
            for (int i = 0; i < 9; i++) {
                row = new HashSet<>();
                col = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if (row.contains(board[i][j])) {
                            return false;
                        } else {
                            row.add(board[i][j]);
                        }
                    }
                    if (board[j][i] != '.') {
                        if (col.contains(board[j][i])) {
                            return false;
                        } else {
                            col.add(board[j][i]); // If not added then add in the set.
                        }
                    }
                }
            }
            // Checking for the block.
            for (int i = 0; i < 9; i = i + 3) {
                for (int j = 0; j < 9; j = j + 3) {
                    if (!block(i, j, board)) return false;
                }
            }
            return true;
        }

        boolean block(int i, int j, char[][] board) {
            Set<Character> st = new HashSet<>();
            int row = i + 3;
            int col = j + 3;
            for (int indI = i; indI < row; indI++) {
                for (int indC = j; indC < col; indC++) {
                    if (board[indI][indC] != '.') {
                        if (st.contains(board[indI][indC])) {
                            return false;
                        }
                    }
                    st.add(board[indI][indC]); // Need to add after chceking, there is no same char then we will just add in the set.
                }
            }
            return true;
        }
    }
}
