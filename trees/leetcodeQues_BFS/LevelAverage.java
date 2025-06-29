// LeetCode [easy] ques : Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
// ex: Input: root = [3,9,20,null,null,15,7]
//    Output: [3.00000,14.50000,11.00000]
//Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
//Hence return [3, 14.5, 11].

package trees.leetcodeQues_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverage {
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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();
            if(root == null) {
                return ans;
            }

            Queue<TreeNode> q=new LinkedList<>();
            q.offer(root);

            while(!q.isEmpty()) {
                int n=q.size();
                double avglevel = 0;
                for(int i=0;i<n;i++) {
                    TreeNode currentnode = q.poll();
                    avglevel += currentnode.val;
                    if(currentnode.left != null)
                        q.offer(currentnode.left);
                    if(currentnode.right != null)
                        q.offer(currentnode.right);
                }
                double avg = avglevel/n;
                ans.add(avg);
            }
            return ans;
        }
    }
}
