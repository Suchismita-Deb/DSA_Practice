package org.example.A12Tree;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

// Explanation in the DSA_Course.

// PreOrder = [3 9 20 15 7]
// Inorder = [9 5 15 20 7]

// Preorder is the order with root first.
// Inorder is left root right.
// First we got 3 from the preorder. Anything before 3 in inorder is the left subtree and in the right is the right subtree.

// First find the root and then in inorder make one array for the left subtree and another for the right subtree. Then call the method.
// Left subtree index.
// preorder index = start, end = 1,1
// inorder index = start, end = 0,0

import java.util.Arrays;

// Right subtree index.
// preorder index = start, end = 2,4
// inorder index = start, end = 2,4
public class ConstructBinaryTreeFromPreOrderInorder {
    class Solution {
        TreeNode buildTree(int[] preorder, int[] inorder) {

            // check if preorder is null
            if (preorder.length == 0) return null;

            // First value in the proOrder is the root.
            int rootNode = preorder[0];
            TreeNode root = new TreeNode(rootNode);

            // Finding the root in inorder to get the left subtree and the right subtree.
            int rootId = -1;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootNode) {
                    rootId = i;
                    break;
                }
            }
            // rootId has the position of the root in inorder.

            // Preorder = 4 5 6 8 7 1 2 3
            // Inorder =  5 6 8 4 7 1 2 3
            // When got 4 as root then the leftInorder = [5 6 8] same length in the preorder after the root.
            // The rightInorder after the 4 and till the length of the inorder.

            // Making the array for the left subtree and the right subtree.
            // Inorder
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootId); // array, start , end // inorder[0.....rootId - 1]
            int[] rightInorder = Arrays.copyOfRange(inorder, rootId + 1, inorder.length); // does not consider the end. // inorder[rootId + 1....]

            // PreOrder
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length + 1); // // preorder[1.....leftInorder.length]
            int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length); // preorder[leftInOrder.length + 1 .... ]

            root.left = buildTree(leftPreorder, leftInorder);
            root.right = buildTree(rightPreorder, rightInorder);
            return root;

        }
    }
}
