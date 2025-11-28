package logicBuilding.Easy;

import java.io.PrintStream;

public class PrimeTesting {

    //Brute Force : Time-O(n), Space-O(1)
    private static boolean isPrime1(int n){
        if(n <= 1) return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    //Optimized : Time-O(√n), Space-O(1)
    private static boolean isPrime2(int n){
        if(n <= 1) return false;
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n1 = 11;
        int n2 = 12;

        System.out.println(isPrime1(n1));
        System.out.println(isPrime1(n2));

        System.out.println();

        System.out.println(isPrime2(n1));
        System.out.println(isPrime2(n2));
    }
}
