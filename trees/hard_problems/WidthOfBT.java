package trees.hard_problems;

import java.util.LinkedList;
import java.util.Queue;

// Width of Binary Tree - https://leetcode.com/problems/maximum-width-of-binary-tree/
/*
Perform level-order traversal (BFS) while assigning position indices to nodes as per a complete binary tree.
Normalize indices at each level to avoid overflow(using previous level last index) and compute width as right - left + 1.
Track and update the maximum width found across all levels during traversal.
 */

public class WidthOfBT {
    private static class Pair{
        TreeNode node;
        int id;
        public Pair(TreeNode node, int id){
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int n = q.size();
            int base = q.peek().id;
            int first = 0, last = 0;

            for (int i = 0; i < n; i++) {
                Pair p = q.poll();
                int id = p.id - base;
                TreeNode node = p.node;
                if (i == 0) first = id;
                if (i == n - 1) last = id;
                if (node.left != null) q.offer(new Pair(node.left, id * 2 + 1));
                if (node.right != null) q.offer(new Pair(node.right, id * 2 + 2));
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}
