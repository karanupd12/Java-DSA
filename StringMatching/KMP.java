package StringMatching;
import java.util.*;

/*
Problem - https://www.geeksforgeeks.org/problems/search-pattern0205/1
Approach -
1. Make LPS array – For the pattern, precompute the longest proper prefix which is also a suffix for each position.
2. Compare characters – Match pattern with text one by one.
3. If match continues – Move both text and pattern pointers forward.
4. If full pattern matched – Record the index and use LPS to skip unnecessary comparisons.

If mismatch happens – Use LPS to jump the pattern pointer back instead of starting from zero.
*/


public class KMP {
    public static ArrayList<Integer> search(String txt, String pat) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = txt.length(), m = pat.length();
        int[] lps = computeLPS(pat, m);

        int i = 0, j = 0;
        while(i < n){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }

            if(j == m){
                res.add(i-j);
                j = lps[j-1];
            }
            else if(i < n && txt.charAt(i) != pat.charAt(j)){
                if(j != 0) j = lps[j-1];
                else i++;
            }
        }

        return res;
    }

    private static int[] computeLPS(String pattern, int m){
        int[] lps = new int[m];
        int i = 1, j = 0;
        while(i < m){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }else{
                if(j != 0) j = lps[j-1];
                else i++;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(search("abcinnnabcfininabc", "abc"));
    }
}
