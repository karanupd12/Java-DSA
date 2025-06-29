package oops.collections.vector;

// Java Program to Add Elements in Vector Class
import java.util.*;

public class Vectorclass2 {
    public static void main(String[] args) {

        // Case 1
        // Creating a default vector
        Vector v1 = new Vector();

        // Adding custom elements using add() method
        v1.add(1);
        v1.add(2);
        v1.add("karan");
        v1.add("upadhyay");
        v1.add(3);

        // Printing the vector elements
        System.out.println("Vector v1 is " + v1);             //Vector v1 is [1, 2, karan, upadhyay, 3]

        // Case 2
        // Creating generic vector
        Vector<Integer> v2 = new Vector<Integer>();

        // Adding custom elements using add() method
        v2.add(1);
        v2.add(2);
        v2.add(3);

        // Printing the vector elements to the console
        System.out.println("Vector v2 is " + v2);                   // Vector v2 is [1, 2, 3]
    }
}
