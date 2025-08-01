package StringMatching;
import java.util.*;

/*
Approach : compute hash of pattern and then slide through text to find same hash, if has found and matched, return that index
>> to avoid spurious hits, use a good hash function
>> to avoid recomputing hash, perform rolling hash
*/
public class RabinKarp {
    public int PRIME = 101;
    public int BASE = 256;
    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = text.length(), m = pattern.length();
        long patternHash = computeHash(pattern, m);
        long textHash = computeHash(text, m);

        long power = 1;
        for(int i = 0; i < m-1; i++){
            power = (power * BASE) % PRIME;
        }

        for(int i = 0; i <= n-m; i++){
            if(patternHash == textHash && text.substring(i, i+m).equals(pattern)){
                ans.add(i);
            }

            if(i < n-m){
                textHash = ((textHash-text.charAt(i) * power) * BASE + text.charAt(i+m)) % PRIME;
                if(textHash < 0) textHash += PRIME;
            }
        }

        return ans;
    }

    private long computeHash(String str, int m){
        long hash = 0;
        for(int i = 0; i < m; i++){
            hash = (hash * BASE + str.charAt(i)) % PRIME;
        }
        return hash;
    }
}
