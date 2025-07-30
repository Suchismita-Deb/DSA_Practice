package org.example.A12Tree;

// https://leetcode.com/problems/find-leaves-of-binary-tree/description/

//     1
//   2   3
// 4  5
// Output = [[4,5,3],[2],[1]]

// Idea - The height of the leaf nodes is 0. With DFS will get the height of the node here 4,5,3 are leaf node and the height is 0 so will add the 4,5,3 in the 0th position of the result list. res =[[4,5,3]]
// Next we got the height of the node 2 as 1 and we add 2 in the result array at the height position. res = [[4,5,3],[2]]. We are calculating the height and then adding the node at the height position.
// Another Approach is Topo sort kahn.
// Each node has a parent make the list for node.
// 1-{}
// 2-{1}
// 3-{1}
// 4-{2}
// 5-{2} Another map of storing the count of children per node.
// 1 2 3 4 5
// 2 2 0 0 0
// When the count of the child is 0 add in queue and reduce the child count from the parent as well. Like if we take 5 in the queue and reduce the count of 2 to 1. Like topo sort and when the count is 0 then add in queue.

// I was thinking about checking for leaf node like left and right and if null then add in the list and remove the node. The order of the node was giving issue.

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    class Solution {
        List<List<Integer>> res;
        public List<List<Integer>> findLeaves(TreeNode root) {
            res = new ArrayList<>();
            dfs(root);
            return res;
        }
        int dfs(TreeNode root){
            if(root==null) return -1;
            int height = 1+Math.max(dfs(root.left),dfs(root.right));
            // Need to initialize the res for that height.
            // Say height is 1 then at the index 1 the root.val will be added.
            if(height==res.size()) res.add(new ArrayList<>());
            res.get(height).add(root.val);
            return height;
        }
    }
}
