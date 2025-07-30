package org.example.A12Tree.BST;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInBST {
    class InorderSort {
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> st = new Stack<>();
            while (root != null || st.size() != 0) {
                while (root != null) {
                    // Get the value in the left and add in the stack.
                    st.push(root);
                    root = root.left;
                }
                root = st.pop(); // Get the top element from stack.
                list.add(root.val); // Add in the list.
                root = root.right; // Get the right of the top element.
            }
            // Iterative inorder then print the kth element.
            return list.get(k - 1);
        }
    }
}
