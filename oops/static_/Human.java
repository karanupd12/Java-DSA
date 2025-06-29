//note :- Since objects are created at runtime and static variable methods does'nt deal or depend on object , therefore static methods are resolved at compile time(not runtime)
package oops.static_;
public class Human{
    String name;
    int age;
    int salary;
    boolean married;
    static long population;  //dealing with the static variable(defined for object as well as class)
    static void message(){
        System.out.println("Hello World !!");
//        System.out.println(this.age);  we cannot use 'this(a reference to the object)' inside the static defined method because static does not depend on object(only depend on class)
    }

    //constructor of human(multiple humans can be made directly using this human function having name , age , salary , marriage as properties)
    public Human(String name, int age, int salary, boolean married) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.married = married;
        //static variable is always declared, accessed, and manipulated by class name (it can also be accessed by object name , but its not right convention)
        Human.population += 1;
        Human.message();
    }
}
