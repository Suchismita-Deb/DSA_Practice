package org.example.B3Tree;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.

Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Input: root = [-10,9,20,null,null,16,7]
Output: 43
Explanation: The optimal path is 16 -> 20 -> 7 with a path sum of 16 + 20 + 7 = 43.
*/
public class MaximumPathSumBinaryTree {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // [1,2,3,null,null,4,5]
        // [11,2,8,null,null,4,5]
        // the return value of the subproblem with only one split.
        // When call for every node then we call for the subtree.
        maxSum(root);
        return res;
    }

    int maxSum(TreeNode root) {
        if (root == null) return 0;
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        left = Math.max(left, 0);// child can contain negative number in that case will not consider the child
        // and not split.
        right = Math.max(right, 0);
        // max from the node with the split.
        res = Math.max(res, root.val + left + right);
        // return type is max from the node with one side value.
        return root.val + Math.max(left, right);
    }
}