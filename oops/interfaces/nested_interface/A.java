package oops.interfaces.nested_interface;

//please keep in mind that as we move deep inside classes or interface we make methods and classes more protected and confidential
//try to use public or default for the master/super classes and private /protected for the inner/nested ones.

public class A {
    //nested interface
    public interface NestedInterface {
        boolean isOdd(int num);
    }
}

class B implements A.NestedInterface {
    @Override
    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}



