//programm using recursion to print fibonacci number at nth position and whole series upto num.

package questions;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number = ");
        int num = sc.nextInt();
        System.out.println("fibonnaci number at " + num + " index is " + fib(num));
        System.out.print("fibonacci series upto " + num + " is ");
        for (int i = 0; i < num; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    static int fib(int num) {
        if (num < 2) {
            return num;
        } else {
            return (fib(num - 1) + fib(num - 2));
        }
    }
}

