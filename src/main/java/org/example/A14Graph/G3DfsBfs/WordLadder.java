package org.example.A14Graph.G3DfsBfs;

import java.util.*;

// https://leetcode.com/problems/word-ladder/
// Changing each and ever char and checking if possible to reach to the word.
// Simple BFS and check in the set.
public class WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            // Queue will contain the word and the level. First hit and 1.
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(beginWord, 1));

            // Adding the dict to the set.
            Set<String> st = new HashSet<>();
            for (String word : wordList) {
                st.add(word);
            }

            st.remove(beginWord);
            while (q.size() != 0) {
                String word = q.peek().word;
                int level = q.peek().first;
                q.remove();
                System.out.println(word);// word will only be the word that are present in the dict.
                // The first occurrence of the word that is matching is the answer.
                if (word.equals(endWord)) return level;
                // changing all the char in the word and check if the word is present in the
                // set.
                for (int i = 0; i < word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        // Changing each and every char of the string and checking if it is presnet in
                        // the set.
                        char[] newWord = word.toCharArray();
                        newWord[i] = ch;
                        String newWordString = new String(newWord);
                        if (st.contains(newWordString)) {
                            q.add(new Pair(newWordString, level + 1));
                            st.remove(newWordString);
                            // break; When get one word we cant break as in some case going forward will not
                            // be possible in one combination and we need to get all the word poosible by
                            // changing one char.
                        }
                    }
                }
            }
            return 0;
        }

        class Pair {
            String word;
            int first;

            Pair(String word, int first) {
                this.word = word;
                this.first = first;
            }
        }
    }
}
