package org.example.A12Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        bfs(list, root);
        return list;
    }

    public void bfs(List<Integer> list, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size(); // When we get the first element from here then it will give the top nodes.
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = q.poll(); // When we get the top node from here then will get only one node.
                // Getting the first element.
                if (i == 0) list.add(cur.val);
                // Getting the right value first.
                if (cur.right != null) q.offer(cur.right);
                if (cur.left != null) q.offer(cur.left);
            }
        }
    }
}