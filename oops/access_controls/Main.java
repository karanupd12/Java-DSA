
package oops.access_controls;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        A obj = new A(23, 24 ,"Karan" , "Upadhyay");

        //obj.getNum(); //can't access num here but can be accessed in class A as,
        //System.out.println(obj.num);  //num has private access in oops.access_controls.A

        obj.getNum1(); //num1 is accessible everywhere,
        System.out.println(obj.num1);   //num1 has public access in oops.access_controls.A

        obj.getName(); //name is accessible within the same package or subclasses in different packages as,
        System.out.println(obj.name);   //name has protected access in oops.access_controls.A

        obj.getName1(); //name1 is accessible only within "access_controls" package as,
        System.out.println(obj.name1);  //name1 has no access modifier so, it bydefault uses "default" as its modifier

//real example in java :-
    //   ArrayList<Integer> list = new ArrayList<>(23);
    //   list.DEFAULT_CAPACITY;  //'DEFAULT_CAPACITY' has private access in 'java.util.ArrayList' so we can't access it here

    }
}
