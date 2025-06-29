package recursion.questions;

public class Reverse {
    public static void main(String[] args) {
        rev(23456);
        System.out.println(reverse);
    }

    static int reverse = 0;

    static void rev(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        reverse = reverse * 10 + rem;
        rev(n / 10);
    }
}
