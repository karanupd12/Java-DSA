package oops.exception_handling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        //System.out.println(a/b); error in terminal - Exception in thread "main" java.lang.ArithmeticException
        try{
            divide(a, b);
        }
        catch(Exception e){      //if we found any arithmetic exception in our try block
            System.out.println(e.getMessage()); //this prints the description of the exception
        }
        finally{
            System.out.println("this will always execute");
        }
    }


    static int divide(int a, int b) throws ArithmeticException{
        if (b==0){
            //we can also throw a custom description for the caught exception
            throw new ArithmeticException("please do not divide by 0");
        }
        return a/b;
    }
}
