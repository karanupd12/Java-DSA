package trees.hard_problems;

import java.util.*;

/* Approach :
 - Postorder's last element is the root — start from the end and move backward.
 - Use a HashMap to get index of any element in inorder in O(1), dividing the tree into left and right subtrees.
 - Recursively build the right subtree first (since postorder is Left–Right–Root and we're going in reverse), then the left.
 */


public class BuildTree2 {
    int p; // Postorder tracker
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p = postorder.length-1;
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return construct(postorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = postorder[p--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderMap.get(rootVal);

        root.right = construct(postorder, inIndex + 1, inEnd);
        root.left = construct(postorder, inStart, inIndex - 1);

        return root;
    }
}
