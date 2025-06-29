package trees;

import java.util.Arrays;

public class BST {
    // Node structure
    public class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    // BST structure
    public Node root;
    public BST() {
        this.root = null;
    }

    // INSERTION
    public void insert(int value) {
        root = insertion(value, root);
    }
    private Node insertion(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertion(value, node.left);
        }
        else if (value > node.value) {
            node.right = insertion(value, node.right);
        }
        return node;
    }

    // DELETION
    public void delete(int value) {
        root = deletion(root, value);
        System.out.println("\ndeleted node " + value);
    }
    private Node deletion(Node node, int value) {
        if (node == null) {
            return node;
        }
        if (value < node.value) {
            node.left = deletion(node.left, value);
        }
        else if (value > node.value) {
            node.right = deletion(node.right, value);
        }
        else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            node.value = minValue(node.right);

            // Delete the inorder successor
            node.right = deletion(node.right, node.value);
        }
        return node;
    }

    //creating a BST From an array
    //logic: sort the array, apply binary search and recursively add middle element to tree
    public void populatedSorted(int[] nums){
        populatedSorted(nums, 0, nums.length);
    }
    private void populatedSorted(int[] nums, int s, int e) {
        if (s >= e) return;
        int mid = (s + e) / 2;
        this.insert(nums[mid]);              //add mid
        populatedSorted(nums, s, mid);      //perform again on left side of mid
        populatedSorted(nums, mid+1, e);  //perform again on right side of mid
    }

    // minvalue
    private int minValue(Node node) {
        int minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    // Traversal
    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }
    private void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value + " ");
        }
    }
    public void display() {
        System.out.println("In-order Traversal:");
        inOrder(root);
        System.out.println("\nPre-order Traversal:");
        preOrder(root);
        System.out.println("\nPost-order Traversal:");
        postOrder(root);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(35);
        tree.insert(20);
        tree.insert(70);
        tree.insert(10);
        tree.insert(30);
        tree.insert(50);
        tree.insert(90);
        System.out.println("BST before deletion:");
        tree.display();
        tree.delete(20);
        System.out.println("\nBST after deletion of 20:");
        tree.display();
        System.out.println();

        //creating BST from simple array
        BST tree2 = new BST();
        int[] nums = {1,3,2,5,4,9,8,7,6};
        Arrays.sort(nums);
        tree2.populatedSorted(nums);
        tree2.display();
    }
}
