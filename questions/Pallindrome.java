package questions;

public class Pallindrome {
    class Solution {
        public boolean isPalindrome(int x) {
            int temp = x;
            int reverse = 0;
            while (x > 0){
                int rem = x % 10;
                x /= 10;
                reverse = reverse * 10 + rem;
            }
            return reverse == temp;
        }
    }
}
