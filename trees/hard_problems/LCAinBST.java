package trees.hard_problems;


// Lowest Common Ancestor in a Binary Search Tree (BST) - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
/*
Approach - in inorder traversal of BST, the left subtree is smaller than the root and the right subtree is larger, when
we find the first node that is greater than p & less than q, we can return it as the LCA.

In BST we can avoid recursion by using the properties of BST, this optimizes the search to O(h) time complexity,
where h is the height of the tree by avoiding unnecessary traversals.
*/


public class LCAinBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        while(root != null){
            if (root.val < min) root = root.right;
            else if (root.val > max) root = root.left;
            else return root;
        }

        return null;
    }
}


/*
Recursive approach:

    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
        return res;
    }

    private void dfs(TreeNode root, int p, int q){
        if(root == null || res != null) return;
        dfs(root.left, p, q);
        if(p <= root.val && root.val <= q) {
            res = root;
            return;
        }
        dfs(root.right, p, q);
    }

*/
