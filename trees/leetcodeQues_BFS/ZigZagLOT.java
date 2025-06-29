// LeetCode [medium] ques : given the root of a binary tree, return the Zig Zag level order traversal(i.e; l-->r, and r --> l in next level and so on alternatively)
// ex: input : root = [3, 9, 20, null, null, 15, 7]
// OUTPUT =   (in LOT) : [ [3], [9, 20], [15, 7] ]
// but (in zigZag LOT) : [ [3], [20, 9], [15, 7] ]
package trees.leetcodeQues_BFS;

import java.util.*;

public class ZigZagLOT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null){
                return result;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            boolean reverse = false; //initially not reverse, reverse in each next level by setting it !reverse (true ka false aue false ka true ho jaiga)inside loop

            while (!queue.isEmpty()){
                int n = queue.size();
                List<Integer> list = new LinkedList<>();
                for(int i=0;i<n;i++) {
                    if (!reverse){
                        TreeNode currentNode = queue.pollFirst();
                        list.add(currentNode.val);
                        if(currentNode.left != null){
                        queue.addLast(currentNode.left);
                        }
                        if(currentNode.right != null){
                        queue.addLast(currentNode.right);
                        }
                    }else {
                        TreeNode currentNode = queue.pollLast();
                        list.add(currentNode.val);
                        if (currentNode.right != null) {
                            queue.addFirst(currentNode.right);
                        }
                        if (currentNode.left != null) {
                            queue.addFirst(currentNode.left);
                        }
                    }
                }
                reverse = !reverse;
                result.add(list);
            }
            return result;
        }
    }
}

