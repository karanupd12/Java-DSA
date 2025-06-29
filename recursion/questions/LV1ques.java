package recursion.questions;

public class LV1ques {
    public static void main(String[] args) {

        nums1(5); // 54321
        System.out.println();

        nums2(5); // 12345
        System.out.println();

        System.out.println(fact(5)); // 120

        System.out.println(sumofdig(365)); // 3+6+5 = 14

        System.out.println(count0in(2040850, 0)); // 3

        System.out.println(againcount0in(102030405)); // 4

        System.out.println(numofsteps(14)); //6 steps i.e;(14>>7 , 7>>6 , 6>>3 , 3>>2 , 2>>1 , 1>>0)

    }


    // Q-1 : for printing nums 5-1
    static void nums1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n);
        nums1(n - 1);
    }



    // Q-2 : for printing nums 1-5
    static void nums2(int n) {
        if (n == 0) {
            return;
        }
        nums2(n - 1);
        System.out.print(n);
    }



    // Q-3 : Factorial of 5
    static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }



    // Q-4 : sum of digits in given number
    static int sumofdig(int n) {
        if (n == 0) {
            return 0;
        }
        return (sumofdig(n / 10) + n % 10);
    }



    // Q-5 : count total 0s in number
    // method 1 - by giving count in argument
    static int count0in(int num, int c) {
        if (num == 0) {
            return c;
        }
        if (num % 10 == 0) {
            return count0in(num / 10, c + 1);
        }
        return count0in(num / 10, c);
    }

    // method 2 - by creating a helper function //good method
    static int againcount0in(int num) {
        return helper(num, 0);
    }

    static int helper(int num, int c) {
        if (num == 0) {
            return c;
        }
        if (num % 10 == 0) {
            return helper(num / 10, c + 1);
        }
        return helper(num / 10, c);
    }



    // Q-6 : find the total no. of steps to reduce a num to 0              
    //if num is even then reduce it by half, if odd then -1 and make it even,eventually after some steps, num will become 0 

    static int numofsteps(int num) {
        return helper2(num, 0);
    }

    static int helper2(int num, int steps) {
        if (num == 0) {
            return steps;
        }

        if (num % 2 == 0) {
            return helper2(num / 2, steps + 1);
        }
        return helper2(num - 1, steps + 1);
    }
}