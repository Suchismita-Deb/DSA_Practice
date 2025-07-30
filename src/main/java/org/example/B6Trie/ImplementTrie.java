package org.example.B6Trie;

public class ImplementTrie {
    class Trie {
        // For the trie we need the node class.
        Node root; // The root node will hold the entire connection.

        public Trie() {
            // Creating the root node.
            root = new Node();
        }
        //  Root Each alphabet is a node and the end of the alphabet is marked. So if the question say is there any prefix of app it is yes as we have apple.
        //    a
        //  p  c
        // p    e
        // l
        // e

        public void insert(String word) {
            Node curr = root;
            // Character by character I am checking if it is already exist then add one node
            // else make new node.
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new Node();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            Node res = getLast(word);
            // Res is null then word is not present false else true.
            // res.isEnd is important else it will count apple and app as same word.
            return res != null && res.isEnd; // getLast will return the last node curr and we can check the isEnd for the last character.
        }

        public boolean startsWith(String prefix) {
            Node res = getLast(prefix);
            // If at any point the char not present then return null.
            // getLast will return the last char.
            // "apple" checking for the startswith "app" then will be getting the last char
            // as e meaning the entire string does not return null so app is present.
            return res != null;
        }

        public Node getLast(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                // Checking for all the char in the word and if we got the char value in the
                // children as null then the word does not exists.
                // Present then will get the last node.
                if (curr.children[ch - 'a'] == null) {
                    return null;
                }
                curr = curr.children[ch - 'a'];
            }
            return curr; // The curr is pointing to the last node , the last character.
        }
    }

    class Node {
        Node[] children; // Initial children can be only 26. Every node will have another 26 children.
        // Words can starts with a, b, ..... z.
        // Then the word starts with a can contain char from a to z.
        boolean isEnd;

        Node() {
            children = new Node[26];
        }
    }
}
