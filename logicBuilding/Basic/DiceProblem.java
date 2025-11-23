package logicBuilding.Basic;

/*
You are given a cubic dice with 6 faces. All the individual faces have a number printed on them. The numbers are in the range of 1 to 6, like any ordinary dice. You will be provided with a face of this cube, your task is to guess the number on the opposite face of the cube.
*/


import java.util.Scanner;

public class DiceProblem {

    //Brute Force : All possible cases : O(1) Time and O(1) Space
    private static int find1(int n){
        if(n == 1) return 6;
        else if (n == 6) return 1;
        else if(n == 3) return 4;
        else if(n == 4) return 3;
        else if(n == 2) return 5;
        else return 2;
    }

    //Using Sum of Two Sides : O(1) Time and O(1) Space
    private static int find2(int n){
        return Math.abs(7 - n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 0 || n > 6) System.out.println("wrong number");
        else System.out.println(find2(n));
    }
}
