package questions;
import java.util.Scanner;
public class Prime_Armstrong {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("enter a number=");
        int n=sc.nextInt();
        System.out.println(isPrime(n));  //print true if n is prime & false if n is not prime
        System.out.println(isArms(n));
    }

    static boolean isPrime(int n){
        if (n<=1){
            return false;
        }
        int c=2;
        while (c*c<=n){     //instead of using loop till n , will will check only upto its square root to save time complexity
            if (n%c==0){
                return false;
            }
            c++;
        }
        return c*c>n;      
    }

    static boolean isArms(int n){      //for armstrong condition, first find reverse and then compare with orignal
        int orignal = n;
        int rev = 0;

        while ( n>0 ){
            int rem = n % 10;
            n /= 10;
            rev = rev * 10 + rem;
        }

        if (rev == orignal){
            return true;
        }
        else {return false;}
    }
}
