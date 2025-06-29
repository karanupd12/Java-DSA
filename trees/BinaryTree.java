package trees;
import java.util.Scanner;

public class BinaryTree {

    public BinaryTree(){
    }
    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    //insertion
    public void populate(Scanner scanner){
        System.out.println("Enter the root node : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }
    private void populate(Scanner scanner, Node node) {

        System.out.println("Do you want to enter the left node : ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("enter the value of left of "+ node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter the right node : ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("enter the value of right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display(Node node, String indent){
        if (node == null){ return;}
        System.out.println( indent + node.value);
        display(node.left,  "\t");
        display(node.right, "\t");
    }

    public void display(){
        display(root, " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
    }
}
