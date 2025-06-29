package strings;
import java.lang.Math;


public class Preetyprinting {
    //preety printing is used to print data in more desired clean and understandaable way
    public static void main(String[] args) {
        
        float a = 453.1274f;
        System.out.println(a);
        System.out.printf("formatted number is %.2f", a);     //this will print a in formatted way upto 2 decimal point
        System.out.println();

        System.out.println(Math.PI);
        System.out.printf("formatted number is %.2f", Math.PI);
        System.out.println();

        System.out.printf("Hello my name is %s and i am %s" , "karan" , "cool");
    }   
}
