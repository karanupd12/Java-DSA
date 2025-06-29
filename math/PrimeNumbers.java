package math;

import java.util.Arrays;

public class PrimeNumbers {
    //function to calculate is a number is prime : check only upto its sqrt
    public static boolean isPrime(int num){
        if(num <= 1) return false;
        for(int c = 2; c <= Math.sqrt(num); c++){
            if(num % c == 0) return false;
        }
        return true;
    }

    //function to find all prime number less than 'n' - sieve eratosthenesis
    // false - prime, true - prime
    public static void sieve(int n , boolean[] primes){
        for(int i = 2; i*i <= n; i++){
            if(!primes[i]){
                for(int j = i*2; j <= n; j+=i){
                    primes[j] = true;
                }
            }
        }
        for(int i = 2; i <= n; i++){
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("is prime : "+ isPrime(11));

        int n = 40;
        boolean[] primes = new boolean[n+1];
        sieve(40, primes);
    }
}
