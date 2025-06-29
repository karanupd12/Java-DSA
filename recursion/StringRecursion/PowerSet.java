package recursion.StringRecursion;

//powerset - all subsequences of a given string

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void powerSet(String str, int i, String cur, List<String> subSeq){
        if(i == str.length()){
            subSeq.add(cur);
            return;
        }
        powerSet(str, i+1,cur+str.charAt(i), subSeq);
        powerSet(str, i+1, cur, subSeq);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "abc";
        powerSet(str, 0, " ", list);
        System.out.println(list);
    }
}
