package strings;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b');              //ASCII value = 97 + 98                  //195
        System.out.println("a" + "b");              //adding strings = string concatenation  //ab
        System.out.println((char)('a' + 3));        //print the char of ASCII value 100      //d     
        System.out.println("a" + 1);                //integer will be converted to string that will call tostring()        //a1

//dealing with non primitives
        System.out.println("karan" + new ArrayList<>());               //karan[]
        System.out.println("karan" + new Integer(56));           //karan56
        //System.out.println(new Integer(56)) + new ArrayList<>();     //error - as in java, + operator is only defined between primitives or when there is atleast one string operant among the non primitives
        System.out.println(new Integer(56) + "" + new ArrayList<>());
    }
}
