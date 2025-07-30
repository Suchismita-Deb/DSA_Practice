package org.example.A15Trie;

public class DesignAddAndSearch {
    class WordDictionary {
        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    // a
                    // d c
                    // d e
                    curr.children[ch - 'a'] = new Node();
                }
                curr = curr.children[ch - 'a']; // Update the pointer to the new node.
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            return search(word, root, 0);
        }

        public boolean search(String word, Node curr, int index) {
            for (int i = index; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ch == '.') {
                    // Will go through the values of the children and check for the next part after
                    // the char.
                    for (Node temp : curr.children) {
                        if (temp != null && search(word, temp, i + 1))
                            return true;
                    }
                    return false;
                }
                if (curr.children[ch - 'a'] == null)// char is present and in the children it is not present.
                    return false;
                // Moving the next position.
                curr = curr.children[ch - 'a'];
            }
            return curr.isEnd;
        }
    }

    class Node {
        Node children[] = new Node[26];
        boolean isEnd = false;
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
