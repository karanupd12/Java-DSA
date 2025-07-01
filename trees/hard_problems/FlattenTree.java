package trees.hard_problems;

import java.util.Stack;

// Flatten a binary tree to a linked list in-place - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

/*
 Traverse the tree in reverse preorder (right → left → root) using recursion.
At each step, set node.right = prev and node.left = null to flatten in-place.
Move the prev pointer up the chain to construct the linked list bottom-up.
*/

public class FlattenTree {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }


    //Iterative approach

    public void flatten2(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }

}
