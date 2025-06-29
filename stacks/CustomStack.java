package stacks;


public class CustomStack {
    protected int[] data;
    private static final int default_size = 10;
    int top = -1;

    public CustomStack(){              //default size stack constructor
        this(default_size);
    }

    public CustomStack(int size) {     //desired size stack constructor
        this.data = new int[size];
    }

    private boolean isFull(){
        return top == data.length - 1;   //ptr is at last index
    }

    private boolean isEmpty(){
        return top == -1;
    }

    public void push(int item){
        if (isFull()){
            System.out.println("Stack is full!!");
        }
        data[++top] = item;  //means top = top + 1 ---->>>> data[top] = item
    }

    public int pop(){
        return data[top--];  //means return data[top] ---->>>> top = top - 1
    }

    public int peek() throws Exception {
        if (isEmpty()){
            throw new Exception("Empty stack!!");
        }
        return data[top];
    }

//    public void display() {
//        if (isEmpty()){
//            System.out.println("stack is empty!!");
//        }
//        do{
//            System.out.print(data[top] + " ");
//            top--;
//        }while (!isEmpty());
//        System.out.println();
//    }

    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
