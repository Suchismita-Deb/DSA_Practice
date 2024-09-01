package org.example.tree;

import java.util.*;

public class TopViewBinaryTree {
    static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    class Solution {
        // Top view from left to right in Binary Tree.
        static ArrayList<Integer> topView(TreeNode root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) return null;
            Queue<Pair> q = new LinkedList<>();
            TreeMap<Integer, Integer> mp = new TreeMap<>(); // Map<ColNo,Node.data>
            q.add(new Pair(root, 0));
            while (!q.isEmpty()) {
                Pair top = q.remove();
                int colNo = top.col;
                TreeNode temp = top.node;
                if (mp.get(colNo) == null) mp.put(colNo, temp.val); // Adding only one value for one colNo.
                if (temp.left != null) q.add(new Pair(temp.left, colNo - 1));
                if (temp.right != null) q.add(new Pair(temp.right, colNo + 1));
            }
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                // Storing in treeMap so that we get the order and also cant store in array -ve index.
                ans.add(entry.getValue());
            }
            return ans;
        }
    }
}
