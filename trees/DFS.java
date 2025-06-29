package trees;

import java.util.Stack;

public class DFS {
    //Tree Structure
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

    //DFS using stack
    //Preorder
    public void dfsStack(TreeNode node){
        if (node == null){
            return;
        }

        //to track the visited node - we use stack (top to bottom)
        Stack<TreeNode> stack = new Stack<>();
        //step 1 : push node in stack
        stack.push(node);

        while (!stack.isEmpty()){
            //step 2 : remove the last added node from stack and print its value
            TreeNode removed = stack.pop();
            System.out.println(removed.val + ",");

            //step 3 : add the right and left child of the removed node to the stack (if exist) --- right is added first because its preorder
            if (removed.right != null){
                stack.push(removed.right);
            }
            if (removed.left != null){
                stack.push(removed.left);
            }
        }
    }
}
