package org.example.B3Tree;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    class Iterative {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            q.add(root);
            while (!q.isEmpty()) {
                int len = q.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    TreeNode top = q.poll();
                    level.add(top.val);
                    if (top.left != null) q.add(top.left);
                    if (top.right != null) q.add(top.right);
                }
                res.add(level);
            }
            return res;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            List<List<Integer>> r = new ArrayList<>();
            if (root == null) return r;
            while (q.size() != 0) {
                List<Integer> res = new ArrayList<>();
                while (q.peek() != null) {
                    TreeNode top = q.poll();
                    res.add(top.val);
                    if (top.left != null) q.add(top.left);
                    if (top.right != null) q.add(top.right);
                }
                q.poll();
                if (q.size() != 0) q.add(null);
                r.add(res);
            }
            return r;
        }
    }
}
