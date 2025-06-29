package oops.cloning;

//we want to clone human so, we have implement the cloneable interface on it
public class Human implements Cloneable{
    String name;
    int age;

    //normal constructor
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //constructor with other human as parameter
    public Human(Human other) {
        this.name = other.name;
        this.age = other.age;
    }

    public Object clone() throws CloneNotSupportedException{ //CloneNotSupportedException - this exception will occur if we don't implement cloneable interface in class
        return super.clone();
    }


    //throwing an exception in below line means that there is something inside our main class which possess 'CloneNotSupportedException'
    public static void main(String[] args) throws CloneNotSupportedException {

        Human karan = new Human("karan" , 19);
        //Human twin = new Human(karan); creating copy of an object - but using 'new' keyword will take more compilation time , so we use cloning technique

        //in java - cloning can be done via implementing an inbuilt interface called cloneable(present in lang package) on the class which we want to clone(ex : human)

        Human twin = (Human)karan.clone();  //twin will now completely copy human class
        System.out.println(twin.age + " " + twin.name);
    }

}

