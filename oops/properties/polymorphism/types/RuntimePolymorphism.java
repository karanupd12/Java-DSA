
// program to demonstrate runtime polymorphism

package oops.properties.polymorphism.types;

class Car {
    void run() {
        System.out.println("Running fast");
    }
}

//we can use final keyword to avoid overriding of our method
//    void final run() {
//        System.out.println("Running fast");
//    }

class Ferrari extends Car {
    @Override       //this is used to check whether the method is really overridden or not
    void run(){
        System.out.println("Very fast ,0 to 100 in just 3.2 seconds");
    }

    public static void main(String args[]) {
        Car car = new Ferrari();
        car.run();                 //Very fast ,0 to 100 in just 3.2 seconds
    }
}

