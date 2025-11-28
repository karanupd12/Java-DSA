package logicBuilding.Easy;

public class GCD {
    private static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 18));
        System.out.println(gcd(24, 32));
    }
}
