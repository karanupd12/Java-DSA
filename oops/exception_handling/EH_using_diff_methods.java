package oops.exception_handling;

public class EH_using_diff_methods {
    public static void main(String[] args) {


        //method-1   using - .printStackTrace()
        int a=5;
        int b=0;
        try{
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            e.printStackTrace();
        }
        //O/P : java.lang.ArithmeticException: / by zero
        //	at oops.exception_handling.Main2.main(Main2.java:8)



        //method-2   using - .toString()
        int c=8;
        int d=0;
        try{
            System.out.println(c/d);
        }
        catch(ArithmeticException e){
            System.out.println(e.toString());
        }
        //O/P : java.lang.ArithmeticException: / by zero



        //method-3   using - .getMessage()
        int p=5;
        int q=0;
        try{
            System.out.println(p/q);
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        //O/P : / by zero

    }
}
