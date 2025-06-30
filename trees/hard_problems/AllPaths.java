package trees.hard_problems;
//all paths from root to leaf nodes in a binary tree

import java.util.ArrayList;

public class AllPaths {

    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        preDfs(root, new ArrayList<>(), res);
        return res;
    }

    private static void preDfs(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        preDfs(root.left, path, res);
        preDfs(root.right, path, res);
        path.remove(path.size() - 1);
    }
}
