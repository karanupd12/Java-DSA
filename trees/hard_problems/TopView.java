package trees.hard_problems;

import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Pair{
    Node node;
    int hd;
    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

public class TopView{
    static ArrayList<Integer> topView(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;
            if(!map.containsKey(hd)) map.put(hd, node.data);
            if(node.left != null) q.add(new Pair(node.left, hd-1));
            if(node.right != null) q.add(new Pair(node.right, hd+1));
        }
        
        return new ArrayList<>(map.values());
        
    }
}