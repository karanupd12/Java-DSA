package functions_concepts;

//multiple functions with same name can exist but their parameters must be different
//function overloading(happens at compile time) will occur when their parameters will be exactly same

public class Overloading {
    public static void main(String[] args) {
        fun(19);
        fun("karan");
        fun(23,55);
    }

    static void fun(int a){
        System.out.println(a);
    }

    static void fun (String name){
        System.out.println(name);
    }

    static void fun (int a , int b){
        System.out.println(a+" "+b);
    }
}
