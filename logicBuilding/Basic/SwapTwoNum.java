package logicBuilding.Basic;

import java.util.Scanner;

public class SwapTwoNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num1 : ");
        int a = sc.nextInt();

        System.out.print("Enter num2 : ");
        int b = sc.nextInt();

        //method 1 : extra variable
        int temp = a;
        a = b;
        b = temp;
        System.out.println("num1 is " + a + " & num2 is " + b);

        //method 2 : using bit manipulation(faster and more efficient)
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("num1 is " + a + " & num2 is " + b);
    }
}
