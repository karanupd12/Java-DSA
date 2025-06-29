package recursion.StringRecursion;

public class Pallindrome {

    static boolean ispalindrome(String str, int s, int e){
        if(s >= e) return true;
        if(str.charAt(s) != str.charAt(e)) return false;
        return ispalindrome(str, s+1, e-1);
    }

    public static void main(String[] args) {
        String str1 = "racecar";
        System.out.println(ispalindrome(str1, 0, str1.length()-1));

        String str2 = "racemycar";
        System.out.println(ispalindrome(str2, 0, str2.length()-1));
    }
}
