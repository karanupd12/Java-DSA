
// program to demonstrate compile-time polymorphism

package oops.properties.polymorphism.types;

public class CompileTimePolymorphism {
        // First addition function
        public static int add(int a, int b) {
            return a + b;
        }

        // Second addition function
        public static double add(double a, double b) {
            return a + b;
        }

        // Driver code
        public static void main(String args[]) {
            // Here, the first addition
            // function is called
            System.out.println(add(2, 3));                //5

            // Here, the second addition
            // function is called
            System.out.println(add(2.0, 3.0));            //5.0
        }
}
