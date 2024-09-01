package org.example.tree;

/*
    Height Balanced meaning depth of the subtrees of every node differs by at most 1.
    Brute Force - Check for every node and call the left tree and right tree. O(N2).
                   For every node checking the left subtree and the right subtree.
    Efficient - When we start from the bottom of the tree and check if any node height value is more than 1 then return false.
                I dont have to check for all node again.
 */


// https://leetcode.com/problems/balanced-binary-tree/description/


public class BalancedBinaryTree {
    class Pair {
        Boolean key;
        Integer value;

        Pair(Boolean key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public boolean getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    class Efficient1 {
        public boolean isBalanced(TreeNode root) {
            return dfs(root).getKey();
        }

        Pair dfs(TreeNode root) {

            if (root == null)
                return new Pair(true, 0); // return new Pair<Boolean, Integer>(true, 0); We need to write in the platform. Java does not have any import for pair there is apache commons and we need to add in build.gradle.
            var left = dfs(root.left); // Boolean will return if the subtree is balanced or not.
            var right = dfs(root.right);
            var balanced = left.getKey() && right.getKey() && (Math.abs(left.getValue() - right.getValue()) <= 1);

            return new Pair(balanced, 1 + Math.max(left.getValue(), right.getValue()));// returning the balanced and the height.
        }
    }

    class Efficient {
        public boolean isBalanced(TreeNode root) {
            // We can only check in the dfs method if the height is balanced.
            int n = dfs(root);
            return n != -1;
        }

        int dfs(TreeNode root) {
            // Here we are only taking care of the height.
            if (root == null) return 0;

            int left = dfs(root.left);
            if (left == -1) return -1; // This check is good. If got -1 in the middle then return.

            int right = dfs(root.right);
            if (right == -1) return -1;

            // After both the dfs calls are done then will check the condition.
            if (Math.abs(left - right) > 1) return -1;

            // Final is the max of the tree.
            return Math.max(left, right) + 1;
        }
    }

    class BruteForce {
        public boolean isBalanced(TreeNode root) {
            // Following exactly the question. Calling the height for the left and the right.
            if (root == null) return true;
            int left = height(root.left);
            int right = height(root.right);
            // Call for the left subtree and right subtree.
            return (Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right));
            // Here we are already checking the left and the right subtree. This is repeatative.
            // We can directly check the left and right and return the height in checking and then can compare height.
            // We can make another method and return the boolean if it is balanced and int the height.
        }

        // This is the method to find the depth of a binary tree.
        int height(TreeNode root) {
            if (root == null) return 0;
            int left = height(root.left);
            int right = height(root.right);
            return 1 + Math.max(left, right);
        }
    }

    class MaxDepthOfBinaryTree {
        public int maxDepth(TreeNode root) {

            // Checking for the null.
            // Then calling the left and the right.
            if (root == null) return 0;
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}

