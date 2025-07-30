package org.example.A12Tree;

import java.util.*;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

public class SerializeAndDeserializeBinaryTree {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> list = new ArrayList<>();
            serialize(root, list);
            return String.join(",", list);
        }

        void serialize(TreeNode root, List<String> list) {
            if (root == null) {
                list.add("N");
                return;
            }
            list.add(String.valueOf(root.val));
            serialize(root.left, list);
            serialize(root.right, list);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return dfs(queue);
        }

        TreeNode dfs(Queue<String> queue) {
            String s = queue.poll();
            if (s.equals("N")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(s));
            root.left = dfs(queue);
            root.right = dfs(queue);
            return root;
        }
    }
}
