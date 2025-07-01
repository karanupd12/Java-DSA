package trees.hard_problems;

import java.util.*;

/*Approach -
 - Map each value in inorder to its index for fast lookup.
 - Pick the current root from preorder using a pointer p. (left of pre will always be on left side of root in inorder)
 - Use the root’s index in inorder to split into left (start to index-1) and right (index+1 to end) subtrees, and build them recursively.
 */


class BuildTree1 {
    private int p = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;

        int rootVal = preorder[p++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderMap.get(root.val);

        root.left = helper(preorder, inStart, inIndex-1);
        root.right = helper(preorder, inIndex+1, inEnd);
        return root;
    }
}
