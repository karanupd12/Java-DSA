package basic_concepts;
//Type Casting :
public class Type_casting{
    public static void main(String[] args) {
        //typecasting is simply type conversion but the type (in left side) should be greater or equal to that of the right side therfore this is how we change type of small to big(i.e; int to float)
        int num = (int)(67.56f);
        System.out.println(num); 
        
        //automatic type promotion in expression
        int a = 257;
        byte b=(byte)(a);
        System.out.println(b); //257 % 256 = 1
    } 
}