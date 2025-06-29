//These are some methods by which can perform some operations on Strings but remember that strings are immutable so the orignal string object will not change if we perform anything on it , unless we create a new object.

package strings;

import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        String name = new String();
        name = "Karan Upadhyay";

        System.out.println(Arrays.toString(name.toCharArray()));   //[K, a, r, a, n,  , U, p, a, d, h, y, a, y]

        System.out.println(name.toLowerCase());                    //karan upadhyay

        System.out.println(name.toUpperCase());                    //KARAN UPADHYAY
              
        System.out.println(name.indexOf('p'));                  //7

        System.out.println(name.concat(" is a good boy"));     //Karan Upadhyay is a good boy

        System.out.println(name.substring(0, 5));        //Karan

        System.out.println(name.charAt(8));                  //a

        System.out.println(name);                                  //Karan Upadhyay , i.e; name will always be this because strings are immutable
                                                                   // orignal object will not change
    }
}
