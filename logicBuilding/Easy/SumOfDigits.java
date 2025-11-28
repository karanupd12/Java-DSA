package logicBuilding.Easy;

public class SumOfDigits {

    // [Approach 1] Digit Extraction - O(log10n) Time and O(1) Space
    private static int sum1(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // [Approach 2] String Conversion - O(d) Time and O(d) Space,  d ≈ log₁₀(n) (count of digits)
    private static int sum2(int n){
        String str = Integer.toString(n);
        int sum = 0;
        for(char ch : str.toCharArray()){
            sum += ch - '0';
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 687;
        System.out.println(sum1(n));
        System.out.println(sum2(n));
    }
}
