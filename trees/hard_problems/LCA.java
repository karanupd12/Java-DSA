package trees.hard_problems;

//Lowest Common Ancestor (LCA) of two nodes in a binary tree
// The LCA of two nodes p and q is defined as the lowest node in the tree that has both p and q as descendants
// (where we allow a node to be a descendant of itself).
// Approach:  we will apply post order dfs - the key is to go left and right, as soon as we see p or q, return
// that node else null will be returned.
// during backtrack, the moment we find a node where both left and right are not null (means we have encountered them) - its our LCA


public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;  //base case

        TreeNode left = lowestCommonAncestor(root.left, p, q);  //search for p or q on the left
        TreeNode right = lowestCommonAncestor(root.right, p, q);   //search for p or q on the right

        if(left == null) return right;            //return right
        else if(right == null) return left;       //return left
        else return root;                         //both left and right are not null, so this node is the LCA
    }

}