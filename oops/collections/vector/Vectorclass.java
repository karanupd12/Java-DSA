package oops.collections.vector;

//Java Program to Demonstrate Working of Vector
// Via Creating and Using It
import java.util.*;

class Vectorclass {

    public static void main(String[] args)
    {
        // Size of the Vector
        int n = 5;

        // Declaring the Vector with initial size n
        Vector<Integer> v = new Vector<>(n);

        // Appending new elements at the end of the vector
        for (int i = 1; i <= n; i++)
            v.add(i);

        System.out.println(v);     // [1, 2, 3, 4, 5]

        v.remove(3);        // Remove element at index 3
        System.out.println(v);      // [1, 2, 3, 5]

        for (int i = 0; i < v.size(); i++)            // iterating over vector elements
            System.out.print(v.get(i) + " ");         // 1 2 3 5
    }
}
