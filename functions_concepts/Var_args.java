package functions_concepts;
import java.util.Arrays;

//variable arguments(var args) is when we create a method which has variable no. of arguments
//it is applied when we do not know how many inputs we are going to take

public class Var_args {
    public static void main(String[] args) {
        fun(23,45,55,66,44,23,54,82);   //we can enter n no. of integers here
        multiple(33,45, "karan" , "Btown" , "jaadu" , "dhol");
    }


    static void fun(int ...v){             //this will take multiple numbers as input and by defaul will store it as array(L9)
        System.out.println(Arrays.toString(v));
    }

    static void multiple(int a,int b, String...v){  //first it will take 2 integers and then multiple strings(L10)
        System.out.println( );
    }
}

/* Output :-

 >>> [23, 45, 55, 66, 44, 23, 54, 82]

 */