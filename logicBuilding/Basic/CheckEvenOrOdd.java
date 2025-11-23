package logicBuilding.Basic;

import java.util.Scanner;

public class CheckEvenOrOdd {

    //brute force
    private static void check1(int num){
        if(num % 2 == 0) System.out.println("Even");
        else System.out.println("odd");
    }

    //bit operation: extremely fast and efficient
    private static void check2(int num) {
        if((num & 1) == 0) System.out.println("Even");
        else System.out.println("odd");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        check1(num);
        check2(num);
    }
}
