package logicBuilding.Easy;

import javax.swing.*;

public class ReverseDigits {

    //Digit by Digit Approach : Time - O(log n), Space- O(1)
    private static int reverse1(int n){
        int rev = 0;
        while(n > 0){
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        return rev;
    }

    //String reverse Approach : Time - O(log n) Space - O(1) -> this handles leading zeroes as well
    private static int reverse2(int n){
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {

        int n = 1234500;
        System.out.println(reverse1(n)); //leading zeroes handled
        System.out.println(reverse2(n)); //leading zeroes handled

    }
}
