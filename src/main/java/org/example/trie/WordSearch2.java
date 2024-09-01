package org.example.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/word-search-ii/description/

public class WordSearch2 {
    class Solution {

        private static int rows;
        private static int cols;
        private Trie currentTrie;

        public List<String> findWords(char[][] board, String[] words) {
            // W*(M*N)*4^(M*N)
            // We can go in 4 direction. One dfs is 4^(MN)
            // We need to do for the entire grid so M*N.
            // We need to check for the words. Say W so need to multiply with it.

            // Instead of checking one char in the matrix and see if it exists.
            // We will check the char and see all the words exists.
            // Like when we see the char a then we see all the words that starts with a.
            // We need to check what word has the prefix of a.
            // Prefix tree of the words.
            // Now when we get one word in the matrix we check the prefix if there is the
            // prefix present then continue else return.

            rows = board.length;
            cols = board[0].length;
            Trie root = new Trie();

            for (String word : words) {
                // Adding the words in the currentTrie.
                root.addWord(word);
            }

            HashSet<String> res = new HashSet<>();
            HashSet<String> vis = new HashSet<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    dfs(i, j, root, "", res, vis, board, root);
                }
            }
            return new ArrayList<>(res);
        }

        void dfs(int i, int j, Trie node, String word, HashSet<String> res, HashSet<String> vis, char[][] board,
                 Trie root) {

            if (i < 0 || i >= rows || j < 0 || j >= cols || !node.children.containsKey(board[i][j])
                    || node.children.get(board[i][j]).refs < 1 || vis.contains(i + "-" + j)) {
                return;
            }
            vis.add(i + "-" + j);
            node = node.children.get(board[i][j]);
            word += board[i][j];
            if (node.isWord) {
                node.isWord = false;
                res.add(word);
                root.removeWord(word);
            }
            dfs(i + 1, j, node, word, res, vis, board, root);
            dfs(i - 1, j, node, word, res, vis, board, root);
            dfs(i, j + 1, node, word, res, vis, board, root);
            dfs(i, j - 1, node, word, res, vis, board, root);
            vis.remove(i + "-" + j);
        }

        class Trie {
            public HashMap<Character, Trie> children;
            public boolean isWord;
            public int refs = 0;

            public Trie() {
                children = new HashMap<>();
            }

            public void addWord(String word) {
                currentTrie = this;
                currentTrie.refs += 1;
                for (int i = 0; i < word.length(); i++) {
                    char currentCharacter = word.charAt(i);
                    if (!currentTrie.children.containsKey(currentCharacter)) {
                        currentTrie.children.put(currentCharacter, new Trie());
                    }
                    currentTrie = currentTrie.children.get(currentCharacter);
                    currentTrie.refs += 1;
                }
                currentTrie.isWord = true;
            }

            public void removeWord(String word) {
                currentTrie = this;
                currentTrie.refs -= 1;
                for (int i = 0; i < word.length(); i++) {
                    char currentCharacter = word.charAt(i);
                    if (currentTrie.children.containsKey(currentCharacter)) {
                        currentTrie = currentTrie.children.get(currentCharacter);
                        currentTrie.refs -= 1;
                    }
                }
            }
        }
    }
}
