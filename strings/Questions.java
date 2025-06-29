//program for finding whether the string is pallindrome or not.

package strings;

public class Questions {
    public static void main(String[] args) {

        String str1 = "Karan";
        System.out.println(ispallindrome(str1)); // false

        String str2 = "Nitin";
        System.out.println(ispallindrome(str2)); // true
    }

    public static boolean ispallindrome(String str) {

        if (str.length() == 0 || str == null) {
            return true;
        }

        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            int start = str.charAt(i);
            int end = str.charAt(str.length() - i - 1);

            if (start != end) {
                return false;
            }
        }
        return true;
    }
}
