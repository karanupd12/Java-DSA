/*
*StringBuilder is a class in the Java API that provides a mutable sequence of characters. It is used for dynamic string manipulation, such as building strings from many smaller strings or appending new characters to an existing string.

*The principal operations on a StringBuilder are the append and insert methods, which are overloaded so as to accept data of any type. Each effectively converts a given datum to a string and then appends or inserts the characters of that string to the string builder. The append method always adds these characters at the end of the builder; the insert method adds the characters at a specified point.

*stringbuilder are mutable just like arrays, so we can append, insert, replace etc on them
*/

package strings;

public class SB{
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            builder.append(ch);    //this will not createna new object , it will add another char to existing builder object
       }
       System.out.println(builder);

       builder.insert(2,'r');          
       System.out.println(builder);                       // a b r c d e ......x y z

       builder.replace(1,3,"xyz");          // only index 1, 2 will be replaced 
       System.out.println(builder);                       // a x y z c d e ......x y z  

       builder.reverse();                             
       System.out.println(builder);                       //z y x ......z y x a    
    }
}
