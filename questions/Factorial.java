package questions;
import java.util.Scanner;

public class Factorial {
    public static int fact(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * fact(num - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number=");
        int num = sc.nextInt();
        System.out.print("factorial of " + num + " is " + fact(num));
    }
}
