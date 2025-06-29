// LeetCode [medium] ques : given the root of a binary tree, return the level order traversal(i.e; l-->r, level by level)
// ex: input : root = [3, 9, 20, null, null, 15, 7]
//     output : [ [3], [9, 20], [15, 7] ]

package trees.leetcodeQues_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if(root == null) {
                return result;
            }

            Queue<TreeNode> q=new LinkedList<>();
            q.offer(root);

            while(!q.isEmpty()) {
                List<Integer> levelList = new LinkedList<>();
                int n=q.size();

                for(int i=0;i<n;i++) {
                    TreeNode currentNode = q.poll();
                    levelList.add(currentNode.val);
                    if(currentNode.left != null)
                        q.offer(currentNode.left);
                    if(currentNode.right != null)
                        q.offer(currentNode.right);
                }
                result.add(levelList);
            }
            return result;
        }
    }
}
