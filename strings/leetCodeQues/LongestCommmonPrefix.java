package strings.leetCodeQues;

public class LongestCommmonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String comp = "";
//        int i = 0, j = 0;
//        while (i < strs[0].length() && j < strs[1].length()){
//            if (strs[0].charAt(i) == strs[1].charAt(j)){
//               comp += strs[0].charAt(i);
//            }
//            i++;
//            j++;
//        }
        for (int k = 0; k < strs[0].length(); k++) {
            for (int i = 0; i < strs[k].length(); i++) {
                for (int j = 0; j < strs[k + 1].length(); j++) {
                    if (strs[i].charAt(k) == strs[j].charAt(k+1)) {
                        comp += strs[i].charAt(k);
                    }
                }
            }
        }
        return comp;
    }
}
