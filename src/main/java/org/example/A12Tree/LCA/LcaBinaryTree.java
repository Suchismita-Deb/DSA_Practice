package org.example.A12Tree.LCA;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
// root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// p = 7 q = 6.
// Output - 5.
// Explanation: The LCA of nodes 5 and 1 is 3/

//        3
//    5       1
// 6    2   0   8
//    7   4
public class LcaBinaryTree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Brute force to find the LCA.
            // Path from the root to the node p and q.
            // Path to the node = [3, 5, 6]
            // Path to the node = [3, 5, 2, 7]
            // The max node that is the common is the 5.


            // p and q will exist in the tree. This is given in the condition. In this approach if one is not present then also it will return the node.

            // Inorder.
            // Root then left and got 5 go to the left and got 6 and then it is null return null. Then right of 5 there is 2 then 7 and 4 so 2 return 7 from left and null from right. When one value is present then return the value and return 7.
            // 5 got 6 from left and 7 form right. There is valkue in the left and right and there are both the node so the node are present under the node 5.
            // 5 return 5 to the node 3.
            // In the node 3 we got 5 in left and null in the right so the LCA is the value we got in the root. LCA of 6 and 4 is 5.

            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) {
                // one side is null then return the value in the right.
                return right;
            } else if (right == null) {
                return left;
            }

            // root contains one size of the lca and oen side null return root. It can get both side some value then return root.
            return root;
        }
    }

}
