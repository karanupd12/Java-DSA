package logicBuilding.Basic;
import java.util.Scanner;

public class SumOfNaturals {
    //brute force : O(n) Time and O(1) Space
    private static int findSum1(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    //formula based : O(1) Time and O(1) Space
    private static int findSum2(int n){
        return (n * (n+1))/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(findSum1(num));
        System.out.println(findSum2(num));
    }
}
