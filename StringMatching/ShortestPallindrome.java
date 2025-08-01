package StringMatching;

/*
important question - https://leetcode.com/problems/shortest-palindrome/description/
Approach :- KMP - LPS array

s       = abcd
rev(s)  = dcba
combined= abcd#dcba (add # to avoid overlapping)
LPS end = 1  (only 'a' matches)
leftover= bcd → reverse = dcb (this is the suffix that we need to make our string palindrome)
result  = dcbabcd


*/
public class ShortestPallindrome {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = computeLPS(combined);
        int len = lps[lps.length-1];

        String suffix = s.substring(len);
        String palindrome = new StringBuilder(suffix).reverse().toString() + s;
        return palindrome;
    }

    private int[] computeLPS(String str){
        int[] lps = new int[str.length()];
        int i = 1, j = 0;
        while(i < str.length()){
            if(str.charAt(i) == str.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }else{
                if(j != 0) j = lps[j-1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }
}
