package logicBuilding.Basic;

import java.util.Scanner;

public class NthTermAP {

    //brute force : O(n) Time and O(1) Space
    private static int nthTermOfAP(int a1, int a2, int n){
        int nthTerm = a1, d = a2 - a1;
        for (int i = 1; i < n; i++) {
            nthTerm += d;
        }
        return nthTerm;
    }

    //Formula based : O(1) Time and O(1) Space
    private static int find(int a1, int a2, int n){
        int d = a2 - a1;
        int nthTerm = a1 + (n - 1) * d;
        return nthTerm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first term : ");
        int a1 = sc.nextInt();
        System.out.print("Enter sec term : ");
        int a2 = sc.nextInt();

        System.out.print("Enter the term you need : ");
        int n = sc.nextInt();
        System.out.println(n + "th term of AP is " + find(a1, a2, n));

    }
}
