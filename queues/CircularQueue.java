package queues;

public class CircularQueue {
    protected int[] data;
    private static final int default_size = 10;
    protected int front = 0;
    protected int end = 0;
    protected int size = 0;


    public CircularQueue(){
        this(default_size);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    private boolean isFull(){
        return size == data.length;   //ptr is at last index
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int item){
        if (isFull()){
            System.out.println("queue is full!!");
        }
        data[end++] = item;   // means, data[end] = item  ----->>>>> end = end + 1
        end = end % data.length;
        size++;
    }

    public int dequeue() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty!!");
        }
        int removed = data[front++];
        front %= data.length;
        size--;
        return removed;
    }

    public int front() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty!!");
        }
        return data[front];
    }

    public void display() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty!!");
        }
        int i = front;
        do{
            System.out.print(data[i] + " <- ");
            i++;
            i %= data.length;
        }while(i != end);
        System.out.println("end");
    }

    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();


        System.out.println(queue.dequeue());    //10
        System.out.println(queue.dequeue());    //20
        queue.enqueue(90);
        queue.display();
    }
}


