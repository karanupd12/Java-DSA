//ex : input = [1, 2, 3]
//     output = [1, 2, 4]

//ex : input = [9]
//     output = [1, 0]

package arrays.LeetCodeQues;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Increment the last digit
        digits[n - 1]++;

        // Handle carry
        for (int i = n - 1; i > 0 && digits[i] == 10; i--) {
            digits[i] = 0;
            digits[i - 1]++;
        }

        // Check if there is a carry in the leftmost digit
        if (digits[0] == 10) {
            // Create a new array with one additional digit
            int[] result = new int[n + 1];
            result[0] = 1;
            return result;
        }

        return digits;
    }

}