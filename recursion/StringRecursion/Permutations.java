package recursion.StringRecursion;

import java.util.ArrayList;
import java.util.List;

//Permutations - subsets
public class Permutations {

     public static void permut(String str, int l , int r, List<String> subsets){
         if(l == r){
             subsets.add(str);
             return;
         }
         for(int i = l; i <= r; i++){
             str = swap(str, l, i);
             permut(str, l+1, r, subsets);
             str = swap(str, l, i);  //backtrack - optional as we are returning new string after each iteration
         }
     }

     public static String swap(String str, int idx1, int idx2){
         char[] arr = str.toCharArray();
         char temp = arr[idx1];
         arr[idx1] = arr[idx2];
         arr[idx2] = temp;
         return new String(arr);
     }

    public static void main(String[] args) {
        String str = "abc";
        List<String> list = new ArrayList<>();
        permut(str, 0, str.length()-1, list);
        System.out.println(list);
    }
}
