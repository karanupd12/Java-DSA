package trees.hard_problems;

import java.util.*;
import trees.hard_problems.TreeNode;

class Pair{
    TreeNode node;
    int hd;
    Pair(TreeNode node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

public class TopView{
    static ArrayList<Integer> topView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;
            if(!map.containsKey(hd)) map.put(hd, node.val);
            if(node.left != null) q.add(new Pair(node.left, hd-1));
            if(node.right != null) q.add(new Pair(node.right, hd+1));
        }
        
        return new ArrayList<>(map.values());
        
    }
}