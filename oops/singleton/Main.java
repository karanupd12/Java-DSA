package oops.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();

        // all 3 of the reference variable are pointing to just one object,since we can't call the constructor therefore we cannot create new object
    }
}
