//Interfaces are a kind of replacement of multiple inheritance in java
//by using 'implement' keyword we can add multiple interfaces in a class (the methods written in those interfaces will get inherited in the class).
package oops.interfaces.concept;

interface Brake {
    void brake();
}

interface Engine {
    public static int PRICE = 78000;
    void start();
    void stop();
    void acc();
}
interface Media {
    void start();
    void stop();
}

class Car implements Engine, Brake {
    @Override
    public void brake() {
        System.out.println("I brake like a normal car");
    }

    @Override
    public void start() {
        System.out.println("I start like a normal car");
    }

    @Override
    public void stop() {
        System.out.println("I stop like a normal car");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal car");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.acc();
        car.brake();
        car.stop();
    }
}
