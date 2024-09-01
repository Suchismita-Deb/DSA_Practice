package org.example.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/

public class SecondMinValueInBinaryTree {
    class Sort {
        public int findSecondMinimumValue(TreeNode root) {
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
            int min = Integer.MAX_VALUE;
            int pos = -1;

            // [1,2,2,3,4,5]
            // 3rd smallest value then the answer should be 3 and not 2.
            // It is binary tree so duplicate value can be present.
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                // Continue going and see if the min value last index.
                if (list.get(i) <= min) {
                    min = list.get(i);
                    pos = i;
                }
            }
            if (pos == list.size() - 1)
                return -1;
            return list.get(pos + 1);
        }
    }
}
