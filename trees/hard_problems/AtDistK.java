package trees.hard_problems;

import java.util.*;

// At Dist K from Target Node in Binary Tree - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

/*
Approach Overview (Two-Step Strategy)
- Convert the binary tree into an undirected graph using a parent map to allow upward traversal (child → parent).
- Perform BFS from the target node, keeping track of distance until k, and collect all nodes at distance k.
*/
// Time Complexity: O(N) for building the parent map and O(N) for BFS traversal, where N is the number of nodes in the tree.

public class AtDistK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();

        q.offer(target);
        vis.add(target);
        int dist = 0;

        while(!q.isEmpty()){
            if(dist == k) break;
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && vis.add(curr.left)){
                    q.offer(curr.left);
                }
                if(curr.right != null && vis.add(curr.right)){
                    q.offer(curr.right);
                }
                TreeNode parent = parentMap.get(curr);
                if(parent != null && vis.add(parent)){
                    q.offer(parent);
                }
            }
            dist++;
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) res.add(q.poll().val);

        return res;

    }

    private void buildParentMap(TreeNode node , TreeNode parent, Map<TreeNode, TreeNode> map){
        if(node == null) return;
        map.put(node, parent);
        buildParentMap(node.left, node, map);
        buildParentMap(node.right, node, map);
    }
}
