package stacks;
//we have a builtin Stack class in java collection framework
//stack follows LIFO
//internally stack is stored as an array
import java.util.Stack;

public class InBuiltStack {
    public static void main(String[] args) {
        Stack<Integer> stack= new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println(stack);           //[10, 20, 30, 40, 50]
        System.out.println(stack.empty());   //false
        System.out.println(stack.peek());    //gives the top of stack element //50
        System.out.println(stack.pop());     //50 (LIFO)
        System.out.println(stack.pop());     //40
        System.out.println(stack);           //[10, 20, 30]
    }
}
