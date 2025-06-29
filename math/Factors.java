package math;

public class Factors {

    //Brute force to find factors of num, TC: O(n)
    public static void factors1(int num){
        for(int i = 1; i <= num; i++){
            if(num % i == 0) System.out.print(i + " ");
        }
    }

    //Optimization, TC: O(sqrt(n))
    public static void factors2(int num){
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num % i == 0) {
                if (i == num/i) System.out.println(i + " ");
                else System.out.print(i + " " + num/i + " ");
            }
        }
    }
    public static void main(String[] args) {
        int num = 20;
        factors1(num);
        System.out.println();
        factors2((num));
    }
}
