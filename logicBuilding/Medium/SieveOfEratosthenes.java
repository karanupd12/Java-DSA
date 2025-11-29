package logicBuilding.Medium;

import java.util.Arrays;

/*

The Sieve of Eratosthenes : efficiently finds all primes up to n by repeatedly marking multiples of each prime as non-prime,
starting from 2. This avoids redundant checks and quickly filters out all composite numbers.

Time Complexity: O(n*log(log(n))). For each prime number, we mark its multiples, which takes around n/p steps.
The total time is proportional to n*(1/2 + 1/3 + 1/5 + ....).
This sum over primes grows slowly and is approximately O(n*log(log(n))) making the algorithm very efficient.
Auxiliary Space: O(n)

*/
class SieveOfEratosthenes {
    public static  int[] sieve(int n) {
        if(n < 2) return new int[]{};

        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        //make multiples of prime as prime
        for(int p = 2; p * p <= n; p++){
            if(isPrime[p]){
                for(int i = p * p; i <= n; i += p){
                    isPrime[i] = false;
                }
            }
        }

        // Count number of primes
        int count = 0;
        for (int p = 2; p <= n; p++) {
            if (isPrime[p])
                count++;
        }

        // Store primes in an array
        int[] primes = new int[count];
        int idx = 0;
        for (int p = 2; p <= n; p++) {
            if (isPrime[p])
                primes[idx++] = p;
        }

        return primes;
    }

    public static void main(String[] args) {
        int n = 35;
        System.out.println(Arrays.toString(sieve(n)));
    }
}

