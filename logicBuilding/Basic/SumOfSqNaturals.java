package logicBuilding.Basic;
import java.util.Scanner;

public class SumOfSqNaturals {

    //Brute Force : O(n) Time and O(1) Space
    private static int findSum1(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += (i*i);
        }
        return sum;
    }

    //Formula Based : O(1) Time and O(1) Space (can cause overflow)
    private static int findSum2(int n){
        int sum = (n*(n+1)*(2*n+1))/6;
        return sum;
    }

    //to avoid overflow : n*(n+1)*(2*n+1)/6 = (n*(n+1)/2) * (2*n+1)/3
    private static int findSum3(int n){
        int sum = (n*(n+1)/2) * (2*n+1)/3;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findSum1(n));
        System.out.println(findSum2(n));
        System.out.println(findSum3(n));
    }
}
