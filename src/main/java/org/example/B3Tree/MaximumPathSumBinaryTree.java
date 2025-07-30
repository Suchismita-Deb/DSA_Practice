package org.example.B3Tree;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

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