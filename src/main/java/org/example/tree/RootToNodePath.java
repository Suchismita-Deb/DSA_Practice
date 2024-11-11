package org.example.tree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/description/
public class RootToNodePath {
    // Given the root of a binary tree, return all root-to-leaf paths in any order. A leaf is a node with no children.
    // Input: root = [1,2,3,null,5]
    // ["1->2->5","1->3"]

    class Solution {
        List<String> list = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            // Inorder traversal.
            // First left then right. Taking array for the value like 1 2 5 then remove 5 and 2 and it is for the other part.
            // In the value 1 then 2 then from left it is null return false and right it is 5 and in 5 from left and right it is null and return false.
            // When left and rigt return false then take the element and remove from the array.
            // When the question ask to find path from root to a value then will return false when the value is not same and will return true when get the element and the array will contain the path.

            StringBuilder str = new StringBuilder();
            getPath(str, root);
            return list;
        }

        void getPath(StringBuilder str, TreeNode root) {
            if (root == null) {
                return;
            }

            int length = str.length();  // Store the current length of str to backtrack
            str.append(root.val);

            // Check if it's a leaf node
            if (root.left == null && root.right == null) {
                list.add(str.toString());  // Add the current path to the list
            } else {
                str.append("->");  // Append arrow for non-leaf nodes

                // Recursive calls for left and right children
                getPath(str, root.left);
                getPath(str, root.right);
                str.delete(str.length() - 2, str.length());
                // Deleting the last "->"
            }

            // Backtrack by resetting str to its original length
            // str.setLength(length);
            int numDigits = String.valueOf(root.val).length();
            System.out.println(numDigits);
            str.delete(str.length() - numDigits, str.length());
            // str.deleteCharAt(str.length() - 1);
            // We cannot delete the last number because the number can be single digit then fine but if the number is double or contains more digit then we need to remove the number.
        }
    }
}
