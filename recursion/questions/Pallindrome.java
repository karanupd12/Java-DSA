package recursion.questions;

public class Pallindrome {
    public static void main(String[] args) {
        System.out.println(ispalin(12321));
    }

    // sometimes we need some additional variables in the argument
    // in that case, make another function

    static int rev(int n) {
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) (Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }

    public static boolean ispalin(int n) {
        return n == rev(n);
    }
}