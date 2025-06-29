package oops;

import java.util.ArrayList;

public class LambdaFunctions {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i + 1);
        }

        //lambda functions are inline functions - which can be written in one line
        //syntax - parameter part -> body of the function    >>>this is how a lambda expression looks like
        arr.forEach((item) -> System.out.print(item * 2));  //lambda function to multiply each item of array by 2

        Operation sum = (a, b) -> a + b;
        Operation product = (a, b) -> a * b;
        Operation div = (a, b) -> a / b;
        Operation sub = (a, b) -> a - b;

        System.out.println();

        LambdaFunctions mycalculator = new LambdaFunctions();
        System.out.println(mycalculator.operate(5, 3, sum));
        System.out.println(mycalculator.operate(5, 3, product));
        System.out.println(mycalculator.operate(5, 3, sub));
        System.out.println(mycalculator.operate(5, 3, div));

    }

    private int operate(int a, int b, Operation op) {
        return op.operation(a, b);
    }

}
interface Operation{
    int operation(int a , int b);
}
