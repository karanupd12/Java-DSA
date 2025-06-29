package queues;

public class CustomQueue {
    private int[] data;
    private static final int default_size = 10;
    int end = 0;

    public CustomQueue(){
        this(default_size);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    private boolean isFull(){
        return end == data.length;   //ptr is at last index
    }

    private boolean isEmpty(){
        return end == 0;
    }

    public void enqueue(int item){
        if (isFull()){
            System.out.println("queue is full!!");
        }
        data[end++] = item;   // means, data[end] = item  ----->>>>> end = end + 1
    }

    public int dequeue() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty!!");
        }
        int removed = data[0];
        // shifting the elements to left (index 1 becomes 0, 2 becomes 1,....,end becomes end-1)
        for(int i = 1; i<end; i++){
            data[i-1]= data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty!!");
        }
        return data[0];
    }

    public void display() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty!!");
        }
        for (int i = 0; i<end; i++){
            System.out.print(data[i]+" <- ");
        }
        System.out.print("END");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        System.out.println(queue.front());      //10
        System.out.println(queue.isEmpty());    //false
        System.out.println(queue.isFull());     //true
        System.out.println(queue.dequeue());    //10
        System.out.println(queue.dequeue());    //20
        System.out.println(queue.dequeue());    //30
    }

}
