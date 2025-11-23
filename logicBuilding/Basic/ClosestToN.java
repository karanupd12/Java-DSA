package logicBuilding.Basic;

//Find the closes number to n divisible by m
public class ClosestToN {

    //brute force : O(m) Time and O(1) Space
    private static int find1(int n, int m){
        int num1 = n, num2 = n;
        while(num1 > n-m && num2 < n + m){
            if(num1 % m == 0) return num1;
            else if(num2 % m == 0) return num2;
            num1--;
            num2++;
        }
        return n;
    }

    //smart solution (playing with rem) : O(1) Time and O(1) Space
    private static int find2(int n, int m){
        int rem = n % m;
        if(rem == 0) return n;
        if(m - rem < rem) return n + (m-rem);
        else return n - rem;
    }

    //more efficient : O(1) Time and O(1) Space
    private static int find3(int n, int m)  {
        int q = n / m;
        int n1 = m * q;  // 1st possible closest number
        int n2 = (n * m) > 0 ? (m * (q + 1)) : (m * (q - 1));  // 2nd possible closest number

        if (Math.abs(n - n1) < Math.abs(n - n2)) return n1;
        else return n2;
    }

    public static void main(String[] args) {
        int n = 23;
        int m = 5;
        //25 would be ans
        System.out.println(find1(n, m));
        System.out.println(find2(n, m));
        System.out.println(find3(n, m));
    }
}
