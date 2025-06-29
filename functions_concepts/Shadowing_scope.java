package functions_concepts;
/*
>>>shadowing -shadowing occurs when a variable declared in a certain scope (e.g. a local variable) has the same name as a variable in an outer scope (e.g. a global variable). When this happens, the outer variable is said to be shadowed by the inner variable.

>>>In Java, variables are only accessible inside the region they are created. This is called scope.
>>>scope begins when value is initialized to variable(not declared)

understand using code :-*/

public class Shadowing_scope {
    static int x=90;                              // this(outer variable) will be shadowed at line 14
    public static void main(String[] args){
        System.out.println(x);                    // 90
        int x=40;                                 // the class variable at line 11 is shadowed by this inner variable
        System.out.println(x);                    // 40
        fun(); 
    }

    static void fun(){
        System.out.println(x);                    // 90 //shadowing dissappears as it won't work outside the scope 
    }
}

/*  output:-

  >>>  90  (initially given)
  >>>  40  (90 got shadowed by 40)
  >>>  90  (we got out of the scope so initial value will be printed)

*/
