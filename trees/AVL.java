package trees;

import static java.lang.Math.max;

public class AVL {
    public class Node {
        public int value;
        public Node left;
        public Node right;
        public int height;
        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;
    public AVL() {}

    // INSERTION
    public void insertion(int value) {
        root = insert(value, root);
    }
    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }if (value < node.value) {
            node.left = insert(value, node.left);
        }else if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = max(height(node.left), height(node.right) + 1);
        return rotate(node);
    }

    //height of a node
    public int height(){
        return height(root);
    }
    public int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    //Balance checking
    public boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }



    //ROTATION CASES [+ve BF (LL,LR) and -ve BF (RR, RL)]
    private Node rotate(Node node) {
        //+ve BF so left heavy : i.e; it can be LL or LR
        if (height(node.left) - height(node.right) > 1) {
            // Left-Left case
            if (height(node.left.left) - height(node.left.right) > 0){
                return rightRotate(node);
            }
            // Left-Right Case
            if (height(node.left.left) - height(node.left.right) < 0){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        //-ve BF so right heavy : i.e; it can be RR or RL
        if (height(node.left) - height(node.right) < -1) {
            // Right-Right case
            if (height(node.right.left) - height(node.right.right) < 0){
                return leftRotate(node);
            }
            // Right-Left Case
            if (height(node.right.left) - height(node.right.right) > 0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    //ROTATION
    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = max(height(p.left), height(p.right) + 1);
        c.height = max(height(c.left), height(c.right) + 1);
        return c;
    }
    public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = max(height(p.left), height(p.right) + 1);
        c.height = max(height(c.left), height(c.right) + 1);
        return p;
    }



    // DISPLAY
    public void display() {
        display(this.root, "Root Node: ");
    }
    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        for(int i=0; i <100; i++) {
            tree.insertion(i);
        }
        System.out.println(tree.height());
    }
}

