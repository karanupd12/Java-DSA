package trees;

public class SegmentTree {

    //Node structure
    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    //Segment Tree Structure
    Node root;
    public SegmentTree(int[] arr){
        this.root = constructTree(arr, 0, arr.length-1);
    }

    //creating Segment Tree
    private Node constructTree(int[] arr, int start, int end) {
        //base case - we reached leaf node
        if (start == end){
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        //create new node with index you are at
        Node node = new Node(start, end);
        int mid = (start + end)/2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid+1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    //query (we have done addition between two entered intervals by user)
    public int query(int qsi, int qei){
        return this.query(this.root, qsi, qei);
    }
    private int query(Node node, int qsi, int qei){
        // node is completely inside query
        if (node.startInterval >= qsi && node.endInterval <= qei){
            return node.data;
        }
        // node is completely outside query
        else if (node.startInterval > qei || node.endInterval < qsi){
            return 0;
        }
        //overlapping so, update
        else{
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    //updation - in O(log N) time
    public void update(int index, int value){
        this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            }
            else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

    // performing addition query on interval[2, 6] in O(logN) time
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.query(1, 6));
    }

}
