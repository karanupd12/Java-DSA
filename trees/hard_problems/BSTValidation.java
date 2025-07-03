package trees.hard_problems;

/*
Approach - in BST, the inorder traversal gives us the sorted order of the elements, so, we can validate the BST by checking
if the current node's value is greater than the previous node's value in the inorder traversal.
*/

public class BSTValidation {

    boolean isBST = true;
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isBST;
    }

    private void dfs(TreeNode root){
        if(root == null || !isBST) return;
        dfs(root.left);
        if((long)root.val <= pre) isBST = false;
        else pre = root.val;
        dfs(root.right);
    }
}
