package logicBuilding.Easy;

import oops.interfaces.static_interface.A;

public class LCM {
    private static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    private static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.println(lcm(12, 18));
        System.out.println(lcm(5, 11));
    }
}
