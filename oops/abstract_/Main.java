package oops.abstract_;

abstract class Animal{
    abstract void makeSound();   //declared without implementation
}

class Dog extends Animal{
    void makeSound(){
        System.out.println("Bark!!");
    }
}

class Cat extends Animal{
    void makeSound(){
        System.out.println("Meow!!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.makeSound();
        cat.makeSound();
    }
}
