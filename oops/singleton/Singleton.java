// a singleton class is a class which has only one object.
//this class disallows the creation of more than one class by disallowing/not using the constructor method(as it creates new object)
//this can be done by making the constructor class private

package oops.singleton;

public class Singleton {
    private Singleton(){

    }

    private static Singleton instance;        //Singleton constructor - we have declared it as private to deny multiple object creation

    public static Singleton getInstance(){
        //check whether only one object is created or not
        if (instance == null){
            instance = new Singleton(); //constructor can be called in the same file as it is private
        }

        return instance;
    }
}
