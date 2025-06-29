package queues;
//we have builtin Queue interface in java collection framework - implemented using linked-list in java
//queue follows FIFO

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InBuiltQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue);           // [10, 20, 30, 40, 50]
        System.out.println(queue.peek());    // gives the head of the queue //10
        System.out.println(queue.remove());  // 10 (FIFO)
        System.out.println(queue.remove());  // 20
        System.out.println(queue);           // [30, 40, 50]


        //we also have builtin Deque interface in java collection framework - implemented using ArrayDeque in java
        //Deque (Deck) is a queue which allow the enque and deque at both of its ends

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(11);
        deque.addFirst(22);
        deque.addFirst(33);
        deque.addFirst(44);
        deque.addLast(55);
        deque.addLast(66);
        deque.addLast(77);
        System.out.println(deque);  // [44, 33, 22, 11, 55, 66, 77]
        System.out.println(deque.removeFirst()); // 44
        System.out.println(deque.removeLast());  // 77
        System.out.println(deque);  // [33, 22, 11, 55, 66]
    }
}
