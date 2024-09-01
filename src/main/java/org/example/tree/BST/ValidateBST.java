package org.example.tree.BST;


// https://leetcode.com/problems/validate-binary-search-tree/description/

import java.util.ArrayList;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val,TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int val) {
        this.val = val;
    }
}
public class ValidateBST {
    class Inorder {
        ArrayList<Integer> arr = new ArrayList<>();

        void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            arr.add(root.val);
            inorder(root.right);
        }

        public boolean isValidBST(TreeNode root) {
            inorder(root);
            System.out.println(arr);
            if (arr.size() == 1) return true;
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) <= arr.get(i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
    class CheckingWithValue {
        // Root value can be anything and left child will be smaller than that value meaning -♾ to root value.
        // Right node will be of root value to ♾.
        public boolean isValidBST(TreeNode root) {
            if (root == null)
                return true;
            return validate(root, null, null);
        }

        boolean validate(TreeNode root, Integer min, Integer max) {
            if (root == null)
                return true;
            if ((min != null && root.val <= min) || (max != null && root.val >= max))
                return false;
            return validate(root.left, min, root.val) && validate(root.right, root.val, max);
        }
    }
}
