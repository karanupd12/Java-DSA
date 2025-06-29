package functions_concepts;
/*
 syntax for writting a function :-
    return_type function_name(arguments){
        ....body...
        return statement;
    }
 */

import java.util.Arrays;

class Function_creation {

    //declaring and defining function 1 which has "integer" return type
    //a and b are the arguments passed while defining(we will pass valuees of a abd b when we call the method in main function)
    public static int sum(int a, int b){ 
        int sum =a+b;                    
        return sum;                       
    }


    //declaring and defining function 2 which has "String" return type
    public static String greet() {
        String greeting = "how are you";
        return greeting;
    }


    //declaring and defining function 3 which has "String" return type
    public static String swap(int x , int y){
        System.out.println("before swap : "+x+" "+y);
        int temp = x;
        x = y ;
        y = temp;
        return (x+" "+y);
    }


    //changing values using function
    //declaring and defining function 4 which has "String" return type
    public static void change(int[] arr){
        arr[0]=99;
        //the function is only for changing the 0th index,so we will return nothing(that's why we used "void" return type)
    }


    //main function - this is where we will call user defined functions  
    public static void main(String[] args) {
        
        //value of a and b are passed here (a=66,b=48) when we are calling the method in main function
        System.out.println(sum(66,48));                            //calling function 1 

        System.out.println(greet());                                   //calling function 2

        System.out.println("after swap : "+swap(67,23));           //calling function 3

        //create an array and then use change function on it 
        int[] arr={1,2,3,4,5,6};                                       //calling function 4
        change(arr);
        System.out.println(Arrays.toString(arr));                      //converts arrays to string

    }
}
