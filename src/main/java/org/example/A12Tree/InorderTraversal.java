package org.example.A12Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    class IterativeStack {
        public List<Integer> inorderTraversal(TreeNode root) {
            // [1,2,3,4,5,null,null]
            // 4 2 5 1 3
            // Need to go to the extreme left.
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
            return list;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            return list;
        }

        public void inorder(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}
