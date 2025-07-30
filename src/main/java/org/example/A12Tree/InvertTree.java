package org.example.A12Tree;

// https://leetcode.com/problems/invert-binary-tree/description/

public class InvertTree {

    class Solution {
        public TreeNode invertTree(TreeNode root) {

            // Simple DFS.
            // Left child will be in the right and right child will be on the left.
            // Preorder.
            if (root == null) return null;

            // Dont think much just do the work for one node.
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);

            invertTree(root.right);
            return root;
        }
    }
}
