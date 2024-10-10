package org.example.tree.BST;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//         6
//    2           8
// 0    4       7    9
//    3    5

// Output: 6
// Explanation: The LCA of nodes 2 and 8 is 6.
public class LongestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // BST when p and q both are greater than root then go for the right subtree.
        // p=7 and q=9 then first 6, number are greater than 6 so going to the right subtree.
        // Then 8, 7 is less and 9 is more so here the split occurs so 8 is the answer.
        // p=6 and q = 7. Starting from 6 the node is same and no child will the answer
        // so return 6.


        // When the value is greater than the root val.
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        // When the value is lesser than the root val.
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        // When the value is same as root or one value in left and other is right.
        return root;
    }
}
