package math;
//GCD = greatest common divisor / HCF
//LCM = least common multiple
//LCM(a,b) = a * b / gcd of a and b
public class GCD_LCM {

    private static int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        int a = 8;
        int b = 10;
        System.out.println("GCD : " + gcd(a,b));   //2
        System.out.println("LCM : " + a * b / gcd(a,b));    //40
    }
}
