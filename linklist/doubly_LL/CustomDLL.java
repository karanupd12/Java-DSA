package linklist.doubly_LL;

import linklist.singly_LL.CustomSLL;

public class CustomDLL {

    private class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value) {  //constructor-1 for creating single nodes like temp, for insertion or deletion
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {      // constructor-2
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;

    public void insertfirst(int val){
        Node newnode = new Node(val);
        newnode.next = head;
        newnode.prev = null;
        if (head != null){
            head.prev = newnode;
        }
        head = newnode;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void displayRev(){
        Node temp = head;
        Node last = null; //tail node
        while (temp != null){               //this loop will let us reach the last node
            last = temp;
            temp = temp.next;
        }
        while (last != null){               //moving from end to start printing each node
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("Start");
    }

    public Node get(int val){
        Node node = head;
        while (node != null){
            if (node.value == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insertafter(int after, int val){
        Node temp = get(after);
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        if (node.next != null){
            node.next.prev = node;
        }
    }

}
