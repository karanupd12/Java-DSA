package strings;
/*
 * string is the most used class in the java library
 * strings are immutable, meaning their values cannot be changed once they are created. -- because of security reasons
 */
public class StringsConcept {
    public static void main(String[] args) {
        
        //string creation
        String name1 = "Karan Upadhyay";      //'karan upadhyay' is an object which is stored in 'name' variable which has 'String' datatype
        String name2 = "Karan Upadhyay";     // no new object is created as 'karan upadhyay' already exists in pool in heap memory
        String name3 = new String("Karan Upadhyay"); //for creating a new object outside the pool but in heap

//COMPARISIONS
        System.out.println(name1==name2);     //true    //because strings are immutable and both name1 and name2 are pointing to the same object(karan upadhyay) in the string pool inside heap
        System.out.println(name1==name3);     //false   //because here name3 has a new object created outside pool in line11

        // (.equals) - this method is used only to check value
        System.out.println(name1.equals(name2));     //true  - only value is checked (nzme1=name2=name3="karan upadhyay")
        System.out.println(name1.equals(name3));     //true  -    ""   ""   ""   ""   ""   ""   ""   ""   ""   ""   ""  
        
//STRING OPERATIONS
        //System.out.println(name1[0]);              //error = will not work
        System.out.println(name1.charAt(0));   // K
    }
}
