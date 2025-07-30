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
            if(root==null) return res;
            q.add(root);
            while(!q.isEmpty()){
                int len = q.size();
                List<Integer> level = new ArrayList<>();
                for(int i=0;i<len;i++){
                    TreeNode top = q.poll();
                    level.add(top.val);
                    if(top.left!=null) q.add(top.left);
                    if(top.right!=null) q.add(top.right);
                }
                res.add(level);
            }
            return res;
        }
    }
}
