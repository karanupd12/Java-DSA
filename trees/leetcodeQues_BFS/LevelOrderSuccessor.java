// print the the element next to the given element appearing in level order (BFS)
package trees.leetcodeQues_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
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
        public TreeNode successorNode(TreeNode root, int key) {
            if(root == null) {
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int successor;

            while(!queue.isEmpty()) {
                int n = queue.size();
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }if (currentNode.val == key){
                    break;
                }
            }
            return queue.peek();
        }
    }
}