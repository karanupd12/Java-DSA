package oops.interfaces.static_interface;

public class Main implements A, B{

    public static void main(String[] args) {
        //static method can't be inherited through interference but can be accessed through interfaces but,
        //static interface method should always have a body
        //and must be called via the interface name
        A.greeting();
        A.fun();

        B.greeting();
        B.fun();
    }
}
