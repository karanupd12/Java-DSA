
//programm using recursion to print fibonacci number at nth position and whole series upto num.

package recursion.questions;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number = ");
        int num = sc.nextInt();
        System.out.println("fibonnaci number at " + num + " is " + fib(num));
    }

    static int fib(int num) {
        if (num < 2) {
            return num;
        }
        return (fib(num - 1) + fib(num - 2));
    }
}
