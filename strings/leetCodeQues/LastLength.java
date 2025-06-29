//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.

package strings.leetCodeQues;

public class LastLength {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        int n = str.length;
        return str[n-1].length();
    }
}
