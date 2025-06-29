package linklist.singly_LL;

public class CustomSLL {

    private Node head;
    private Node tail;
    private int size;

    public CustomSLL() {               //empty constructor for declaring 0 size linked list
        this.size = 0;
    }

    private class Node{
        private int value;       //value constructor
        private Node next;       //next node constructor

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

//now we will do insertion and deletions on singly LL

    //INSERTION

    //insertion at first
    public void insertfirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;

        if(tail == null){
            tail = head;
        }
    }

    //insertion at last
    public void insertlast(int val){
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;

        if (tail == null){
            insertfirst(val);
            return;
        }
    }

    //insertion at desired index
    public void insert(int index, int val){
        if (index == 0){
            insertfirst(val);
        }
        if (index == size){
            insertlast(val);
        }

        Node temp = head;
        for (int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    //DELETION

    //Deleting first element/node
    public int deletefirst(){
        int val = head.value;
        head = head.next;
        size--;
        return val;
    }

    //a function to get a node using index value
    public Node get(int index){
        Node node = head;
        for(int i = 0; i< index; i++){
            node = node.next;
        }
        return node;
    }

    //Deleting last element/node
    public int deletelast(){
        Node secondlast = get(size-2);
        int val = tail.value;
        tail = secondlast;
        tail.next = null;
        return val;
    }

    //Deletion at desired index
    public int delete(int index){
        if (index == 0){
            return deletefirst();
        }
        if (index == size-1){
            return deletelast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }


// wrong way to print ll as we are moving head forward and it changes everytime which changes the structure of the ll which should not be happening
//        while (list.head != null){
//            System.out.println(list.head);
//        }

    //to resolve this we will create a new node temp this takes the value of head and prints it and the keeps on taking the next values
    public void display(){
        if (head == null){
            System.out.println("empty");
        };
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}

